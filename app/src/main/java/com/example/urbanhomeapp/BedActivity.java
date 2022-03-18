package com.example.urbanhomeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BedActivity extends AppCompatActivity {
    GridView gridViewBeds;
    List<String> bedNames;
    List<Integer> bedPics;
    int idx = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bed);

        bedNames = new ArrayList<>(Arrays.asList("Victoria Queen Bed",
                "Genuine Leather Twin Bed","Upholstered Platform Bed",
                "Ollie Bed","Sandro Asher Platform King Bed",
                "Platforma Low Profile Bed"));

        bedPics = new ArrayList<>(Arrays.asList(R.drawable.dhpvictoria,
                R.drawable.genuineleather, R.drawable.mercerwulff, R.drawable.modwayollie,
                R.drawable.sandroasher, R.drawable.zinusjoseph));

        gridViewBeds = findViewById(R.id.gridViewBeds);
        CategoriesAdapter adapter = new CategoriesAdapter(bedNames, bedPics);
        gridViewBeds.setAdapter(adapter);

        gridViewBeds.setNumColumns(2);
        gridViewBeds.setVerticalSpacing(8);
        gridViewBeds.setHorizontalSpacing(8);
        gridViewBeds.setScrollBarSize(3);

        gridViewBeds.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(BedActivity.this, "You Clicked "+ bedNames.get(i), Toast.LENGTH_SHORT).show();
                switch (i) {
                    case 0:
                        idx = 11;
                        Intent result = new Intent(BedActivity.this, DescriptionActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("IDX", idx);
                        result.putExtras(bundle);
                        startActivity(result);
                        break;
                    case 1:
                        idx = 12;
                        result = new Intent(BedActivity.this, DescriptionActivity.class);
                        bundle = new Bundle();
                        bundle.putInt("IDX", idx);
                        result.putExtras(bundle);
                        startActivity(result);
                        break;
                    case 2:
                        idx = 13;
                        result = new Intent(BedActivity.this, DescriptionActivity.class);
                        bundle = new Bundle();
                        bundle.putInt("IDX", idx);
                        result.putExtras(bundle);
                        startActivity(result);
                        break;
                    case 3:
                        idx = 14;
                        result = new Intent(BedActivity.this, DescriptionActivity.class);
                        bundle = new Bundle();
                        bundle.putInt("IDX", idx);
                        result.putExtras(bundle);
                        startActivity(result);
                        break;
                    case 4:
                        idx = 15;
                        result = new Intent(BedActivity.this, DescriptionActivity.class);
                        bundle = new Bundle();
                        bundle.putInt("IDX", idx);
                        result.putExtras(bundle);
                        startActivity(result);
                        break;
                    case 5:
                        idx = 16;
                        result = new Intent(BedActivity.this, DescriptionActivity.class);
                        bundle = new Bundle();
                        bundle.putInt("IDX", idx);
                        result.putExtras(bundle);
                        startActivity(result);
                        break;
                }
            }
        });
    }
}