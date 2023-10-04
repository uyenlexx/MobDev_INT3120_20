package com.example.slide11;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button play, pause;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        play = (Button) findViewById(R.id.playButton);
        pause = (Button) findViewById(R.id.pauseButton);

        play.setOnClickListener(this::onClick);
        pause.setOnClickListener(this::onClick);
    }

    public void onClick(View view) {
        if (view == play) {
            startService(new Intent(this, MyForegroundService.class));
        } else if (view == pause) {
            stopService(new Intent(this, MyForegroundService.class));
        }
    }
}