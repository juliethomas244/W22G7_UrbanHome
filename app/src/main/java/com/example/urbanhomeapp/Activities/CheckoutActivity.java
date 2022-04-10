package com.example.urbanhomeapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.urbanhomeapp.R;

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
        EditText checkoutName = findViewById(R.id.editTextCheckoutName);
        EditText checkoutEmail = findViewById(R.id.editTextCheckoutEmail);
        txttotalcost = findViewById(R.id.textViewCostTotal);
        paypalStatus = findViewById(R.id.paypalStatus);
        NoofItems = findViewById(R.id.textViewItemsTotal);

        EditText deliveryAddress = findViewById(R.id.editTextDeliveryAddress);
        EditText deliveryProvince = findViewById(R.id.editTextProvince);
        EditText deliveryPostalCode = findViewById(R.id.editTextPostalCode);
        EditText deliveryCity = findViewById(R.id.editTextCity);
        EditText deliveryCountry = findViewById(R.id.editTextCountry);


        //ListView listViewDelivery = findViewById(R.id.listViewDelivery);
        LinearLayout hiddenDeliveryLayout = findViewById(R.id.hiddenCheckoutLayout);
        Bundle bundle = getIntent().getExtras();
        price = getIntent().getExtras().getDouble("ITEMPRICE", 0);
        qtt = getIntent().getExtras().getDouble("ITEMQTT", 0);
        NoofItems.setText(String.valueOf(qtt));
        txttotalcost.setText(String.valueOf(price));

        radioGroupDel.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                int radiBtnID = radioGroup.getCheckedRadioButtonId();

                if (radiBtnID == R.id.radioButtonPickup) {
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
                if (radioGroupDel.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(CheckoutActivity.this,
                            "Please select Delivery Type",
                            Toast.LENGTH_SHORT).show();
                } else if (checkoutName.getText().toString().isEmpty()) {
                    Toast.makeText(CheckoutActivity.this,
                            "Please enter your Name",
                            Toast.LENGTH_SHORT).show();
                } else if (checkoutEmail.getText().toString().isEmpty()) {
                    Toast.makeText(CheckoutActivity.this,
                            "Please enter Email",
                            Toast.LENGTH_SHORT).show();
                } else if (radioGroupDel.getCheckedRadioButtonId() == R.id.radioButtonDelivery){
                    if (deliveryAddress.getText().toString().isEmpty()) {
                        Toast.makeText(CheckoutActivity.this,
                                "Please enter Delivery Address",
                                Toast.LENGTH_SHORT).show();
                    }else if (deliveryProvince.getText().toString().isEmpty()) {
                        Toast.makeText(CheckoutActivity.this,
                                "Please enter Delivery Address",
                                Toast.LENGTH_SHORT).show();
                    }else if (deliveryPostalCode.getText().toString().isEmpty()) {
                        Toast.makeText(CheckoutActivity.this,
                                "Please enter Postal Code",
                                Toast.LENGTH_SHORT).show();
                    }else if (deliveryCity.getText().toString().isEmpty()) {
                        Toast.makeText(CheckoutActivity.this,
                                "Please enter City",
                                Toast.LENGTH_SHORT).show();
                    }else if(deliveryCountry.getText().toString().isEmpty()) {
                        Toast.makeText(CheckoutActivity.this,
                                "Please enter Country",
                                Toast.LENGTH_SHORT).show();
                    }else {


                        Intent result = new Intent(CheckoutActivity.this, CardPayment.class);
                        bundle.putDouble("ITEMPRICE", price);
                        result.putExtras(bundle);
                        startActivity(result);
                    }

                }
                else {


                    Intent result = new Intent(CheckoutActivity.this, CardPayment.class);
                    bundle.putDouble("ITEMPRICE", price);
                    result.putExtras(bundle);
                    startActivity(result);
                }
            }
        });

    }



}