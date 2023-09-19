package com.example.slide7_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class ImageActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        Intent myIntent = new Intent();
        myIntent.setType("image/pictures/*");
        myIntent.setAction(Intent.ACTION_GET_CONTENT);

        startActivity(myIntent);
    }
}