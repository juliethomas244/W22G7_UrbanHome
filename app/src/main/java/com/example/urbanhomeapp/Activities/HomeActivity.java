package com.example.urbanhomeapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;

//import com.example.urbanhomeapp.databinding.ActivityMainBinding;

import com.example.urbanhomeapp.Adapters.HomeAdapter;
import com.example.urbanhomeapp.model.LocalStorage;
import com.example.urbanhomeapp.R;
import com.example.urbanhomeapp.model.Cart;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    GridView gridViewCategory;
    ImageView imgViewCart;

    List<Cart> cartList = new ArrayList<Cart>();
    Gson gson;
    LocalStorage localStorage;
    List<String> imgNames = new ArrayList<>(
            Arrays.asList("Chair","Bed","Table")
    );
    List<String> itemNames = new ArrayList<>(
            Arrays.asList("Black sofa", "Tea pot", "Wall shelf", "Thin chair")
    );
    List<Integer> imgPics = new ArrayList<>(
            Arrays.asList(R.drawable.icons_chair, R.drawable.icons_bed, R.drawable.icons_table)
    );
    ImageView imgViewSofa;
    ImageView imgViewTeaPot;
    ImageView imgViewWallShelf;
    ImageView imgViewThinChair;
    ImageView imgViewMenu;
    SearchView SearchViewItem;
    ListView listViewSearch;
    int idx = -1;
    String name;

    List<String> searchItems ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        arrays();
        controls();
        gridViewCategory();
        imgViewSofa();
        imgViewTeaPot();
        imgViewWallShelf();
        imgViewThinChair();
        gridViewCategoryOnItemClick();
        imageViewCart();
        imgViewMenu();
    }

    public void arrays(){
        imgNames = new ArrayList<>(Arrays.asList("Chair","Bed","Table"));
        imgPics = new ArrayList<>(Arrays.asList(R.drawable.icons_chair,
                R.drawable.icons_bed, R.drawable.icons_table));
        searchItems = new ArrayList<>(Arrays.asList("Renay 29'' Wide Papasan Chair",
                "Lollie Executive Chair", "Denchev Tufted Armless Chaise Lounge Chair","Harrietta 33'' Wide Tufted Velvet" +
                        " Wingback Chair", "Louise Velvet Task Chair", "Classic Sofa Chair", "DHP Victoria Full Size Metal Bed - White",
                "Genuine Leather Ultimate Bed","Mercer41 Wulff Velvet Upholstered Platform Bed Colour: Grey, Size: Queen Wood",
                "Modway Ollie Bed Frame Colour: Silver, Size: King","Sandro Asher Platform Bed Size: King",
                "Zinus Joseph 6 Inch Platforma Low Profile Bed Frame", "House of Hampton Console Table", "Round End Table with Storage Shelf",
                "ABS Plastic Folding Table", "Wood Round Coffee Table","Clearwater Console Table", "Alexious Console Table"));

    }

    public void controls(){
        gridViewCategory = findViewById(R.id.gridViewCategory);
        imgViewCart = findViewById(R.id.imgViewCart);
        imgViewMenu = findViewById(R.id.imgViewMenu);
        imgViewSofa = findViewById(R.id.imgViewSofa);
        imgViewTeaPot = findViewById(R.id.imgViewTeaPot);
        imgViewWallShelf = findViewById(R.id.imgViewWallShelf);
        imgViewThinChair = findViewById(R.id.imgViewThinChair);

    }

    public void imageViewCart(){
        imgViewCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, CartActivity2.class);
                startActivity(intent);
            }
        });
    }

    public void gridViewCategory(){
        HomeAdapter homeAdapter = new HomeAdapter(imgNames, imgPics);
        gridViewCategory.setAdapter(homeAdapter);
        gridViewCategory.setNumColumns(3);
        gridViewCategory.setVerticalSpacing(5);
        gridViewCategory.setHorizontalSpacing(5);
        gridViewCategory.setScrollBarSize(3);
    }

    public void gridViewCategoryOnItemClick(){
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
    }

    public void imgViewSofa(){
        imgViewSofa.setOnClickListener((View view) -> {
            idx = 0;
            Intent result = new Intent(HomeActivity.this, DescriptionActivity.class);
            Bundle bundle = new Bundle();
            bundle.putInt("IDX", idx);
            name = itemNames.get(idx);
            bundle.putString("NAME", name);
            result.putExtras(bundle);
            startActivity(result);
        });
    }

    public void imgViewTeaPot(){
        imgViewTeaPot.setOnClickListener((View view) -> {
            idx = 1;
            Intent result = new Intent(HomeActivity.this, DescriptionActivity.class);
            Bundle bundle = new Bundle();
            bundle.putInt("IDX", idx);
            name = itemNames.get(idx);
            bundle.putString("NAME", name);
            result.putExtras(bundle);
            startActivity(result);
        });
    }

    public void imgViewWallShelf(){
        imgViewWallShelf.setOnClickListener((View view) -> {
            idx = 2;
            Intent result = new Intent(HomeActivity.this, DescriptionActivity.class);
            Bundle bundle = new Bundle();
            bundle.putInt("IDX", idx);
            name = itemNames.get(idx);
            bundle.putString("NAME", name);
            result.putExtras(bundle);
            startActivity(result);
        });
    }

    public void imgViewThinChair(){
        imgViewThinChair.setOnClickListener((View view) -> {
            idx = 3;
            Intent result = new Intent(HomeActivity.this, DescriptionActivity.class);
            Bundle bundle = new Bundle();
            bundle.putInt("IDX", idx);
            name = itemNames.get(idx);
            bundle.putString("NAME", name);
            result.putExtras(bundle);
            startActivity(result);
        });
    }

    public void imgViewMenu(){
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