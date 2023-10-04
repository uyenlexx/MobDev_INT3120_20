package com.example.slide11;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.Settings;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyForegroundService extends Service {
    private MediaPlayer player;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "Service started", Toast.LENGTH_SHORT).show();
        player = MediaPlayer.create(this, Settings.System.DEFAULT_NOTIFICATION_URI);
        player.setLooping(true);
        player.start();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this, "Service stopped", Toast.LENGTH_SHORT).show();
        super.onDestroy();
        player.stop();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
