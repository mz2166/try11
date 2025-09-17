package com.example.m11;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;


public class MainActivity extends AppCompatActivity {
    BottomNavigationView myNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myNav=findViewById(R.id.bottom_navigation);
        myNav.setOnItemSelectedListener(item ->  {
            int id = item.getItemId();
            if (id == R.id.menuhome) {
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent);
                return true;
            }
            if (id == R.id.menulogin) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
                return true;
            }
            if (id == R.id.menudash) {
                Intent intent = new Intent(MainActivity.this, MainActivity3.class);
                startActivity(intent);
                return true;
            }

            return false;
        });




    }





}