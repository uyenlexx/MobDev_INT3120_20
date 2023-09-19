package com.example.slide7_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;

public class CallActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.call_activity);

        Intent callActivity = new Intent(Intent.ACTION_DIAL);
        callActivity.setData(Uri.parse("tel:0377778888"));
        startActivity(callActivity);
    }
}