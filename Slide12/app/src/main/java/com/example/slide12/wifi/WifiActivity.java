package com.example.slide12.wifi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.slide12.R;

public class WifiActivity extends AppCompatActivity {
    Button turnOnWifi, turnOffWifi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wifi);

        turnOnWifi = (Button) findViewById(R.id.turnOn_btn);
        turnOnWifi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WifiManager wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
                wifiManager.setWifiEnabled(true);
                Toast.makeText(WifiActivity.this, "Wifi is on", Toast.LENGTH_SHORT).show();
            }
        });

        turnOffWifi = (Button) findViewById(R.id.turnOff_btn);
        turnOffWifi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WifiManager wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
                wifiManager.setWifiEnabled(false);
                Toast.makeText(WifiActivity.this, "Wifi is off", Toast.LENGTH_SHORT).show();
            }
        });
    }

}