package com.example.intentschallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class CreateContactActivity extends AppCompatActivity {

    EditText etContactName;
    EditText etContactNumber;
    EditText etContactWebsite;
    EditText etContactLocation;

    ImageView ivHappy;
    ImageView ivNeutral;
    ImageView ivSad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_contact);

        //set the edittext references
        etContactName = findViewById(R.id.etContactName);
        etContactNumber = findViewById(R.id.etContactNumber);
        etContactWebsite = findViewById(R.id.etContactWebsite);
        etContactLocation = findViewById(R.id.etContactLocation);

        //set tne clickable imageviews
        ivHappy = findViewById(R.id.ivHappy);
        ivNeutral = findViewById(R.id.ivNeutral);
        ivSad = findViewById(R.id.ivSad);

        //create onclicklisteners for all the clickable imageviews
        ivHappy.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //create strings for Uri.parse
                String contactNumberString = getString(R.string.tel) + etContactNumber.getText().toString().trim();
                String contactWebsiteString = getString(R.string.http) + etContactWebsite.getText().toString().trim();
                String contactLocationString = getString(R.string.geo) + etContactLocation.getText().toString().trim();

                //store strings for intent buttons (phone, website, location) and store image resource ID
                Intent intent = new Intent();
                intent.putExtra(getString(R.string.contact_number), contactNumberString);
                intent.putExtra(getString(R.string.contact_website), contactWebsiteString);
                intent.putExtra(getString(R.string.contact_location), contactLocationString);
                intent.putExtra(getString(R.string.contact_face_res_ID), R.drawable.ic_baseline_mood_24);

                setResult(RESULT_OK, intent);
                CreateContactActivity.this.finish();
            }
        });

        ivNeutral.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //create strings for Uri.parse
                String contactNumberString = getString(R.string.tel) + etContactNumber.getText().toString().trim();
                String contactWebsiteString = getString(R.string.http) + etContactWebsite.getText().toString().trim();
                String contactLocationString = getString(R.string.geo) + etContactLocation.getText().toString().trim();

                //store strings for intent buttons (phone, website, location) and store image resource ID
                Intent intent = new Intent();
                intent.putExtra(getString(R.string.contact_number), contactNumberString);
                intent.putExtra(getString(R.string.contact_website), contactWebsiteString);
                intent.putExtra(getString(R.string.contact_location), contactLocationString);
                intent.putExtra(getString(R.string.contact_face_res_ID), R.drawable.ic_baseline_sentiment_satisfied_24);

                setResult(RESULT_OK, intent);
                CreateContactActivity.this.finish();
            }
        });

        ivSad.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //create strings for Uri.parse
                String contactNumberString = getString(R.string.tel) + etContactNumber.getText().toString().trim();
                String contactWebsiteString = getString(R.string.http) + etContactWebsite.getText().toString().trim();
                String contactLocationString = getString(R.string.geo) + etContactLocation.getText().toString().trim();

                //store strings for intent buttons (phone, website, location) and store image resource ID
                Intent intent = new Intent();
                intent.putExtra(getString(R.string.contact_number), contactNumberString);
                intent.putExtra(getString(R.string.contact_website), contactWebsiteString);
                intent.putExtra(getString(R.string.contact_location), contactLocationString);
                intent.putExtra(getString(R.string.contact_face_res_ID), R.drawable.ic_baseline_mood_bad_24);

                setResult(RESULT_OK, intent);
                CreateContactActivity.this.finish();
            }
        });
    }
}