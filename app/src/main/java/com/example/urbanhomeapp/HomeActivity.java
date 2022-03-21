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

import com.example.urbanhomeapp.model.Cart;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
    EditText editTextSearch;
    GridView gridViewCategory;
    ImageView imgViewCart;
    List<Cart> cartList = new ArrayList<Cart>();
    Gson gson;
    LocalStorage localStorage;
    List<String> imgNames = new ArrayList<>(
            Arrays.asList("Chair","Bed","Table")
    );
    List<Integer> imgPics = new ArrayList<>(
            Arrays.asList(R.drawable.icons_chair, R.drawable.icons_bed, R.drawable.icons_table)
    );
    ImageView imgViewSofa;
    ImageView imgViewTeaPot;
    ImageView imgViewWallShelf;
    ImageView imgViewThinChair;
    int idx = -1;
    ImageView imgViewMenu;

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


        imgViewSofa = findViewById(R.id.imgViewSofa);
        imgViewTeaPot = findViewById(R.id.imgViewTeaPot);
        imgViewWallShelf = findViewById(R.id.imgViewWallShelf);
        imgViewThinChair = findViewById(R.id.imgViewThinChair);

        imgViewSofa.setOnClickListener((View view) -> {
            idx = 0;
            Intent result = new Intent(HomeActivity.this, DescriptionActivity.class);
            Bundle bundle = new Bundle();
            bundle.putInt("IDX", idx);
            result.putExtras(bundle);
            startActivity(result);
        });
        imgViewTeaPot.setOnClickListener((View view) -> {
            idx = 1;
            Intent result = new Intent(HomeActivity.this, DescriptionActivity.class);
            Bundle bundle = new Bundle();
            bundle.putInt("IDX", idx);
            result.putExtras(bundle);
            startActivity(result);
        });
        imgViewWallShelf.setOnClickListener((View view) -> {
            idx = 2;
            Intent result = new Intent(HomeActivity.this, DescriptionActivity.class);
            Bundle bundle = new Bundle();
            bundle.putInt("IDX", idx);
            result.putExtras(bundle);
            startActivity(result);
        });
        imgViewThinChair.setOnClickListener((View view) -> {
            idx = 3;
            Intent result = new Intent(HomeActivity.this, DescriptionActivity.class);
            Bundle bundle = new Bundle();
            bundle.putInt("IDX", idx);
            result.putExtras(bundle);
            startActivity(result);
        });


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
                Intent intent = new Intent(HomeActivity.this,CartActivity.class);
                startActivity(intent);
            }
        });

        imgViewMenu = findViewById(R.id.imgViewMenu);
        imgViewMenu.setOnClickListener((View view )->{
            startActivity(new Intent(HomeActivity.this, MenuActivity.class));
        });
    }

    public List<Cart> getCartList() {
        if (localStorage.getCart() != null) {
            String jsonCart = localStorage.getCart();
            //Log.d("CART : ", jsonCart);
            Type type = new TypeToken<List<Cart>>() {
            }.getType();
            cartList = gson.fromJson(jsonCart, type);
            return cartList;
        }
        return cartList;
    }

}