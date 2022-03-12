package com.example.urbanhomeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FeedbackActivity extends AppCompatActivity {
    EditText editTextEmail;
    EditText editTextMsg;
    Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        editTextEmail = findViewById(R.id.editTextEmail);
        editTextMsg = findViewById(R.id.editTextMsg);
        btnSend = findViewById(R.id.btnSend);

        btnSend.setOnClickListener((View view)->{
            if (editTextEmail.getText().toString().isEmpty()) {
                Toast.makeText(this, "Email is invalid", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Thanks for contacting us. We'll get back to you as soon as possible.", Toast.LENGTH_SHORT).show();
                editTextEmail.setText("");
                editTextMsg.setText("");
            }
        });
    }
}