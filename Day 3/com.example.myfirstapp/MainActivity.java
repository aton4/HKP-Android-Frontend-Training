package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("tag", "In onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("tag", "In onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("tag", "In onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("tag", "In onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("tag", "In onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("tag", "In onDestroy");
    }
}