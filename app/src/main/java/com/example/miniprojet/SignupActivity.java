package com.example.miniprojet;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignupActivity extends AppCompatActivity {

    EditText signupName, signupUsername, signupEmail, signupPassword;
    TextView loginRedirectText;
    Button signupButton;
    RadioGroup roleRadioGroup;
    RadioButton adminRadioButton, studentRadioButton;
    FirebaseDatabase database;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        // Initializing UI elements
        signupName = findViewById(R.id.signup_name);
        signupEmail = findViewById(R.id.signup_email);
        signupUsername = findViewById(R.id.signup_username);
        signupPassword = findViewById(R.id.signup_password);
        loginRedirectText = findViewById(R.id.loginRedirectText);
        signupButton = findViewById(R.id.signup_button);
        roleRadioGroup = findViewById(R.id.role_radio_group);
        adminRadioButton = findViewById(R.id.admin_button);
        studentRadioButton = findViewById(R.id.student_button);

        // Firebase initialization
        database = FirebaseDatabase.getInstance();
        reference = database.getReference("users");

        // Signup button click listener
        signupButton.setOnClickListener(view -> {
            // Retrieving user inputs
            String name = signupName.getText().toString();
            String email = signupEmail.getText().toString();
            String username = signupUsername.getText().toString();
            String password = signupPassword.getText().toString();

            // Retrieving the selected role from the radio group
            String role;
            int selectedRoleId = roleRadioGroup.getCheckedRadioButtonId();
            if (selectedRoleId == adminRadioButton.getId()) {
                role = "admin";
            } else {
                role = "student";
            }

            // Creating a HelperClass object and storing user data in Firebase
            HelperClass helperClass = new HelperClass(name, email, username, password, role);
            reference.child(username).setValue(helperClass);

            // Displaying a success message
            Toast.makeText(SignupActivity.this, "You have signed up successfully!", Toast.LENGTH_SHORT).show();

            // Redirecting to the login activity
            Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
            startActivity(intent);
        });

        // Redirecting to the login activity when the "Login" text is clicked
        loginRedirectText.setOnClickListener(view -> {
            Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
            startActivity(intent);
        });
    }
}
