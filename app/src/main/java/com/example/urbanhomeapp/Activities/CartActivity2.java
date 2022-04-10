package com.example.urbanhomeapp.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.urbanhomeapp.Adapters.CartAdapter2;
import com.example.urbanhomeapp.Daos.CartDao;
import com.example.urbanhomeapp.Database.CartDatabase;
import com.example.urbanhomeapp.R;
import com.example.urbanhomeapp.model.CartItem;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CartActivity2 extends AppCompatActivity {
    CartDatabase db;
    CartDao cartDao;
    List<CartItem> itemsList = new ArrayList<>();
    TextView txtViewTtlPrice;
    TextView txtViewCheckOut;
    ImageView imgHome;
    double ttlPrice = 0;
    double ttlQty = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart2);

        ListView listViewItems = findViewById(R.id.listViewItems);
        txtViewTtlPrice = findViewById(R.id.txtViewTtlPrice);
        txtViewCheckOut = findViewById(R.id.txtViewCheckOut);
        imgHome = findViewById(R.id.imgHome);

        imgHome.setOnClickListener((View view) -> {
            startActivity(new Intent(CartActivity2.this, HomeActivity.class));
        });

        db = Room.databaseBuilder(getApplicationContext(), CartDatabase.class,
                "cart_db").fallbackToDestructiveMigration().allowMainThreadQueries().build();
        cartDao = db.cartDao();

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(()->{
            try{
                listViewItems.setOnItemClickListener((AdapterView<?> adapterView, View view, int i, long l) -> {
                    Intent result = new Intent(CartActivity2.this, ItemEditActivity.class);

                    Bundle bundle = new Bundle();
                    bundle.putString("ITEMNAME", itemsList.get(i).getName());
                    bundle.putDouble("ITEMPRICE", (itemsList.get(i).getPrice() / itemsList.get(i).getQuantity()));
                    bundle.putInt("ITEMQTT", itemsList.get(i).getQuantity());
                    result.putExtras(bundle);
                    startActivity(result);

                });

                itemsList = db.cartDao().getAllCartItems();
                CartAdapter2 adapter = new CartAdapter2(itemsList);

                ttlPrice = 0;
                for (int i = 0; i < itemsList.size(); i++) {
                    ttlPrice += itemsList.get(i).getPrice();
                    ttlQty +=itemsList.get(i).getQuantity();
                }

                txtViewTtlPrice.setText("$"+String.valueOf(ttlPrice));
                listViewItems.setAdapter(adapter);

            }catch(Exception ex){
                Log.d("CartActivity", ex.getMessage());
            }
        });

        txtViewCheckOut.setOnClickListener((View view) -> {
            Intent checkoutResult = new Intent(CartActivity2.this, CheckoutActivity.class);
            Bundle bundle = new Bundle();
            bundle.putDouble("ITEMPRICE", ttlPrice);
            bundle.putDouble("ITEMQTT", ttlQty);
            checkoutResult.putExtras(bundle);
            startActivity(checkoutResult);
        });
    }
}