package com.example.m11;

import static java.security.AccessController.getContext;

import android.app.Activity;
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

import java.util.zip.Inflater;

public class MainActivity2 extends AppCompatActivity {
    Button log;
    EditText name,pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EditText name =findViewById(R.id.name);
        EditText pass = findViewById(R.id.pass);
        log=findViewById(R.id.log);
        name=findViewById(R.id.name);
        pass=findViewById(R.id.pass);
            String username = name.getText().toString();
            String password = pass.getText().toString();
            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText( this,"Please fill in both fields", Toast.LENGTH_SHORT).show();
            } else {
                if (username.equals("admin") && password.equals("admin")) {
                    Toast.makeText(this, "Logged in successfully", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "wrong info", Toast.LENGTH_SHORT).show();
                }
            }

    }


}