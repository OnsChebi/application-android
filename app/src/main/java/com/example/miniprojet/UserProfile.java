package com.example.miniprojet;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class UserProfile extends AppCompatActivity {
    TextView profileName, profileEmail, profileUsername, profilePassword;
    TextView titleName, titleUsername;
    Button editProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profil);

        // Initializing UI elements
        profileName = findViewById(R.id.profileName);
        profileEmail = findViewById(R.id.profileEmail);
        profileUsername = findViewById(R.id.profileUsername);
        profilePassword = findViewById(R.id.profilePassword);
        titleName = findViewById(R.id.titleName);
        titleUsername = findViewById(R.id.titleUsername);
        editProfile = findViewById(R.id.editButton);

        // Display user profile data
        showAllUserData();

        // Edit profile button click listener
        editProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigate to EditProfileActivity
                passUserData();
            }
        });
    }

    // Method to retrieve and display user data passed from the previous activity
    public void showAllUserData() {
        Intent intent = getIntent();
        String nameUser = intent.getStringExtra("name1");
        String emailUser = intent.getStringExtra("email1");
        String usernameUser = intent.getStringExtra("username1");
        String passwordUser = intent.getStringExtra("password1");

        // Set user data to respective TextViews for display
        titleName.setText(nameUser);
        titleUsername.setText(usernameUser);
        profileName.setText(nameUser);
        profileEmail.setText(emailUser);
        profileUsername.setText(usernameUser);
        profilePassword.setText(passwordUser);
    }

    // Method to pass user data and navigate to EditProfileActivity
    public void passUserData() {
        String userUsername = profileUsername.getText().toString().trim();
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");
        Query checkUserDatabase = reference.orderByChild("username").equalTo(userUsername);

        checkUserDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    // Retrieve user data from the database
                    String nameFromDB = snapshot.child(userUsername).child("name").getValue(String.class);
                    String emailFromDB = snapshot.child(userUsername).child("email").getValue(String.class);
                    String usernameFromDB = snapshot.child(userUsername).child("username").getValue(String.class);
                    String passwordFromDB = snapshot.child(userUsername).child("password").getValue(String.class);

                    // Pass user data to EditProfileActivity
                    Intent intent = new Intent(UserProfile.this, EditProfileActivity.class);
                    intent.putExtra("name", nameFromDB);
                    intent.putExtra("email", emailFromDB);
                    intent.putExtra("username", usernameFromDB);
                    intent.putExtra("password", passwordFromDB);
                    startActivity(intent);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Handle onCancelled event if needed
            }
        });
    }
}
