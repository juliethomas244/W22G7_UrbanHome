package com.example.urbanhomeapp.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "chair")
public class Chair {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "chairname")
    private String ChairName;
    @ColumnInfo(name = "chairimage")
    private int ChairImage;

    public Chair(@NonNull String chairName, int chairImage) {
        ChairName = chairName;
        ChairImage = chairImage;
    }

    public Chair() {
    }

    @NonNull
    public String getChairName() {
        return ChairName;
    }

    public void setChairName(@NonNull String chairName) {
        ChairName = chairName;
    }

    public int getChairImage() {
        return ChairImage;
    }

    public void setChairImage(int chairImage) {
        ChairImage = chairImage;
    }
}
