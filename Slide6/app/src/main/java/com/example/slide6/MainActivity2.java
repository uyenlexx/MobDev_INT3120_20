package com.example.slide6;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button btnContextMenu = findViewById(R.id.button);
        registerForContextMenu(btnContextMenu);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View view, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, view, menuInfo);
        menu.setHeaderTitle("Context Menu");
        MenuInflater inflater = getMenuInflater();
        menu.setHeaderTitle("Context Menu");
        inflater.inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(android.view.MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.menu_upload)
            Toast.makeText(this, "Upload", Toast.LENGTH_SHORT).show();
        else if (itemId == R.id.menu_bookmark)
            Toast.makeText(this, "Bookmark", Toast.LENGTH_SHORT).show();
        else if (itemId == R.id.menu_share)
            Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show();
        else if (itemId == R.id.share1)
            Toast.makeText(this, "Share Facebook", Toast.LENGTH_SHORT).show();
        else if (itemId == R.id.share2)
            Toast.makeText(this, "Share Instagram", Toast.LENGTH_SHORT).show();
        return super.onContextItemSelected(item);
    }
}
