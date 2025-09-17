package com.example.m11;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity3 extends AppCompatActivity {
    BottomNavigationView menu;
    Button exitButton,logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        menu=findViewById(R.id.bottom_navigation);
        exitButton = findViewById(R.id.exit);
        TextView name = findViewById(R.id.user_text);
        logout = findViewById(R.id.logout);
        SharedPreferences sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE);
        String savedName = sharedPreferences.getString("uname", "User");
        name.setText("Welcome " + savedName);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean("isLoggedIn", false);
                editor.apply();

                Toast.makeText(MainActivity3.this, "Logged out successfully", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(MainActivity3.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        menu.setOnItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.menuhome) {
                Intent intent = new Intent(MainActivity3.this, MainActivity.class);
                startActivity(intent);
                return true;
            }
            if (id == R.id.menulogin) {
                Intent intent = new Intent(MainActivity3.this, MainActivity2.class);
                startActivity(intent);
                return true;
            }
            if (id == R.id.menudash) {
                Intent intent = new Intent(MainActivity3.this, MainActivity3.class);
                startActivity(intent);
                return true;
            }
            return false;
        });

        exitButton.setOnClickListener(v -> {
            finishAffinity();
            System.exit(0);
        });
    }
}