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
        EditText name = findViewById(R.id.name);
        EditText pass = findViewById(R.id.pass);
        Button log=findViewById(R.id.log);
        setContentView(R.layout.activity_main2);
        menu = findViewById(R.id.bottom_navigation);
        menu.setOnItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.menuhome) {
                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(intent);
                return true;
            }
            if (id == R.id.menulogin) {
                Intent intent = new Intent(MainActivity2.this, MainActivity2.class);
                startActivity(intent);
                return true;
            }
            if (id == R.id.menudash) {
                Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                startActivity(intent);
                return true;
            }

            return false;
        });
        SharedPreferences preferences=getSharedPreferences("UserPrefs",MODE_PRIVATE);
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uname = name.getText().toString().trim();
                String pas = pass.getText().toString().trim();
                SharedPreferences.Editor edetor = preferences.edit();
                if (uname.isEmpty() || pas.isEmpty()) {
                    Toast.makeText(MainActivity2.this, "Please fill in both fields", Toast.LENGTH_SHORT).show();
                }
                else {
                    edetor.putString("uname",uname);
                    edetor.putString("pas",pas);
                    edetor.apply();
                }
            }
        });
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String saved_username = preferences.getString("uname",null);
                String saved_password = preferences.getString("pas",null);

                String username = name.getText().toString().trim();
                String password = pass.getText().toString().trim();
                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(MainActivity2.this, "Please fill in both fields", Toast.LENGTH_SHORT).show();
                } else {
                    if (saved_username.equals(username)&&saved_password.equals(password)) {
                        Toast.makeText(MainActivity2.this, "Logged in successfully", Toast.LENGTH_SHORT).show();
                        SharedPreferences.Editor editor = preferences.edit();
                        editor.putBoolean("isLoggedIn", true);
                        Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                        startActivity(intent);
                        finish();
                    }
                    else {
                        Toast.makeText(MainActivity2.this, "sign up first", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }


}