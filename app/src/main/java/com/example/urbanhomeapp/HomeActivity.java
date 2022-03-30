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
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.urbanhomeapp.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

//    ActivityMainBinding binding; try this out
    List<String> imgNames;
    List<Integer> imgPics;

    GridView gridViewCategory;
    ImageView imgViewCart;
    ImageView imgViewSofa;
    ImageView imgViewTeaPot;
    ImageView imgViewWallShelf;
    ImageView imgViewThinChair;
    ImageView imgViewMenu;
    SearchView SearchViewItem;
    ListView listViewSearch;
    int idx = -1;

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
        ItemSearchView();

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
        SearchViewItem = findViewById(R.id.SearchViewItem);
        listViewSearch = findViewById(R.id.listViewSearch);

    }

    public void imageViewCart(){
        imgViewCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this,CartActivity.class);
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
            result.putExtras(bundle);
            startActivity(result);
        });
    }

    public void imgViewMenu(){
        imgViewMenu.setOnClickListener((View view )->{
            startActivity(new Intent(HomeActivity.this, MenuActivity.class));
        });
    }

    public void ItemSearchView(){
        SearchViewItem.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                SearchItemAdapter searchItemAdapter = new SearchItemAdapter(searchItems);
                listViewSearch.setAdapter(searchItemAdapter);
                searchItemAdapter.getFilter().filter(s);
                return true;
            }
        });
    }
}