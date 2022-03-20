package com.example.urbanhomeapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class MenuAdapter extends BaseAdapter {
    List<String> menu;

    public MenuAdapter(List<String> menu) {
        this.menu = menu;
    }

    @Override
    public int getCount() {
        return menu.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null){
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_menu, viewGroup, false);
        }
        TextView txtViewMenu = view.findViewById(R.id.txtViewMenu);
        txtViewMenu.setText(menu.get(i));

        return view;
    }
}
