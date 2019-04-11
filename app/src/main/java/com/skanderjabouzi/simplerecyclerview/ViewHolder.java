package com.skanderjabouzi.simplerecyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    TextView title;
    private ViewGroup container;
    private ItemClickListener mClickListener;

    public ViewHolder(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
        title = (TextView) itemView.findViewById(R.id.itemName);
        container = (ViewGroup) itemView.findViewById(R.id.list_item_container);
    }

    public ViewGroup getContainer() {
        return container;
    }

    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    @Override
    public void onClick(View view) {
        if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
    }
}
