package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // calls the parent class's onCreate
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // sends a message in logcat that the app code is currently in onCreate
        Log.d("tag", "In onCreate");
    }

    @Override
    protected void onStart() {
        // calls the parent class's onStart
        super.onStart();

        // sends a message in logcat that the app code is currently in onStart
        Log.d("tag", "In onStart");
    }

    @Override
    protected void onResume() {
        // calls the parent class's onResume
        super.onResume();
        // sends a message in logcat that the app code is currently in onResume
        Log.d("tag", "In onResume");
    }

    @Override
    protected void onPause() {
        // calls the parent class's onPause
        super.onPause();
        // sends a message in logcat that the app code is currently in onPause
        Log.d("tag", "In onPause");
    }

    @Override
    protected void onStop() {
        // calls the parent class's onStop
        super.onStop();
        // sends a message in logcat that the app code is currently in onStop
        Log.d("tag", "In onStop");
    }

    @Override
    protected void onDestroy() {
        // calls the parent class's onDestroy
        super.onDestroy();
        // sends a message in logcat that the app code is currently in onDestroy
        Log.d("tag", "In onDestroy");
    }
}