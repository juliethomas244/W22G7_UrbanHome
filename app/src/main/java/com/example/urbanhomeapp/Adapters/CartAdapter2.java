package com.example.urbanhomeapp.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.urbanhomeapp.R;
import com.example.urbanhomeapp.model.CartItem;

import java.util.List;

public class CartAdapter2 extends BaseAdapter {
    List<CartItem> items;

    public CartAdapter2(List<CartItem> items) {
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
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_cartitems, viewGroup, false);
        }
        TextView txtViewName = view.findViewById(R.id.txtViewName);
        TextView txtViewQuantity = view.findViewById(R.id.txtViewQuantity);
        TextView txtViewPrice = view.findViewById(R.id.txtViewPrice);

        txtViewName.setText(items.get(i).getName());
        txtViewQuantity.setText(String.valueOf(items.get(i).getQuantity()));
        txtViewPrice.setText(String.valueOf(items.get(i).getPrice()));

        return view;
    }
}
