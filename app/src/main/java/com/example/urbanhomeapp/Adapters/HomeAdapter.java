package com.example.urbanhomeapp.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.urbanhomeapp.R;

import java.util.List;

public class HomeAdapter extends BaseAdapter {
    List<String> names;
    List<Integer> pics;

    public HomeAdapter(List<String> names, List<Integer> pics) {
        this.names = names;
        this.pics = pics;
    }

    @Override
    public int getCount() {
        return names.size();
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
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_category, viewGroup, false);
        }
        TextView txtViewItem = view.findViewById(R.id.txtViewItem);
        ImageView imgViewItem = view.findViewById(R.id.imgViewItem);

        txtViewItem.setText(names.get(i));
        imgViewItem.setImageResource(pics.get(i));

        return view;
    }
}
