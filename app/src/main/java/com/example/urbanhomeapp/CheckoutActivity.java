package com.example.urbanhomeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Toast;

public class CheckoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);
        RadioGroup radioGroupDel = findViewById(R.id.radioGroup);
        Button btnBuyNow = findViewById(R.id.buttonBuyNow);
        Button btnPaypal = findViewById(R.id.buttonBuyNowPaypal);
        //ListView listViewDelivery = findViewById(R.id.listViewDelivery);
        LinearLayout hiddenDeliveryLayout = findViewById(R.id.hiddenCheckoutLayout);


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
                Toast.makeText(CheckoutActivity.this, "Order placed", Toast.LENGTH_SHORT).show();
            }
        });
    }
}