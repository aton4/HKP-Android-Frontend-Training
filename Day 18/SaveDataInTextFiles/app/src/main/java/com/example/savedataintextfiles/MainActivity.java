package com.example.savedataintextfiles;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity {

    EditText etName, etSurname;
    Button btnAdd, btnSave;
    TextView tvResults;
    ArrayList<Person> persons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = (EditText) findViewById(R.id.etName);
        etSurname = (EditText) findViewById(R.id.etSurname);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnSave = (Button) findViewById(R.id.btnSave);
        tvResults = (TextView) findViewById(R.id.tvResults);

        persons = new ArrayList<Person>();

        loadData();

        btnAdd.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                persons.add(new Person(etName.getText().toString().trim(), etSurname.getText().toString().trim()));

                setTextToTextView();
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                try
                {
                    FileOutputStream file = openFileOutput("data.txt", MODE_PRIVATE);
                    OutputStreamWriter outputFile = new OutputStreamWriter(file);

                    for (Person person : persons)
                    {
                        outputFile.write(person.getName() + "," + person.getSurname() + "\n");
                    }
                    outputFile.flush();
                    outputFile.close();

                    Toast.makeText(MainActivity.this, "Successfully saved!", Toast.LENGTH_SHORT).show();
                }
                catch (IOException e)
                {
                    Toast.makeText(MainActivity.this, "IOException", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    protected void setTextToTextView()
    {
        String text = "";
        for (Person person : persons)
        {
            text += person.getName() + " " + person.getSurname() + "\n";
        }

        tvResults.setText(text);
    }

    protected void loadData()
    {
        persons.clear();

        File file = getApplicationContext().getFileStreamPath("Data.txt");
        String lineFromFile;

        if (file.exists())
        {
            try
            {
                BufferedReader reader = new BufferedReader(new InputStreamReader(openFileInput("Data.txt")));

                while ((lineFromFile = reader.readLine()) != null)
                {
                    StringTokenizer tokens = new StringTokenizer(lineFromFile, ",");
                    Person person = new Person(tokens.nextToken(), tokens.nextToken());
                    persons.add(person);
                }

                reader.close();

                setTextToTextView();
            }
            catch (IOException e)
            {
                Toast.makeText(MainActivity.this, "IOException", Toast.LENGTH_SHORT).show();
            }
        }
    }
}