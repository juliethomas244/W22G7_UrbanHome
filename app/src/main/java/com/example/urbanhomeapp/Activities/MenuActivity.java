package com.example.urbanhomeapp.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.urbanhomeapp.Adapters.MenuAdapter;
import com.example.urbanhomeapp.R;
import com.facebook.AccessToken;
import com.facebook.login.LoginManager;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MenuActivity extends AppCompatActivity {
    List<String> menu = new ArrayList<>(
            Arrays.asList("Sign Out", "Order Details", "Policies", "Feedback", "Customer Support", "View Location")
    );
    ListView listViewMenu;
    GoogleSignInClient mGoogleSignInClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        listViewMenu = findViewById(R.id.listViewMenu);
        MenuAdapter menuAdapter = new MenuAdapter(menu);
        listViewMenu.setAdapter(menuAdapter);
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);


        AccessToken accessToken = AccessToken.getCurrentAccessToken();
        boolean isLoggedIn = accessToken != null && !accessToken.isExpired();



        listViewMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    //("Sign In", "Sign Out", "Cart", "Policies", "Feedback", "Customer Support")
                    case 0:
                        if (account != null){
                            String personId = account.getId();
                            String personName = account.getDisplayName();
                            signOut();
                        }else if(isLoggedIn){
                            LoginManager.getInstance().logOut();
                            startActivity(new Intent(MenuActivity.this, LoginActivity.class));
                            Toast.makeText(MenuActivity.this, "User Signed Out Successfully", Toast.LENGTH_SHORT).show();
                        }else{
                            startActivity(new Intent(MenuActivity.this, LoginActivity.class));
                            Toast.makeText(MenuActivity.this, "User Signed Out Successfully", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case 1:
                        startActivity(new Intent(MenuActivity.this, OrderDetailsActivity.class));
                        break;
                    case 2:
                        startActivity(new Intent(MenuActivity.this, PoliciesActivity.class));
                        break;
                    case 3:
                        startActivity(new Intent(MenuActivity.this, FeedbackActivity.class));
                        break;
                    case 4:
                        startActivity(new Intent(MenuActivity.this, CustomerSupportActivity.class));
                        break;
                    case 5:
                        startActivity(new Intent(MenuActivity.this, MapsActivity.class));
                        break;
                }
            }

        });




    }
    private void signOut() {
        mGoogleSignInClient.signOut()
                .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(MenuActivity.this, "User Signed Out Successfully", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                        startActivity(intent);
                    } });  }
}