package com.example.temperaturecricket;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText etInputNumChirps = (EditText) findViewById(R.id.etInputNumChirps);
        Button btnSubmit = (Button) findViewById(R.id.btnSubmit);
        TextView tvResults = (TextView) findViewById(R.id.tvResults);

        tvResults.setVisibility(View.GONE);

        btnSubmit.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                DecimalFormat decimalFormat = new DecimalFormat(".#");

                int inputNumChirps = Integer.parseInt( etInputNumChirps.getText().toString().trim() );
                double degreesCelcius = (inputNumChirps / 3.0) + 4;
                String resultText = getString(R.string.aproxTemperature) + decimalFormat.format(degreesCelcius) + getString(R.string.celcius);

                tvResults.setText(resultText);
                tvResults.setVisibility(View.VISIBLE);
            }
        });
    }
}