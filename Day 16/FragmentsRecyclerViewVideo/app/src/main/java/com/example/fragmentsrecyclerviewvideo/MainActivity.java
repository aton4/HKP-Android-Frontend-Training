package com.example.fragmentsrecyclerviewvideo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements PersonAdapter.ItemClicked{
    TextView tvName;
    TextView tvTel;

    EditText etName;
    EditText etTel;
    Button btnAddPerson;
    ListFragment listFragment;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvName = findViewById(R.id.tvName);
        tvTel = findViewById(R.id.tvTel);

        etName = findViewById(R.id.etName);
        etTel = findViewById(R.id.etTel);
        btnAddPerson = findViewById(R.id.btnAddPerson);

        fragmentManager = this.getSupportFragmentManager();
        listFragment = (ListFragment) fragmentManager.findFragmentById(R.id.listFragment);

        btnAddPerson.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (etName.getText().toString().isEmpty() || etTel.getText().toString().isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Please enter all fields!", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    ApplicationClass.people.add(new Person(etName.getText().toString().trim(), etTel.getText().toString().trim()));
                    Toast.makeText(MainActivity.this, "Person successfully added!", Toast.LENGTH_SHORT).show();

                    etName.setText(null);
                    etTel.setText(null);
                    listFragment.notifyDataChanged();
                }
            }
        });

        onItemClicked(0);
    }

    @Override
    public void onItemClicked(int index)
    {
        tvName.setText(ApplicationClass.people.get(index).getName());
        tvTel.setText(ApplicationClass.people.get(index).getTelNr());
    }
}