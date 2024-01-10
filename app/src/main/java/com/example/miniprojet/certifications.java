package com.example.miniprojet;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;


import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;


public class certifications extends AppCompatActivity {
    // ArrayList to hold certification items
    private ArrayList<item> items = new ArrayList<>();



    private Rv_adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_certif);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);

        // Populating items list and creating an adapter
        setupItems();
        adapter = new Rv_adapter(this, items);

        // Setting the adapter and layout manager for RecyclerView
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Adding a button click listener for adding a new certification
        Button addCertificationButton = findViewById(R.id.addCertificationButton);
        addCertificationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Call a method to show a dialog or handle user input for adding a new certification
                showAddCertificationDialog();
            }
        });
    }

    // Array of resource IDs for certification images
    int[] certifImages = {R.drawable.cloud, R.drawable.hcna,
            R.drawable.kubernet, R.drawable.linux, R.drawable.linux_foundation,
            R.drawable.microsoft, R.drawable.oca, R.drawable.ocp,
            R.drawable.pcap, R.drawable.pcep, R.drawable.redhat};

    // Method to populate the items list with certification names and images
    private void setupItems() {
        // Array of certification names retrieved from resources
        String[] certifs = getResources().getStringArray(R.array.certifs);

        // Adding items to the list with names and corresponding images
        for (int i = 0; i < certifs.length; i++) {
            items.add(new item(certifs[i], certifImages[i]));
        }
    }

    // Method to show a dialog for adding a new certification
    private void showAddCertificationDialog() {
        // Create an EditText for certification name input
        final EditText inputCertification = new EditText(this);

        // Create an AlertDialog with an input field and buttons
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Add Certification")
                .setMessage("Enter the name of the new certification:")
                .setView(inputCertification)
                .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Handle positive button click
                        String newCertification = inputCertification.getText().toString();
                        if (!newCertification.isEmpty()) {
                            // i can't make the pgoto upload so i used a default image
                            int newCertificationImage = R.drawable.linux;
                            items.add(new item(newCertification, newCertificationImage));
                            adapter.notifyDataSetChanged(); // Notify the adapter that the data set has changed
                        }
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Handle negative button click (if needed)
                    }
                })
                .show();
    }
}