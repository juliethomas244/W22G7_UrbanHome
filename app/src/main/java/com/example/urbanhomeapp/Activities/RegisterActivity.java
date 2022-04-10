package com.example.urbanhomeapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.urbanhomeapp.DBHelper.DBHelper;
import com.example.urbanhomeapp.R;

public class RegisterActivity extends AppCompatActivity {

    EditText username, password, repassword;
    Button btnSignUp, btnLogin;
    DBHelper myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        username = (EditText) findViewById(R.id.editTextusername);
        password = (EditText) findViewById(R.id.editTextpassword);
        repassword = (EditText) findViewById(R.id.editTextpasswordconfirm);

        btnSignUp = (Button) findViewById(R.id.buttonRegister);
        btnLogin = (Button) findViewById(R.id.buttonLoginLaypout);

        myDB = new DBHelper(this);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String repass = repassword.getText().toString();


                if(user.equals("") || pass.equals("")  || repass.equals(""))
                {
                    Toast.makeText(RegisterActivity.this, "Fill all the fields", Toast.LENGTH_SHORT).show();

                }
                else {
                    if(pass.equals(repass))
                    {
                        Boolean usercheckResult = myDB.checkusername(user);
                        if(usercheckResult == false){
                            Boolean regResult = myDB.insertData(user,pass) ;
                            if(regResult == true)   {
                                Toast.makeText(RegisterActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                            } else{
                                Toast.makeText(RegisterActivity.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                            }

                        }
                        else{
                            Toast.makeText(RegisterActivity.this, "User already exist. Please Sign In", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        Toast.makeText(RegisterActivity.this, "Password not Matching", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);

            }
        });


    }
}