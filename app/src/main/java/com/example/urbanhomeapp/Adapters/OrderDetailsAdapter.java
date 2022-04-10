package com.example.urbanhomeapp.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.urbanhomeapp.R;
import com.example.urbanhomeapp.model.CartItem;

import java.util.List;

public class OrderDetailsAdapter extends BaseAdapter {
    List<CartItem> items;

    public OrderDetailsAdapter(List<CartItem> items) {
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
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
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_orderdetails, viewGroup, false);
        }
        TextView txtViewName = view.findViewById(R.id.txtViewItem2);
        TextView txtViewQuantity = view.findViewById(R.id.txtViewQuantity2);
        TextView txtViewPrice = view.findViewById(R.id.txtViewPrice2);

        txtViewName.setText(items.get(i).getName());
        txtViewQuantity.setText(String.valueOf(items.get(i).getQuantity()));
        txtViewPrice.setText(String.valueOf(items.get(i).getPrice()));

        return view;
    }
}
