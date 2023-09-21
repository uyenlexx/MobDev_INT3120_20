package com.example.slide6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.core.view.MenuItemCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.SearchView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent();

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.menu_search)
                    Toast.makeText(MainActivity.this, "Search", Toast.LENGTH_SHORT).show();
                else if (itemId == R.id.menu_settings)
                    Toast.makeText(MainActivity.this, "Setting", Toast.LENGTH_SHORT).show();
                else if (itemId == R.id.menu_profile)
                    Toast.makeText(MainActivity.this, "Profile", Toast.LENGTH_SHORT).show();
                else if (itemId == R.id.menu_home)
                    Toast.makeText(MainActivity.this, "Home", Toast.LENGTH_SHORT).show();
                else if (itemId == R.id.menu_exit)
                    Toast.makeText(MainActivity.this, "Exit", Toast.LENGTH_SHORT).show();
                else if (itemId == R.id.menu_activity2) {
                    Intent intent1 = new Intent(MainActivity.this, SecondActivity.class);
                    startActivity(intent1);
                }
                else if (itemId == R.id.menu_activity3) {
                    Intent intent2 = new Intent(MainActivity.this, ThirdActivity.class);
                    startActivity(intent2);
                }
                return false;
            }
        });
    }

    @SuppressLint("RestrictedApi")
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);
        if (menu instanceof MenuBuilder) {
            MenuBuilder m = (MenuBuilder) menu;
            m.setOptionalIconsVisible(true);
        }
        return true;
    }
}