package com.example.urbanhomeapp.Database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.urbanhomeapp.Daos.CartDao;
import com.example.urbanhomeapp.model.CartItem;

@Database(entities = {CartItem.class}, version = 1)
public abstract class CartDatabase extends RoomDatabase {
    public abstract CartDao cartDao();
}
