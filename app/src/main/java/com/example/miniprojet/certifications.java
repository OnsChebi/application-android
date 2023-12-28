package com.example.miniprojet;

import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class certifications extends AppCompatActivity {
ArrayList<item> items = new ArrayList<>();

int[] certifImages={R.drawable.cloud,R.drawable.hcna,
R.drawable.kubernet,R.drawable.linux,R.drawable.linux_foundation,
R.drawable.microsoft,R.drawable.oca,R.drawable.ocp,
R.drawable.pcap,R.drawable.pcep,R.drawable.redhat};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_certif);

        RecyclerView recyclerView=findViewById(R.id.recyclerview);

        setupItems();
        Rv_adapter adapter=new Rv_adapter(this,items);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
    private void setupItems(){
        String[] certifs = getResources().getStringArray(R.array.certifs);
        for (int i=0;i<certifs.length;i++){
            items.add(new item(certifs[i],certifImages[i]));
        }
    }


}
