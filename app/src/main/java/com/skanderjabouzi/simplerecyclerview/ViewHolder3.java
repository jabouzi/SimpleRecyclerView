package com.skanderjabouzi.simplerecyclerview;

import android.view.View;

import com.skanderjabouzi.simplerecyclerview.databinding.ListItemBinding;

public class ViewHolder3 extends GenericViewHolder<Book>{

    ListItemBinding listItemBinding;

    public ViewHolder3(View itemView) {
        super(itemView);
        listItemBinding = ListItemBinding.bind(itemView);
    }

    @Override
    public void onBind(Book book) {
        listItemBinding.author.setText(book.getAuthor());
        listItemBinding.bookName.setText(book.getBookName());
        listItemBinding.publishTime.setText(String.valueOf(book.getPublishTime()));
    }
}
