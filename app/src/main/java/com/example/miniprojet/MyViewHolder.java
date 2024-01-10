package com.example.miniprojet;

import android.widget.ImageView;
import android.widget.TextView;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {

    ImageView imageView;
    TextView nameView;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        // Initializing ImageView and TextView from the layout
        imageView = itemView.findViewById(R.id.imageview);
        nameView = itemView.findViewById(R.id.name);
    }
}
