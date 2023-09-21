package com.example.slide7_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class ContactActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        String myData = "content://contact/people/";
        Intent myActivity2 = new Intent(Intent.ACTION_VIEW, Uri.parse(myData));
        startActivity(myActivity2);

        String myData2 = "content://contact/people/8";
        Intent myActivity3= new Intent(Intent.ACTION_VIEW, Uri.parse(myData));
        startActivity(myActivity3);
    }
}