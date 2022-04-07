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

        //Paypal client ID generated from sandbox account
    public static final String clientKey = "AeQuAGkwumjw_CDMJkYaCj3JY0zv-G2VHGKfB6FHOk-b71ttERUl72HoQezt-XnKROvlf2j1T48W-eRU";
    public static final int PAYPAL_REQUEST_CODE = 123;
    TextView txttotalcost;
    TextView paypalStatus;
    TextView NoofItems;
    Double price,qtt;
                // Paypal Configuration Object
    private static PayPalConfiguration config = new PayPalConfiguration()
            // Start with mock environment.  When ready,
            // switch to sandbox (ENVIRONMENT_SANDBOX)
            // or live (ENVIRONMENT_PRODUCTION)
            .environment(PayPalConfiguration.ENVIRONMENT_SANDBOX)
            // on below line we are passing a client id.
            .clientId(clientKey);


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
                makePayment();
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // If the result is from paypal
        if (requestCode == PAYPAL_REQUEST_CODE) {

            // If the result is OK i.e. user has not canceled the payment
            if (resultCode == Activity.RESULT_OK) {

                // Getting the payment confirmation
                PaymentConfirmation confirm = data.getParcelableExtra(PaymentActivity.EXTRA_RESULT_CONFIRMATION);

                // if confirmation is not null
                if (confirm != null) {
                    try {
                        // Getting the payment details
                        String paymentDetails = confirm.toJSONObject().toString(4);
                        // on below line we are extracting json response and displaying it in a text view.
                        JSONObject payObj = new JSONObject(paymentDetails);
                        String payID = payObj.getJSONObject("response").getString("id");
                        String state = payObj.getJSONObject("response").getString("state");
                        paypalStatus.setText("Payment " + state + "\n with payment id is " + payID);
                    } catch (JSONException e) {
                        // handling json exception on below line
                        Log.e("Error", "an extremely unlikely failure occurred: ", e);
                    }
                }
            } else if (resultCode == Activity.RESULT_CANCELED) {
                // on below line we are checking the payment status.
                Log.i("paymentExample", "The user canceled.");
            } else if (resultCode == PaymentActivity.RESULT_EXTRAS_INVALID) {
                // on below line when the invalid paypal config is submitted.
                Log.i("paymentExample", "An invalid Payment or PayPalConfiguration was submitted. Please see the docs.");
            }
        }
    }

    private void makePayment() {

        // Getting the amount from editText
        String amount = txttotalcost.getText().toString();

        // Creating a paypal payment on below line.
        PayPalPayment payment = new PayPalPayment(new BigDecimal(String.valueOf(amount)), "USD", "Course Fees",
                PayPalPayment.PAYMENT_INTENT_SALE);

        // Creating Paypal Payment activity intent
        Intent intent = new Intent(this, PaymentActivity.class);

        //putting the paypal configuration to the intent
        intent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION, config);

        // Putting paypal payment to the intent
        intent.putExtra(PaymentActivity.EXTRA_PAYMENT, payment);

        // Starting the intent activity for result
        // the request code will be used on the method onActivityResult
        startActivityForResult(intent, PAYPAL_REQUEST_CODE);
    }


}