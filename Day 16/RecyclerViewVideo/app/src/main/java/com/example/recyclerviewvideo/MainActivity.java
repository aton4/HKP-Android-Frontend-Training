package com.example.recyclerviewvideo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements PersonAdapter.ItemClicked {

    RecyclerView recyclerView;
    RecyclerView.Adapter myAdapter;
    RecyclerView.LayoutManager layoutManager;

    ArrayList<Person> people;

    Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.list);
        recyclerView.setHasFixedSize(true);

        btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                people.add(new Person("Petter", "potter", "plane"));
                myAdapter.notifyDataSetChanged();
            }
        });

        layoutManager = new LinearLayoutManager(this);
        // layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        // layoutManager = new LinearLayoutManager(this, 2, GridLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);

        people = new ArrayList<Person>();
        people.add(new Person("John", "Wick", "bus"));
        people.add(new Person("Chuclk", "Mori", "bus"));
        people.add(new Person("Petter", "potter", "plane"));
        people.add(new Person("TOm", "candleWick", "plane"));
        people.add(new Person("John", "Wick", "bus"));
        people.add(new Person("Chuclk", "Mori", "bus"));
        people.add(new Person("Petter", "potter", "plane"));
        people.add(new Person("TOm", "candleWick", "plane"));
        people.add(new Person("John", "Wick", "bus"));
        people.add(new Person("Chuclk", "Mori", "bus"));
        people.add(new Person("Petter", "potter", "plane"));
        people.add(new Person("TOm", "candleWick", "plane"));
        people.add(new Person("John", "Wick", "bus"));
        people.add(new Person("Chuclk", "Mori", "bus"));
        people.add(new Person("Petter", "potter", "plane"));
        people.add(new Person("TOm", "candleWick", "plane"));
        people.add(new Person("John", "Wick", "bus"));
        people.add(new Person("Chuclk", "Mori", "bus"));
        people.add(new Person("Petter", "potter", "plane"));
        people.add(new Person("TOm", "candleWick", "plane"));
        people.add(new Person("John", "Wick", "bus"));
        people.add(new Person("Chuclk", "Mori", "bus"));
        people.add(new Person("Petter", "potter", "plane"));
        people.add(new Person("TOm", "candleWick", "plane"));

        myAdapter = new PersonAdapter(this, people);

        recyclerView.setAdapter(myAdapter);
    }

    @Override
    public void onItemClicked(int index) {
        Toast.makeText(this, "Surname: " + people.get(index).getSurname(), Toast.LENGTH_SHORT).show();
    }
}