package com.example.slide7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GreetingActivity extends AppCompatActivity {
    Button backBtn;
    String fullName;
    String message;
    TextView textViewMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greeting);

        textViewMessage = findViewById(R.id.greeting2);

        backBtn = findViewById(R.id.back_btn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goBack();
            }
        });

        Intent intent = getIntent();
        fullName = intent.getStringExtra("fullName");
        message = intent.getStringExtra("message");
        textViewMessage.setText(this.message);
    }

    public void goBack() {
        this.onBackPressed();
    }

    @Override
    public void finish() {
        Intent data = new Intent();
        String feedback = "OK, Hello " + this.fullName + ". How are you?";
        data.putExtra("feedback", feedback);

        setResult(RESULT_OK, data);
        super.finish();
    }
}