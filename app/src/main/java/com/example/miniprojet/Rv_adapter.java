package com.example.miniprojet;
import java.util.ArrayList;
import java.util.List;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;



import java.util.List;

public class Rv_adapter extends RecyclerView.Adapter<MyViewHolder> {


    Context context;
    ArrayList<item> items;

    public Rv_adapter(Context context, ArrayList<item> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       //this is where we inflate the layout(giving a look to our rows
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.activity_items,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull  MyViewHolder holder, int position) {
        //assing values to the views we created in the recucler view row layout
       //based on the position of the recycler view
        holder.nameView.setText(items.get(position).getName());
        holder.imageView.setImageResource(items.get(position).getImg());
    }

    @Override
    public int getItemCount() {
        //this contains the number of items we want to display
        return items.size();
    }
}