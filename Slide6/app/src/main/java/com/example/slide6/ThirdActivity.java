package com.example.slide6;

import static android.view.inputmethod.EditorInfo.*;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ThirdActivity extends AppCompatActivity {
    private EditText nameEditText;
    private EditText phoneEditText;
    private Button exitBtn;
    private Button smsBtn;
    private RadioGroup option1;
    private RadioGroup option2;
    List<CheckBox> items = new ArrayList<CheckBox>();
    private TextView orderList;
    private String order1String = "";
    private String order2String = "";
    private String otherString = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        //Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Order");
        toolbar.setTitleTextColor(Color.WHITE);

        //EditText
        nameEditText = findViewById(R.id.name);
        phoneEditText = findViewById(R.id.phone);
        //When finish, close soft keyboard
        nameEditText.setOnEditorActionListener((v, actionID, event) -> {
            if (actionID == IME_ACTION_DONE || actionID == IME_ACTION_NEXT) {
                InputMethodManager i = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                i.hideSoftInputFromWindow(v.getWindowToken(), 0);
                return true;
            }
            return false;
        });
        phoneEditText.setOnEditorActionListener((v, actionID, event) -> {
            if (actionID == IME_ACTION_DONE || actionID == IME_ACTION_NEXT) {
                InputMethodManager i = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                i.hideSoftInputFromWindow(v.getWindowToken(), 0);
                return true;
            }
            return false;
        });
    }
}