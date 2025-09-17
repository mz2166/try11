package com.example.m11;

import static java.security.AccessController.getContext;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.zip.Inflater;

public class MainActivity2 extends AppCompatActivity {

    BottomNavigationView menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences preferences = getSharedPreferences("UserPrefs", MODE_PRIVATE);

        if (preferences.getString("uname", null) == null) {
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("uname", "admin");
            editor.putString("pas", "1234");
            editor.apply();
        }

        boolean isLoggedIn = preferences.getBoolean("isLoggedIn", false);

        if (isLoggedIn) {
            // Skip login if already logged in
            Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
            startActivity(intent);
            finish();
            return;
        }

        setContentView(R.layout.activity_main2);

        EditText name = findViewById(R.id.name);
        EditText pass = findViewById(R.id.pass);
        Button log = findViewById(R.id.log);
        menu = findViewById(R.id.bottom_navigation);

        menu.setOnItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.menuhome) {
                startActivity(new Intent(MainActivity2.this, MainActivity.class));
                return true;
            }
            if (id == R.id.menulogin) {
                // Already here, do nothing
                return true;
            }
            if (id == R.id.menudash) {
                startActivity(new Intent(MainActivity2.this, MainActivity3.class));
                return true;
            }
            return false;
        });

        log.setOnClickListener(v -> {
            String saved_username = preferences.getString("uname", null);
            String saved_password = preferences.getString("pas", null);

            String username = name.getText().toString().trim();
            String password = pass.getText().toString().trim();

            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(MainActivity2.this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
            } else {
                if (saved_username != null && saved_password != null
                        && saved_username.equals(username) && saved_password.equals(password)) {
                    Toast.makeText(MainActivity2.this, "Logged in succesfully", Toast.LENGTH_SHORT).show();

                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putBoolean("isLoggedIn", true);
                    editor.apply();

                    Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                    intent.putExtra("username", username);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(MainActivity2.this, "you need to Sign up", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}