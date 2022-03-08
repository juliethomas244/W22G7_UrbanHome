package com.example.urbanhomeapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ChairAdapter extends BaseAdapter {
    List<String> itemDesc;
    List<Integer> itemPics;

    public ChairAdapter(List<String> itemDesc, List<Integer> itemPics) {
        this.itemDesc = itemDesc;
        this.itemPics = itemPics;
    }

    @Override
    public int getCount() {
        return itemDesc.size();
    }

    @Override
    public String getItem(int i) {
        return itemDesc.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null){
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layoutsubcategories, viewGroup, false);
        }
        TextView textViewChair = view.findViewById(R.id.textViewChair);
        ImageView imageViewChair = view.findViewById(R.id.imageViewChair);

        textViewChair.setText(itemDesc.get(i));
        imageViewChair.setImageResource(itemPics.get(i));

        textViewChair.setText(itemDesc.get(i));
        imageViewChair.setImageResource(itemPics.get(i));

        return view;
    }
}
