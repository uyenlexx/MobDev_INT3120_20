package com.example.slide7_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class SendMessageActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_message);

        Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:0123456789"));
        intent.putExtra("sms_body", "Hello");
        startActivity(intent);
    }
}