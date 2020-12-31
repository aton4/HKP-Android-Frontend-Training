package com.example.magicidapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get references to all the views
        EditText etID = (EditText) findViewById(R.id.etID);
        Button btnSubmit = (Button) findViewById(R.id.btnSubmit);
        TextView tvResults = (TextView) findViewById(R.id.tvResults);

        tvResults.setVisibility(View.GONE);

        // set a onclicklistener on the submit button to display the id information to tvResults
        btnSubmit.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String idNumber = etID.getText().toString().trim();
                String dob = idNumber.substring(0, 6); // until position 6 - 1
                int gender = (int) idNumber.charAt(6) - 48;

                String sGender;

                if (gender < 5)
                    sGender = getString(R.string.female);
                else
                    sGender = getString(R.string.male);

                int nationality = (int) idNumber.charAt(10) - 48;

                String sNationality;

                if (nationality == 0)
                    sNationality = getString(R.string.SA_Citizen);
                else
                    sNationality = getString(R.string.Permanent_Resident);

                String resultText = getString(R.string.dob) + dob + getString(R.string.newline)
                        + getString(R.string.gender) + sGender + getString(R.string.newline)
                        + getString(R.string.nationality) + sNationality;

                tvResults.setText(resultText);

                tvResults.setVisibility(View.VISIBLE);
            }
        });
    }
}