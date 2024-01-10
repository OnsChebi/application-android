package com.example.miniprojet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class nav extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav);

    }
   public void openprofile(View v){
       Intent intent = getIntent();
       String nameUser = intent.getStringExtra("name");
       String emailUser = intent.getStringExtra("email");
       String usernameUser = intent.getStringExtra("username");
       String passwordUser = intent.getStringExtra("password");
       Intent i = new Intent(nav.this, UserProfile.class);
       i.putExtra("name1", nameUser);
       i.putExtra("email1", emailUser);
       i.putExtra("username1", usernameUser);
       i.putExtra("password1", passwordUser);
       startActivity(i);

   }
    public void opencert(View v){
        Intent i = new Intent(nav.this, certifications.class);
        startActivity(i);
    }

    public void logout(View v){
        Intent i = new Intent(nav.this, LoginActivity.class);
        startActivity(i);
        Toast.makeText(this,
                "Successfully logged out",
                Toast.LENGTH_LONG).show();
    }
}