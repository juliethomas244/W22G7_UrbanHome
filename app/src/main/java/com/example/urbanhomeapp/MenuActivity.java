package com.example.urbanhomeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MenuActivity extends AppCompatActivity {
    List<String> menu = new ArrayList<>(
            Arrays.asList("Sign In", "Sign Out", "Cart", "Policies", "Feedback", "Customer Support", "View Location")
    );
    ListView listViewMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        listViewMenu = findViewById(R.id.listViewMenu);
        MenuAdapter menuAdapter = new MenuAdapter(menu);
        listViewMenu.setAdapter(menuAdapter);

        listViewMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    //("Sign In", "Sign Out", "Cart", "Policies", "Feedback", "Customer Support")
                    case 3:
                        startActivity(new Intent(MenuActivity.this, PoliciesActivity.class));
                        break;
                    case 4:
                        startActivity(new Intent(MenuActivity.this, FeedbackActivity.class));
                        break;
                    case 5:
                        startActivity(new Intent(MenuActivity.this, CustomerSupportActivity.class));
                        break;
                    case 6:
                        startActivity(new Intent(MenuActivity.this, MapsActivity.class));
                }
            }
        });
    }
}