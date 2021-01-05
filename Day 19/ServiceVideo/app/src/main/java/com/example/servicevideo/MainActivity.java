package com.example.servicevideo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements MusicStoppedListener{

    ImageView ivPlayStop;
    // link containing mp3 song
    String audioLink = "https://dl.dropbox.com/s/5ey5xwb7a5ylqps/games_of_thrones.mp3?dl=0";
    boolean musicPlaying = false;
    Intent serviceIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initialize the image view
        ivPlayStop = (ImageView) findViewById(R.id.ivPlayStop);
        ivPlayStop.setBackgroundResource(R.drawable.play_foreground);
        // create content to start service
        serviceIntent = new Intent(this, MyPlayService.class);

        ApplicationClass.context = (Context) MainActivity.this;

        ivPlayStop.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                // plays or stops the server depending on whether the music is already playing
                if (!musicPlaying)
                {
                    playAudio();
                    ivPlayStop.setImageResource(R.drawable.stop_foreground);
                    musicPlaying = true;
                }
                else
                {
                    stopPlayService();
                    ivPlayStop.setImageResource(R.drawable.play_foreground);
                    musicPlaying = false;
                }
            }
        });
    }

    // starts playing the music
    private void playAudio()
    {
        serviceIntent.putExtra("AudioLink", audioLink);

        try
        {
            startService(serviceIntent);
        }
        catch (SecurityException e)
        {
            Toast.makeText(this, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    // starts the music player service
    private void stopPlayService()
    {
        try
        {
            stopService(serviceIntent);
        }
        catch (SecurityException e)
        {
            Toast.makeText(this, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    // when music stops via running to the end, set the image back to the play button
    @Override
    public void onMusicStopped() {
        ivPlayStop.setImageResource(R.drawable.play_foreground);
        musicPlaying = false;
    }
}