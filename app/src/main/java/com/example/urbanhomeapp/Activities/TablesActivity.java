package com.example.urbanhomeapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.urbanhomeapp.Adapters.CategoriesAdapter;
import com.example.urbanhomeapp.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TablesActivity extends AppCompatActivity {
    GridView gridviewTables;
    List<String> tableNames;
    List<Integer> tablePics;
    int idx = -1;
    String name = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tables);

        tableNames = new ArrayList<>(Arrays.asList("House of Hampton Console Table"
                , "Round End Table with Storage Shelf",
                "ABS Plastic Folding Table", "Wood Round Coffee Table",
                "Clearwater Console Table", "Alexious Console Table"));

        tablePics = new ArrayList<>(Arrays.asList(R.drawable.hampton,
                R.drawable.endtable, R.drawable.abs, R.drawable.griffin,
                R.drawable.laurel, R.drawable.everly));

        gridviewTables = findViewById(R.id.gridviewTables);
        CategoriesAdapter tableAdapter = new CategoriesAdapter(tableNames, tablePics);
        gridviewTables.setAdapter(tableAdapter);

        gridviewTables.setHorizontalSpacing(8);
        gridviewTables.setVerticalSpacing(8);
        gridviewTables.setScrollBarSize(3);
        gridviewTables.setNumColumns(2);

        gridviewTables.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //                Toast.makeText(TablesActivity.this, "You Clicked "+ tableNames.get(i), Toast.LENGTH_SHORT).show();
                switch (i) {
                    case 0:
                        idx = 31;
                        Intent result = new Intent(TablesActivity.this, DescriptionActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("IDX", idx);
                        name = tableNames.get(i);
                        bundle.putString("NAME", name);
                        result.putExtras(bundle);
                        startActivity(result);
                        break;
                    case 1:
                        idx = 32;
                        result = new Intent(TablesActivity.this, DescriptionActivity.class);
                        bundle = new Bundle();
                        bundle.putInt("IDX", idx);
                        name = tableNames.get(i);
                        bundle.putString("NAME", name);
                        result.putExtras(bundle);
                        startActivity(result);
                        break;
                    case 2:
                        idx = 33;
                        result = new Intent(TablesActivity.this, DescriptionActivity.class);
                        bundle = new Bundle();
                        bundle.putInt("IDX", idx);
                        name = tableNames.get(i);
                        bundle.putString("NAME", name);
                        result.putExtras(bundle);
                        startActivity(result);
                        break;
                    case 3:
                        idx = 34;
                        result = new Intent(TablesActivity.this, DescriptionActivity.class);
                        bundle = new Bundle();
                        bundle.putInt("IDX", idx);
                        name = tableNames.get(i);
                        bundle.putString("NAME", name);
                        result.putExtras(bundle);
                        startActivity(result);
                        break;
                    case 4:
                        idx = 35;
                        result = new Intent(TablesActivity.this, DescriptionActivity.class);
                        bundle = new Bundle();
                        bundle.putInt("IDX", idx);
                        name = tableNames.get(i);
                        bundle.putString("NAME", name);
                        result.putExtras(bundle);
                        startActivity(result);
                        break;
                    case 5:
                        idx = 36;
                        result = new Intent(TablesActivity.this, DescriptionActivity.class);
                        bundle = new Bundle();
                        bundle.putInt("IDX", idx);
                        name = tableNames.get(i);
                        bundle.putString("NAME", name);
                        result.putExtras(bundle);
                        startActivity(result);
                        break;
                }
            }
        });
    }
}