package com.skanderjabouzi.simplerecyclerview;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class ViewHolder2 extends RecyclerView.ViewHolder  implements View.OnClickListener  {
    TextView title;
    public ImageView image;
    private ViewGroup container;
    private ItemClickListener mClickListener;

    public ViewHolder2(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
        title = (TextView) itemView.findViewById(R.id.text);
        image = itemView.findViewById(R.id.image);
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
