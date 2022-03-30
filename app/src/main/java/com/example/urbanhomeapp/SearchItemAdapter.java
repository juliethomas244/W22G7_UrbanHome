package com.example.urbanhomeapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SearchItemAdapter extends BaseAdapter implements Filterable {
    List<String> searchItemsList ;
    List<String> allItemsList;

    public SearchItemAdapter(List<String> searchItemsList) {
        this.searchItemsList = searchItemsList;
        this.allItemsList = new ArrayList<>(searchItemsList);
    }

    @Override
    public int getCount() {
        return searchItemsList.size();
    }

    @Override
    public String getItem(int i) {
        return searchItemsList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null){
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_searchitem, viewGroup, false);
        }
        TextView textViewItems = view.findViewById(R.id.textViewItems);

        textViewItems.setText(searchItemsList.get(i));
        return view;
    }

    @Override
    public Filter getFilter() {
        return filter;
    }


        Filter filter = new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                List<String> filteredList = new ArrayList<>();

                if(charSequence.toString().isEmpty()){
                    filteredList.addAll(allItemsList);
                } else {
                    for(String anyItem: allItemsList){
                        if (anyItem.toLowerCase().contains(charSequence.toString().toLowerCase())) {
                            filteredList.add(anyItem);
                        }
                    }
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = filteredList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                searchItemsList.clear();
                searchItemsList.addAll((Collection<? extends String>) filterResults.values);
                notifyDataSetChanged();
            }
        };
    }

