package com.example.urbanhomeapp;

import androidx.appcompat.app.AppCompatActivity;

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
    List<String> bedNames = new ArrayList<>(Arrays.asList("DHP Victoria Full Size Metal Daybed - White",
            "Genuine Leather Ultimate Bed","Mercer41 Wulff Velvet Upholstered Platform Bed Colour: Grey, Size: Queen Wood",
            "Modway Ollie Bed Frame Colour: Silver, Size: King","Sandro Asher Platform Bed Size: King",
            "Zinus Joseph 6 Inch Platforma Low Profile Bed Frame"));

    List<Integer> bedPics = new ArrayList<>(Arrays.asList(R.drawable.dhpvictoria,
            R.drawable.genuineleather, R.drawable.mercerwulff, R.drawable.modwayollie,
            R.drawable.sandroasher, R.drawable.zinusjoseph));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bed);

        gridViewBeds = findViewById(R.id.gridViewBeds);
        BedAdapter bedAdapter = new BedAdapter(bedNames, bedPics);
        gridViewBeds.setAdapter(bedAdapter);

        gridViewBeds.setNumColumns(2);
        gridViewBeds.setVerticalSpacing(8);
        gridViewBeds.setHorizontalSpacing(8);
        gridViewBeds.setScrollBarSize(3);

        gridViewBeds.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(BedActivity.this, "You Clicked "+ bedNames.get(i), Toast.LENGTH_SHORT).show();
            }
        });
    }
}