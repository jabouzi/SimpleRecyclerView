package com.skanderjabouzi.simplerecyclerview;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerViewDynamicActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_dynamic);
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add("Item " + i);
        }

        ArrayList<Book> books = new ArrayList<>();
        Book mBook = new Book();
        mBook.setBookName("Android Developer Guide");
        mBook.setAuthor("Leon");
        mBook.setPublishTime(2014);
        books.add(mBook);
        mBook = new Book();
        mBook.setBookName("C++ Developer Guide");
        mBook.setAuthor("John");
        mBook.setPublishTime(2015);
        books.add(mBook);
        mBook = new Book();
        mBook.setBookName("Java Developer Guide");
        mBook.setAuthor("Marc");
        mBook.setPublishTime(2013);
        books.add(mBook);
        mBook = new Book();
        mBook.setBookName("C# Developer Guide");
        mBook.setAuthor("Steve");
        mBook.setPublishTime(2010);
        books.add(mBook);
        mBook = new Book();
        mBook.setBookName("Swift Developer Guide");
        mBook.setAuthor("Stewart");
        mBook.setPublishTime(2009);
        books.add(mBook);
        mBook = new Book();
        mBook.setBookName("PHP Developer Guide");
        mBook.setAuthor("Jim");
        mBook.setPublishTime(2008);
        books.add(mBook);
        mBook = new Book();
        mBook.setBookName("Objective-C Developer Guide");
        mBook.setAuthor("Robert");
        mBook.setPublishTime(20007);
        books.add(mBook);
        mBook.setBookName("Objective-C Developer Guide");
        mBook.setAuthor("Robert");
        mBook.setPublishTime(20007);
        books.add(mBook);

        final RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        DividerItemDecoration itemDecorator = new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL);
        itemDecorator.setDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.divider));
        recyclerView.addItemDecoration(itemDecorator);

//        GenericAdapter<String> adapter = new GenericAdapter<String>(this, list) {
//            @Override
//            public RecyclerView.ViewHolder setViewHolder(ViewGroup parent) {
//                final View view =  LayoutInflater.from(getApplicationContext()).inflate(R.layout.snippet_item2, parent, false);
//                ViewHolder viewHolder = new ViewHolder(view);
//                return viewHolder;
//            }
//
//            @Override
//            public void onBindData(RecyclerView.ViewHolder holder, String val) {
//                TextView title = (TextView) holder.itemView.findViewById(R.id.text);
//                title.setText(val);
//            }
//        };

        GenericAdapter2<Book, ViewHolder3> adapter = new GenericAdapter2<Book, ViewHolder3>(this) {
            @Override
            public ViewHolder3 onCreateViewHolder(ViewGroup parent, int viewType) {
                final View view =  LayoutInflater.from(getApplicationContext()).inflate(R.layout.list_item, parent, false);
                viewHolder = new ViewHolder3(view);
                return viewHolder;
            }
        };
        adapter.setItems(books);
        recyclerView.setAdapter(adapter);
    }
}
