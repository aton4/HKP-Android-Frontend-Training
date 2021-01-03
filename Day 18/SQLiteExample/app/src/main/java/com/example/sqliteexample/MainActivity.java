package com.example.sqliteexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.SQLException;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etName, etCell;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = (EditText) findViewById(R.id.etName);
        etCell = (EditText) findViewById(R.id.etCell);
    }

    public void btnSubmit(View v)
    {
        String name = etName.getText().toString().trim();
        String cell = etCell.getText().toString().trim();

        try
        {
            ContactsDb db = new ContactsDb(this);
            db.open();
            db.createEntry(name, cell);
            db.close();

            Toast.makeText(this, "Successfully saved!", Toast.LENGTH_SHORT).show();
            etName.setText("");
            etCell.setText("");
        }
        catch (SQLException e)
        {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }

    public void btnShowData(View v)
    {
        startActivity(new Intent(this, Data.class));
    }

    public void btnEditData(View v)
    {
        try
        {
            ContactsDb db = new ContactsDb(this);
            db.open();
            db.updateEntry("1", "name", "123124");
            db.close();

            Toast.makeText(this, "Successfully saved!", Toast.LENGTH_SHORT).show();
        }
        catch (SQLException e)
        {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public void btnDeleteData(View v)
    {
        try
        {
            ContactsDb db = new ContactsDb(this);
            db.open();
            db.deleteEntry("1");
            db.close();

            Toast.makeText(this, "Successfully deleted!", Toast.LENGTH_SHORT).show();
        }
        catch (SQLException e)
        {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}