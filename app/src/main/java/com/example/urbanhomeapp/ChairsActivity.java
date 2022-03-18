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

public class ChairsActivity extends AppCompatActivity {
    GridView gridViewChairs;
    List<String> itemDesc = new ArrayList<>(Arrays.asList("Wide Papasan Chair",
            "Lollie Executive Chair", "Tufted Armless Chaise",
            "Wide Tufted Velvet Chair", "Louise Velvet Task Chair", "Classic Sofa Chair"));
    List<Integer> itemPics = new ArrayList<>(Arrays.asList(R.drawable.renaychair,
            R.drawable.lolliechair, R.drawable.denchevlounge, R.drawable.wingbackchair,
            R.drawable.louisechair, R.drawable.sofalazy));
    int idx = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chairs);
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
//                Toast.makeText(ChairsActivity.this, "You Clicked "+ itemDesc.get(i), Toast.LENGTH_SHORT).show();
                switch (i) {
                    case 0:
                        idx = 21;
                        Intent result = new Intent(ChairsActivity.this, DescriptionActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("IDX", idx);
                        result.putExtras(bundle);
                        startActivity(result);
                        break;
                    case 1:
                        idx = 22;
                        result = new Intent(ChairsActivity.this, DescriptionActivity.class);
                        bundle = new Bundle();
                        bundle.putInt("IDX", idx);
                        result.putExtras(bundle);
                        startActivity(result);
                        break;
                    case 2:
                        idx = 23;
                        result = new Intent(ChairsActivity.this, DescriptionActivity.class);
                        bundle = new Bundle();
                        bundle.putInt("IDX", idx);
                        result.putExtras(bundle);
                        startActivity(result);
                        break;
                    case 3:
                        idx = 24;
                        result = new Intent(ChairsActivity.this, DescriptionActivity.class);
                        bundle = new Bundle();
                        bundle.putInt("IDX", idx);
                        result.putExtras(bundle);
                        startActivity(result);
                        break;
                    case 4:
                        idx = 25;
                        result = new Intent(ChairsActivity.this, DescriptionActivity.class);
                        bundle = new Bundle();
                        bundle.putInt("IDX", idx);
                        result.putExtras(bundle);
                        startActivity(result);
                        break;
                    case 5:
                        idx = 26;
                        result = new Intent(ChairsActivity.this, DescriptionActivity.class);
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