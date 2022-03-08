package com.example.urbanhomeapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class TableAdapter extends BaseAdapter {
    List<String> tableNames;
    List<Integer> tablePics;

    public TableAdapter(List<String> tableNames, List<Integer> tablePics) {
        this.tableNames = tableNames;
        this.tablePics = tablePics;
    }

    @Override
    public int getCount() {
        return tableNames.size();
    }

    @Override
    public String getItem(int i) {
        return tableNames.get(i);
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
        TextView textViewBeds = view.findViewById(R.id.textViewChair);
        ImageView imageViewBeds = view.findViewById(R.id.imageViewChair);

        textViewBeds.setText(tableNames.get(i));
        imageViewBeds.setImageResource(tablePics.get(i));

        textViewBeds.setText(tableNames.get(i));
        imageViewBeds.setImageResource(tablePics.get(i));

        return view;
    }
}
