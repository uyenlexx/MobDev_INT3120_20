package com.example.slide12.network;

import android.content.Context;
import android.content.IntentFilter;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.slide12.R;
import com.google.android.material.snackbar.Snackbar;

public class NetworkActivity extends AppCompatActivity implements ConnectionReceiver.ReceiverListener {
    Button btn_check;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network);

        btn_check = findViewById(R.id.btn_check);
        checkConnection();
        btn_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // call method
                checkConnection();
            }
        });
    }

    private void checkConnection() {
        IntentFilter intentFilter = new IntentFilter();
        // add action
        intentFilter.addAction("android.new.conn.CONNECTIVITY_CHANGE");

        // register receiver
        registerReceiver(new ConnectionReceiver(), intentFilter);

        // Initialize listener
        ConnectionReceiver.Listener = this;

        // Initialize connectivity manager
        ConnectivityManager manager = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);

        // Initialize network info
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();

        // get connection status
        boolean isConnected = networkInfo != null && networkInfo.isConnectedOrConnecting();

        if (isConnected)
            Toast.makeText(this, "Connected", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "Disconnected", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNetworkChange(boolean isConnected) {
        if (isConnected)
            Toast.makeText(this, "Connected", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "Disconnected", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        // call method
        checkConnection();
    }

    @Override
    protected void onPause() {
        super.onPause();
        // call method
        checkConnection();
    }
}