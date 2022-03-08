package com.example.urbanhomeapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class BedAdapter extends BaseAdapter {

    List<String> bedNames;
    List<Integer> bedPics;

    public BedAdapter(List<String> bedNames, List<Integer> bedPics) {
        this.bedNames = bedNames;
        this.bedPics = bedPics;
    }

    @Override
    public int getCount() {
        return bedNames.size();
    }

    @Override
    public String getItem(int i) {
        return bedNames.get(i);
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

        textViewChair.setText(bedNames.get(i));
        imageViewChair.setImageResource(bedPics.get(i));

        return view;
    }
}
