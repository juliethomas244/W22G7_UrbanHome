package com.example.urbanhomeapp.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.urbanhomeapp.Daos.CartDao;
import com.example.urbanhomeapp.Database.CartDatabase;
import com.example.urbanhomeapp.R;
import com.example.urbanhomeapp.model.CartItem;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ItemEditActivity extends AppCompatActivity {
    CartDatabase db;
    CartDao cartDao;
    List<CartItem> itemsList = new ArrayList<>();
    TextView txtViewTtlPrice;
    double ttlPrice = 0;
    TextView txtItemName;
    TextView txtViewEditQtt;
    TextView txtViewTtlPriceInEdit;
    TextView txtViewCancel;
    TextView txtViewSave;
    ImageView imgViewMinus;
    ImageView imgViewPlus;
    ImageView RemoveInEdit;
    String name = "";
    Double price;
    int qtt = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_edit);

        ListView listViewItems = findViewById(R.id.listViewItems);
        txtViewTtlPrice = findViewById(R.id.txtViewTtlPrice);
        txtItemName = findViewById(R.id.txtItemName);
        txtViewEditQtt = findViewById(R.id.txtViewEditQtt);
        txtViewTtlPriceInEdit = findViewById(R.id.txtViewTtlPriceInEdit);
        imgViewMinus = findViewById(R.id.imgViewMinus);
        imgViewPlus = findViewById(R.id.imgViewPlus);
        txtViewCancel = findViewById(R.id.txtViewCancel);
        RemoveInEdit = findViewById(R.id.RemoveInEdit);
        txtViewSave = findViewById(R.id.txtViewSave);

        db = Room.databaseBuilder(getApplicationContext(), CartDatabase.class,
                "cart_db").fallbackToDestructiveMigration().allowMainThreadQueries().build();
        cartDao = db.cartDao();

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(()->{
            try{
                Bundle bundle = getIntent().getExtras();
                name = getIntent().getExtras().getString("ITEMNAME", "error");
                price = getIntent().getExtras().getDouble("ITEMPRICE", 0);
                qtt = getIntent().getExtras().getInt("ITEMQTT", 0);
                txtItemName.setText(name);
                txtViewEditQtt.setText(String.valueOf(qtt));
                txtViewTtlPriceInEdit.setText(String.valueOf(price*qtt));

                imgViewMinus.setOnClickListener((View view) -> {
                    if (qtt == 1){
                        Toast.makeText(this, "Minimum can be 1.", Toast.LENGTH_SHORT).show();
                    } else{
                        qtt -= 1;
                    }
                    txtViewEditQtt.setText(String.valueOf(qtt));
                    txtViewTtlPriceInEdit.setText(String.valueOf(qtt*price));
                });
                imgViewPlus.setOnClickListener((View view) -> {
                    qtt += 1;
                    txtViewEditQtt.setText(String.valueOf(qtt));
                    txtViewTtlPriceInEdit.setText(String.valueOf(qtt*price));
                });

                txtViewCancel.setOnClickListener((View view)->{
                    startActivity(new Intent(ItemEditActivity.this, CartActivity2.class));
                });

                RemoveInEdit.setOnClickListener((View view)->{
                    db.cartDao().deleteItemWithName(name);
                    startActivity(new Intent(ItemEditActivity.this, CartActivity2.class));
                    Toast.makeText(this, "Item Deleted!", Toast.LENGTH_SHORT).show();
                });

                txtViewSave.setOnClickListener((View view)->{
                    db.cartDao().deleteItemWithName(name);
                    CartItem cart = new CartItem();
                    cart.setName(name);
                    cart.setQuantity(qtt);
                    cart.setPrice(qtt*price);
                    cartDao.insertItem(cart);
                    startActivity(new Intent(ItemEditActivity.this, CartActivity2.class));
                    Toast.makeText(this, "Item Updated!", Toast.LENGTH_SHORT).show();
                });
            }catch(Exception ex){
                Log.d("CartActivity", ex.getMessage());
            }
        });
    }
}