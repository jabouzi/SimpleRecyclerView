package com.skanderjabouzi.simplerecyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.TreeSet;

public class MyAdapter2 extends RecyclerView.Adapter<ViewHolder2> {
    private static final int TYPE_ITEM = 0;
    private static final int TYPE_SEPARATOR = 1;

    private ArrayList<String> mData = new ArrayList<String>();
    private TreeSet<Integer> sectionHeader = new TreeSet<Integer>();
    private LayoutInflater mInflater;
    private View view;
    private ItemClickListener mClickListener;

    // data is passed into the constructor
    MyAdapter2(Context context) {
        this.mInflater = LayoutInflater.from(context);
    }

    public void addItem(final String item) {
        mData.add(item);
        notifyDataSetChanged();
    }

    public void addSectionHeaderItem(final String item) {
        mData.add(item);
        sectionHeader.add(mData.size() - 1);
        notifyDataSetChanged();
    }

    public int getViewTypeCount() {
        return 2;
    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder2 onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case TYPE_ITEM:
                view = mInflater.inflate(R.layout.snippet_item1, parent, false);
                break;
            case TYPE_SEPARATOR:
                view = mInflater.inflate(R.layout.snippet_item2, parent, false);
                break;
        }
        return new ViewHolder2(view);
    }


    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(final ViewHolder2 holder, final int position) {
        holder.title.setText(mData.get(position));
        holder.setClickListener(mClickListener);
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public int getItemViewType(int position) {
        return sectionHeader.contains(position) ? TYPE_SEPARATOR : TYPE_ITEM;
    }

    // convenience method for getting data at click position
    public String getItem(int id) {
        return mData.get(id);
    }

    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }
}
