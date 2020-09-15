package com.skanderjabouzi.simplerecyclerview;

import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

public abstract class GenericViewHolder<T> extends RecyclerView.ViewHolder implements View.OnClickListener {

    private ViewGroup container;
    private ItemClickListener mClickListener;

    public GenericViewHolder(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
    }

    public abstract void onBind(T val);

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
