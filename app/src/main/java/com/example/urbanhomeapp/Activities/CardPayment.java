package com.example.urbanhomeapp.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.craftman.cardform.Card;
import com.craftman.cardform.CardForm;
import com.craftman.cardform.OnPayBtnClickListner;
import com.example.urbanhomeapp.Adapters.OrderDetailsAdapter;
import com.example.urbanhomeapp.Daos.CartDao;
import com.example.urbanhomeapp.Database.CartDatabase;
import com.example.urbanhomeapp.R;
import com.example.urbanhomeapp.model.CartItem;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CardPayment extends AppCompatActivity {

    Double price;
    List<CartItem> itemsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_payment);

        CardForm cardForm = findViewById(R.id.cardform);
        TextView txtDes = findViewById(R.id.payment_amount);
        Button btnPay = findViewById(R.id.btn_pay);

        CartDatabase db = Room.databaseBuilder(getApplicationContext(), CartDatabase.class,
                "cart_db").fallbackToDestructiveMigration().allowMainThreadQueries().build();
        CartDao cartDao = db.cartDao();

        CartDatabase db2 = Room.databaseBuilder(getApplicationContext(), CartDatabase.class,
                "orders_db").fallbackToDestructiveMigration().allowMainThreadQueries().build();
        CartDao cartDao2 = db2.cartDao();

        Bundle bundle = getIntent().getExtras();
        price = getIntent().getExtras().getDouble("ITEMPRICE", 0);

        txtDes.setText("$" + String.valueOf(price));
        btnPay.setText(String.format("Pay %s", txtDes.getText()));


        cardForm.setPayBtnClickListner(new OnPayBtnClickListner() {
            @Override
            public void onClick(Card card) {

                Toast.makeText(CardPayment.this, "Payment Successful", Toast.LENGTH_SHORT).show();
                Toast.makeText(CardPayment.this, "Order Received", Toast.LENGTH_SHORT).show();

                ExecutorService executorService = Executors.newSingleThreadExecutor();
                executorService.execute(()->{
                    try{
                        itemsList = db.cartDao().getAllCartItems();
                        OrderDetailsAdapter adapter = new OrderDetailsAdapter(itemsList);
                        ListView listView = findViewById(R.id.listViewItems2);

                        List<CartItem> cartItemList = db.cartDao().getAllCartItems();
                        db2.cartDao().insertItemsFromList(cartItemList);
                        db.cartDao().deleItemsFromList(cartItemList);

                        startActivity(new Intent(CardPayment.this, HomeActivity.class));
                        listView.setAdapter(adapter);

                    }catch(Exception ex){
                        Log.d("CartActivity", ex.getMessage());
                    }
                });
            }
        });
        
    }
}