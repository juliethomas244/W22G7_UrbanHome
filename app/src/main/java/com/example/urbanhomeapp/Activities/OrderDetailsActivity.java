package com.example.urbanhomeapp.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.example.urbanhomeapp.Daos.CartDao;
import com.example.urbanhomeapp.Database.CartDatabase;
import com.example.urbanhomeapp.Adapters.OrderDetailsAdapter;
import com.example.urbanhomeapp.R;
import com.example.urbanhomeapp.model.CartItem;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class OrderDetailsActivity extends AppCompatActivity {
    CartDatabase db;
    CartDao cartDao;
    List<CartItem> itemsList = new ArrayList<>();
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);

        CartDatabase db2 = Room.databaseBuilder(getApplicationContext(), CartDatabase.class,
                "orders_db").fallbackToDestructiveMigration().allowMainThreadQueries().build();
        CartDao cartDao2 = db2.cartDao();

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(()->{
            try{
//                db2.cartDao().deleItemsFromList(itemsList);
                itemsList = db2.cartDao().getAllCartItems();

                listView = findViewById(R.id.listViewItems2);
                OrderDetailsAdapter adapter = new OrderDetailsAdapter(itemsList);
                listView.setAdapter(adapter);

            }catch(Exception ex){
                Log.d("CartActivity", ex.getMessage());
            }
        });
    }
}