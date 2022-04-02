package com.example.urbanhomeapp;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.urbanhomeapp.model.CartItem;
import com.example.urbanhomeapp.model.Feedback;

@Database(entities = {CartItem.class}, version = 1)
public abstract class CartDatabase extends RoomDatabase {
    public abstract CartDao cartDao();
}
