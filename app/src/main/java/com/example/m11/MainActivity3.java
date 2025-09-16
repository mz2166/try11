package com.example.m11;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity3 extends AppCompatActivity {
    Button exit,logout;

    BottomNavigationView menu;
    Button exitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        menu=findViewById(R.id.bottom_navigation);
        exitButton = findViewById(R.id.exit);

        menu.setOnItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.menuhome) {
                // Stay on current activity or do something
                return true;
            } else if (id == R.id.menulogin) {
                // Use intent to navigate to SecondActivity
                Intent intent = new Intent(MainActivity3.this, MainActivity2.class);
                startActivity(intent);
                return true;

            }
            if (id == R.id.menuhome) {
                // Use intent to navigate to SecondActivity
                Intent intent = new Intent(MainActivity3.this, MainActivity.class);
                startActivity(intent);
                return true;
            }
            return false;

        });

        exitButton.setOnClickListener(v -> {
            finishAffinity(); // Closes all activities and exits the app
            System.exit(0);   // Optional: ensures JVM exits
        });
    }
}