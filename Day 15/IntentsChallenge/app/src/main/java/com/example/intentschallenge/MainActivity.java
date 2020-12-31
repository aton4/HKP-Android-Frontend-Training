package com.example.intentschallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView ivFace;
    ImageView ivPhone;
    ImageView ivWebpage;
    ImageView ivLocation;

    Button btnNewContact;

    int contactFaceResID;

    String contactNumUri;
    String contactUrl;
    String contactLocation;

    final int CREATE_CONTACT_ACTIVITY_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // set View references
        ivFace = findViewById(R.id.ivFace);
        ivPhone = findViewById(R.id.ivPhone);
        ivWebpage = findViewById(R.id.ivWebpage);
        ivLocation = findViewById(R.id.ivLocation);

        btnNewContact = findViewById(R.id.btnNewContact);

        // initialize all contact data to 0 or null
        contactFaceResID = 0;

        contactNumUri = null;
        contactUrl = null;
        contactLocation = null;

        // make all contact interactions invisible until user creates contact
        ivFace.setVisibility(View.GONE);
        ivPhone.setVisibility(View.GONE);
        ivWebpage.setVisibility(View.GONE);
        ivLocation.setVisibility(View.GONE);

        // button onclicklisteners for all contact interactions
        ivPhone.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse(contactNumUri));
                startActivity(intent);
            }
        });

        ivWebpage.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(contactUrl));
                startActivity(intent);
            }
        });

        ivLocation.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(contactLocation));
                startActivity(intent);
            }
        });

        btnNewContact.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(MainActivity.this, com.example.intentschallenge.CreateContactActivity.class);
                startActivityForResult(intent, CREATE_CONTACT_ACTIVITY_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CREATE_CONTACT_ACTIVITY_CODE)
        {
            if (resultCode == RESULT_OK)
            {
                // store contact data for use in user interactions
                contactNumUri = data.getStringExtra(getString(R.string.contact_number));
                contactUrl = data.getStringExtra(getString(R.string.contact_website));
                contactLocation = data.getStringExtra(getString(R.string.contact_location));
                contactFaceResID = data.getIntExtra(getString(R.string.contact_face_res_ID), -1);

                // set the contact face status
                ivFace.setImageResource(contactFaceResID);
                ivFace.setVisibility(View.VISIBLE);

                // make user interactions visible
                ivPhone.setVisibility(View.VISIBLE);
                ivWebpage.setVisibility(View.VISIBLE);
                ivLocation.setVisibility(View.VISIBLE);
            }
        }
    }
}