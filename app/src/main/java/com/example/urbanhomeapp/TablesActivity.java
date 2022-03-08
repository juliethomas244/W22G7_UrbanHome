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

public class TablesActivity extends AppCompatActivity {
    Toast toast = new Toast(this);
    GridView gridviewTables;
    List<String> tableNames = new ArrayList<>(Arrays.asList("House of Hampton Caputo 47.5 Console Table"
            , "VASAGLE Round End Table with Storage Shelf",
            "ABS Plastic Folding Table - 72 x 30 x 29, Beige", "Griffin Reclaimed Wood Round Coffee Table",
            "Clearwater 37.75'' Console Table", "Alexious 47'' Console Table By Everly Quinn"));

    List<Integer> tablePics = new ArrayList<>(Arrays.asList(R.drawable.hampton,
            R.drawable.endtable, R.drawable.abs, R.drawable.griffin, R.drawable.laurel, R.drawable.everly));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tables);
        gridviewTables = findViewById(R.id.gridviewTables);
        TableAdapter tableAdapter = new TableAdapter(tableNames, tablePics);
        gridviewTables.setAdapter(tableAdapter);
        gridviewTables.setHorizontalSpacing(8);
        gridviewTables.setVerticalSpacing(8);
        gridviewTables.setScrollBarSize(3);
        gridviewTables.setNumColumns(2);


        gridviewTables.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            
            }
        });
    }
}