package com.example.urbanhomeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
    GridView gridViewCategory;
    List<String> imgNames = new ArrayList<>(
            Arrays.asList("Chair","Bed","Table")
    );
    List<Integer> imgPics = new ArrayList<>(
            Arrays.asList(R.drawable.icons_chair, R.drawable.icons_bed, R.drawable.icons_table)
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        gridViewCategory = findViewById(R.id.gridViewCategory);
        HomeAdapter homeAdapter = new HomeAdapter(imgNames, imgPics);
        gridViewCategory.setAdapter(homeAdapter);
        gridViewCategory.setNumColumns(3);
        gridViewCategory.setVerticalSpacing(8);
        gridViewCategory.setHorizontalSpacing(8);
        gridViewCategory.setScrollBarSize(3);
    }
}