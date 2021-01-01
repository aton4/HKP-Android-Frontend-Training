package com.example.fragmentsrecyclerviewvideo;

import android.app.Application;

import java.util.ArrayList;

public class ApplicationClass extends Application
{
    public static ArrayList<Person> people;

    @Override
    public void onCreate() {
        super.onCreate();

        people = new ArrayList<Person>();
        people.add(new Person("Chuck Nu", "12321321321"));
        people.add(new Person("sads dwae", "45353635457"));
        people.add(new Person("asdasda", "1232132131"));
        people.add(new Person("Chuck Nu", "12321321321"));
        people.add(new Person("sads dwae", "45353635457"));
        people.add(new Person("asdasda", "1232132131"));
        people.add(new Person("Chuck Nu", "12321321321"));
        people.add(new Person("sads dwae", "45353635457"));
        people.add(new Person("asdasda", "1232132131"));
    }
}
