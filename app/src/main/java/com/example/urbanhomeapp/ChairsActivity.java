package com.example.urbanhomeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ChairsActivity extends AppCompatActivity {
    GridView gridViewChairs;
    List<String> itemDesc;
    List<Integer> itemPics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chairs);
        itemDesc = new ArrayList<>(Arrays.asList("Renay 29'' Wide Papasan Chair",
                "Lollie Executive Chair", "Denchev Tufted Armless Chaise Lounge Chair","Harrietta 33'' " +
                        "Wide Tufted Velvet Wingback Chair", "Louise Velvet Task Chair", "Classic Sofa Chair"));

        itemPics = new ArrayList<>(Arrays.asList(R.drawable.renaychair,
                R.drawable.lolliechair, R.drawable.denchevlounge, R.drawable.wingbackchair,
                R.drawable.louisechair, R.drawable.sofalazy));

        gridViewChairs = findViewById(R.id.gridViewChairs);

        CategoriesAdapter adapter = new CategoriesAdapter(itemDesc, itemPics);
        gridViewChairs.setAdapter(adapter);

        gridViewChairs.setNumColumns(2);
        gridViewChairs.setVerticalSpacing(8);
        gridViewChairs.setHorizontalSpacing(8);
        gridViewChairs.setScrollBarSize(3);

        gridViewChairs.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(ChairsActivity.this, "You Clicked "+ itemDesc.get(i), Toast.LENGTH_SHORT).show();
            }
        });

    }
}