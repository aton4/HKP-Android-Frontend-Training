package com.example.smsexamplevideo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etMessage;
    EditText etTelNr;
    Button btnSend;
    int MY_PERMISSIONS_REQUEST_SEND_SMS = 1;

    String SENT = "SMS_SENT";
    String DELIVERED = "SMS_DELIVERED";
    PendingIntent sentPI, deliveredPI;
    BroadcastReceiver smsSentReciever, smsDeliveredReciever;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etMessage = (EditText) findViewById(R.id.etMessage);
        etTelNr = (EditText) findViewById(R.id.etTelNr);
        btnSend = (Button) findViewById(R.id.btnSend);

        sentPI = PendingIntent.getBroadcast(this, 0, new Intent(SENT), 0);
        deliveredPI = PendingIntent.getBroadcast(this, 0, new Intent(DELIVERED), 0);

        btnSend.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String message = etMessage.getText().toString();
                String telNr = etTelNr.getText().toString();

                if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED)
                {
                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.SEND_SMS}, MY_PERMISSIONS_REQUEST_SEND_SMS);
                }
                else
                {
                    SmsManager sms = SmsManager.getDefault();
                    sms.sendTextMessage(telNr, null, message, sentPI, deliveredPI);
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        smsSentReciever = new BroadcastReceiver()
        {
            @Override
            public void onReceive(Context context, Intent intent)
            {
                switch (getResultCode())
                {
                    case Activity.RESULT_OK:
                        Toast.makeText(MainActivity.this, "SMS sent!", Toast.LENGTH_SHORT).show();
                        break;
                    case SmsManager.RESULT_ERROR_GENERIC_FAILURE:
                        Toast.makeText(MainActivity.this, "Generic Failure!", Toast.LENGTH_SHORT).show();
                        break;
                    case SmsManager.RESULT_ERROR_NO_SERVICE:
                        Toast.makeText(MainActivity.this, "No Service!", Toast.LENGTH_SHORT).show();
                        break;
                    case SmsManager.RESULT_ERROR_NULL_PDU:
                        Toast.makeText(MainActivity.this, "Null PDU!", Toast.LENGTH_SHORT).show();
                        break;
                    case SmsManager.RESULT_ERROR_RADIO_OFF:
                        Toast.makeText(MainActivity.this, "Radio off!", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        };

        smsDeliveredReciever = new BroadcastReceiver()
        {
            @Override
            public void onReceive(Context context, Intent intent)
            {
                switch (getResultCode())
                {
                    case Activity.RESULT_OK:
                        Toast.makeText(MainActivity.this, "SMS delivered!", Toast.LENGTH_SHORT).show();
                        break;
                    case Activity.RESULT_CANCELED:
                        Toast.makeText(MainActivity.this, "SMS not delivered!", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        };

        registerReceiver(smsSentReciever, new IntentFilter(SENT));
        registerReceiver(smsDeliveredReciever, new IntentFilter(DELIVERED));
    }

    @Override
    protected void onPause() {
        super.onPause();

        unregisterReceiver(smsSentReciever);
        unregisterReceiver(smsDeliveredReciever);
    }
}