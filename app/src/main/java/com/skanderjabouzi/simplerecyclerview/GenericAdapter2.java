package com.skanderjabouzi.simplerecyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

abstract public class GenericAdapter2<T, VH extends GenericViewHolder<T>> extends RecyclerView.Adapter<VH> {
    private List<T> items;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;
    public VH viewHolder;

    // data is passed into the constructor
    GenericAdapter2(Context context) {
        this.mInflater = LayoutInflater.from(context);
        items = new ArrayList<>();
    }

    // inflates the row layout from xml when needed
    @Override
    public abstract VH onCreateViewHolder(ViewGroup parent, int viewType);

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(final VH holder, final int position) {
        if (items.size() <= position) {
            return;
        }
        T item = items.get(position);
        holder.onBind(item);
        holder.setClickListener(mClickListener);
    }

    public void setItems(List<T> items) {
        setItems(items, true);
    }

    public void setItems(List<T> items, boolean notifyChanges) throws IllegalArgumentException {
        if (items == null) {
            throw new IllegalArgumentException("Cannot set `null` item to the Recycler adapter");
        }
        this.items.clear();
        this.items.addAll(items);
        if (notifyChanges) {
            notifyDataSetChanged();
        }
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return items.size();
    }

    // convenience method for getting data at click position
    T getItem(int id) {
        return items.get(id);
    }

    // allows clicks events to be caught
    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }
}

