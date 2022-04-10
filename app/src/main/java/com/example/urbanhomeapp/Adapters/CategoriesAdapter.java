package com.example.urbanhomeapp.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.urbanhomeapp.R;

import java.util.List;

public class CategoriesAdapter extends BaseAdapter {
    List<String> itemDesc;
    List<Integer> itemPics;

    public CategoriesAdapter(List<String> itemDesc, List<Integer> itemPics) {
        this.itemDesc = itemDesc;
        this.itemPics = itemPics;
    }

    public CategoriesAdapter(List<String> itemDesc) {
        this.itemDesc = itemDesc;
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
        TextView textViewCategories = view.findViewById(R.id.textViewCategories);
        ImageView imageViewCategories = view.findViewById(R.id.imageViewCategories);

        textViewCategories.setText(itemDesc.get(i));
        imageViewCategories.setImageResource(itemPics.get(i));

        return view;
    }
}
