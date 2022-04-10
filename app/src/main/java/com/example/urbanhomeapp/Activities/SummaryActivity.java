package com.example.urbanhomeapp.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.urbanhomeapp.R;


public class SummaryActivity extends AppCompatActivity {
    TextView txtViewSummary;
    TextView textViewTotalItems;
    TextView textViewPrice;
    RecyclerView recyclerViewItems;
    RecyclerView recyclerViewPrice;
    TextView textViewTotal;
    TextView textViewCost;
    Button submitBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtViewSummary = findViewById(R.id.txtViewSummary);
        textViewTotalItems = findViewById(R.id.textViewTotalItems);
        textViewPrice = findViewById(R.id.textViewPrice);
        recyclerViewItems = findViewById(R.id.recyclerViewItems);
        recyclerViewPrice = findViewById(R.id.recyclerViewPrice);
        textViewTotal = findViewById(R.id.textViewTotal);
        textViewCost = findViewById(R.id.textViewCost);
        submitBtn = findViewById(R.id.submitBtn);

        submitBtn.setOnClickListener((View view) -> {


        });


    }
}
