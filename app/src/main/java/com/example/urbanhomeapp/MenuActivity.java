package com.example.urbanhomeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MenuActivity extends AppCompatActivity {
    List<String> menu = new ArrayList<>(
            Arrays.asList("Sign In", "Sign Out", "Cart", "Policies", "Feedback", "Customer Support")
    );
    ListView listViewMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        listViewMenu = findViewById(R.id.listViewMenu);
        MenuAdapter menuAdapter = new MenuAdapter(menu);
        listViewMenu.setAdapter(menuAdapter);
    }
}