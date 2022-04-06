package com.example.urbanhomeapp;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.urbanhomeapp.model.CartItem;

import java.util.List;

@Dao
public interface CartDao {
    @Insert
    void insertItem(CartItem cartItem);

    @Update
    void updateItem(CartItem cartItem);

    @Delete
    void deleteItem(CartItem cartItem);

    @Query("SELECT * FROM CartItem")
    List<CartItem> getAllCartItems();

    @Query("SELECT * FROM CartItem WHERE id=:ItemId")
    List<CartItem> GetItemWithIds(List<String> ItemId);

    @Query("DELETE FROM CartItem WHERE name=:itemName")
    int deleteItemWithName(String itemName);
}