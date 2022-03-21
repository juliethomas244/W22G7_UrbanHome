package com.example.urbanhomeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.Selection;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
    EditText editTextSearch;
    GridView gridViewCategory;
    ImageView imgViewCart;
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
        imgViewCart = findViewById(R.id.imgViewCart);
        HomeAdapter homeAdapter = new HomeAdapter(imgNames, imgPics);
        gridViewCategory.setAdapter(homeAdapter);
        gridViewCategory.setNumColumns(3);
        gridViewCategory.setVerticalSpacing(5);
        gridViewCategory.setHorizontalSpacing(5);
        gridViewCategory.setScrollBarSize(3);

        editTextSearch = findViewById(R.id.editTextSearch);
        String search = editTextSearch.getText().toString();


        //When the user clicks any item from the category, the app will take the user to the next
        // activity showing the GridView of corresponding items
        gridViewCategory.setOnItemClickListener((AdapterView<?> adapterView, View view, int position, long l) -> {
            //position is used here to access the item in the gridView

            if(position == 0)//When chair is clicked show all the types of chairs in another activity
                startActivity(new Intent(HomeActivity.this, ChairsActivity.class));

            if(position == 1)//When bed is clicked show all the types of bed in another activity
                startActivity(new Intent(HomeActivity.this, BedActivity.class));

            if(position == 2)//When table is clicked show all the types of tables in another activity
                startActivity(new Intent(HomeActivity.this, TablesActivity.class));
        });

        imgViewCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this,CheckoutActivity.class);
                startActivity(intent);
            }
        });

    }
}