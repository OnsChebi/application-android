package com.example.miniprojet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Delayed navigation to LoginActivity after the initial fragment has been displayed
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Create an intent to start the LoginActivity
                Intent loginIntent = new Intent(MainActivity.this, LoginActivity.class);
                // Start the LoginActivity
                startActivity(loginIntent);
            }
        }, 2500); // Delay of 2500 milliseconds (2.5 seconds)
    }
}
