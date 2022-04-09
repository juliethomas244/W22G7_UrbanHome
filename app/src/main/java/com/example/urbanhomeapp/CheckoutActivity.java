package com.example.urbanhomeapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.paypal.android.sdk.payments.PayPalConfiguration;
import com.paypal.android.sdk.payments.PayPalPayment;
import com.paypal.android.sdk.payments.PayPalService;
import com.paypal.android.sdk.payments.PaymentActivity;
import com.paypal.android.sdk.payments.PaymentConfirmation;

import org.json.JSONException;
import org.json.JSONObject;

import java.math.BigDecimal;

public class CheckoutActivity extends AppCompatActivity {


    TextView txttotalcost;
    TextView paypalStatus;
    TextView NoofItems;
    Double price,qtt;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);
        RadioGroup radioGroupDel = findViewById(R.id.radioGroup);
        Button btnBuyNow = findViewById(R.id.buttonBuyNow);
        txttotalcost = findViewById(R.id.textViewCostTotal);
        paypalStatus = findViewById(R.id.paypalStatus);
        NoofItems = findViewById(R.id.textViewItemsTotal);
        //ListView listViewDelivery = findViewById(R.id.listViewDelivery);
        LinearLayout hiddenDeliveryLayout = findViewById(R.id.hiddenCheckoutLayout);
        Bundle bundle = getIntent().getExtras();
        price = getIntent().getExtras().getDouble("ITEMPRICE", 0);
        qtt = getIntent().getExtras().getDouble("ITEMQTT", 0);
        NoofItems.setText(String.valueOf(qtt));
        txttotalcost.setText(String.valueOf(price));


        Intent cardresult = new Intent(CheckoutActivity.this, CardPayment.class);
        bundle.putDouble("ITEMPRICE", price);
        cardresult.putExtras(bundle);
        startActivity(cardresult);

        radioGroupDel.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                int radiBtnID = radioGroup.getCheckedRadioButtonId();

                if (radiBtnID == R.id.radioButtonPickup){
                    Toast.makeText(CheckoutActivity.this,
                            "Pickup Delivery selected",
                            Toast.LENGTH_SHORT).show();
                    hiddenDeliveryLayout.setVisibility(View.GONE);
                } else if (radiBtnID == R.id.radioButtonDelivery) {
                    Toast.makeText(CheckoutActivity.this,
                            "Home Delivery selected",
                            Toast.LENGTH_SHORT).show();
                    hiddenDeliveryLayout.setVisibility(View.VISIBLE);

                }

            }
        });



        btnBuyNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent result = new Intent(CheckoutActivity.this, CardPayment.class);
                startActivity(result);
            }
        });

    }



}