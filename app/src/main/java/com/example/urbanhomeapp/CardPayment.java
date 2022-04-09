package com.example.urbanhomeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.craftman.cardform.Card;
import com.craftman.cardform.CardForm;
import com.craftman.cardform.OnPayBtnClickListner;

public class CardPayment extends AppCompatActivity {

    Double price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_payment);

        CardForm cardForm = findViewById(R.id.cardform);
        TextView txtDes = findViewById(R.id.payment_amount);
        Button btnPay = findViewById(R.id.btn_pay);

        Bundle bundle = getIntent().getExtras();
        price = getIntent().getExtras().getDouble("ITEMPRICE", 0);
        
        txtDes.setText("$" + String.valueOf(price));
        btnPay.setText(String.format("Pay %s", txtDes.getText()));

        
        cardForm.setPayBtnClickListner(new OnPayBtnClickListner() {
            @Override
            public void onClick(Card card) {
                Toast.makeText(CardPayment.this, "NAme : "+card.getName()+" | CVC : "
                        + card.getLast4(), Toast.LENGTH_SHORT).show();
                Toast.makeText(CardPayment.this, "Payment Successful", Toast.LENGTH_SHORT).show();
            }
        });
        
    }
}