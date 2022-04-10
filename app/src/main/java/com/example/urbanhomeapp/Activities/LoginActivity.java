package com.example.urbanhomeapp.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;


import com.example.urbanhomeapp.DBHelper.DBHelper;
import com.example.urbanhomeapp.R;
import com.facebook.AccessToken;
import com.facebook.FacebookSdk;


import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Arrays;

public class LoginActivity extends AppCompatActivity {

    String fullName;

    EditText username, password;
    Button btnsignin, btnsignup;


    GoogleSignInOptions gso;
    GoogleSignInClient gsc;
    ImageView googleBtn;
    ImageView fbBtn;
    CallbackManager callbackManager;
    FirebaseAuth mAuth;

    DBHelper myDB;
    //Button changing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_acivity);

        mAuth = FirebaseAuth.getInstance();
        FacebookSdk.sdkInitialize(getApplicationContext());

        fbBtn = findViewById(R.id.facebook_btn);
        callbackManager = CallbackManager.Factory.create();

        LoginManager.getInstance().registerCallback(callbackManager,
                new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {

                        handleFacebookAccessToken(loginResult.getAccessToken());
                    }

                    @Override
                    public void onCancel() {
                        // App code
                    }

                    @Override
                    public void onError(FacebookException exception) {
                        // App code
                    }
                });

        username = findViewById(R.id.editTextLoginEmail);
        password = findViewById(R.id.editTextLoginPassword);
        btnsignin = findViewById(R.id.buttonLogin);
        btnsignup = findViewById(R.id.buttonSignUp);

        myDB = new DBHelper(this);

        btnsignin.setOnClickListener((View view) -> {
            String user = username.getText().toString();
            String pass = password.getText().toString();

            if (user.equals("") || pass.equals("")) {
                Toast.makeText(LoginActivity.this, "Please enter the credentials.", Toast.LENGTH_SHORT).show();
            } else {
                Boolean result = myDB.checkusernamePassword(user, pass);

                if (result == true) {
                    Toast.makeText(LoginActivity.this, "LOGIN SUCCESSFUL", Toast.LENGTH_SHORT).show();
                    LoginSuccess();

                } else {
                    Toast.makeText(LoginActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                }


            }

        });

        btnsignup.setOnClickListener((View view) -> {
            finish();
            Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(intent);


        });

        googleBtn = findViewById(R.id.google_btn);


        fbBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                LoginManager.getInstance().logInWithReadPermissions(LoginActivity.this, Arrays.asList("public_profile"));

            }
        });



        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        gsc = GoogleSignIn.getClient(this, gso);

        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
        if (acct != null) {
            LoginSuccess();
        }


        googleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();
            }
        });

    }

    void signIn(){
        Intent signInIntent = gsc.getSignInIntent();
        startActivityForResult(signInIntent,1000);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);


        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1000){
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);

            try {
                task.getResult(ApiException.class);
                handleSignInResult(task);
            } catch (ApiException e) {
                Toast.makeText(getApplicationContext(), "Something went wrong " + e.getMessage(), Toast.LENGTH_SHORT).show();
                Log.d("ERROR", e.getMessage() );
            }
        }

    }

    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);
            if (account != null){
                String personName = account.getDisplayName();

                String personEmail = account.getEmail();
                String personId = account.getId();


                Toast.makeText(LoginActivity.this, " " + personName + " successfully Logged in", Toast.LENGTH_SHORT).show();


            }

            // Signed in successfully, show authenticated UI.

            LoginSuccess();

        } catch (ApiException e) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            Log.d("Google Error", e.getMessage());
            Toast.makeText(LoginActivity.this, "Google Sign in error", Toast.LENGTH_SHORT).show();

        }
    }




    private void handleFacebookAccessToken(AccessToken token) {

        AuthCredential credential = FacebookAuthProvider.getCredential(token.getToken());
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser user = mAuth.getCurrentUser();
                            Toast.makeText(LoginActivity.this, "User successfully Logged in", Toast.LENGTH_SHORT).show();
                            LoginSuccess();

                        } else {
                            Toast.makeText(LoginActivity.this, "" + task.getException(), Toast.LENGTH_SHORT).show();

                        }
                    }
                });

    }


    void LoginSuccess(){
            finish();
            Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
            startActivity(intent);
    }

    }

