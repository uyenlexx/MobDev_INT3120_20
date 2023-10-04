package com.example.slide11_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button text = findViewById(R.id.text);
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (text.getText().toString().equals("Started")) {
                    text.setText("Stoped");
                    stopService(new Intent(MainActivity.this, MyBackgroundService.class));
                } else {
                    text.setText("Started");
                    startService(new Intent(MainActivity.this, MyBackgroundService.class));
                }
            }
        });
    }
}