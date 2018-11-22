package com.skanderjabouzi.simplerecyclerview;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class RecyclerViewActivity extends AppCompatActivity implements MyAdapter.ItemClickListener {

    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

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


        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        DividerItemDecoration itemDecorator = new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL);
        itemDecorator.setDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.divider));
        recyclerView.addItemDecoration(itemDecorator);
        adapter = new MyAdapter(this, books);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(this, "You clicked " + adapter.getItem(position).getPublishTime() + " on row number " + position, Toast.LENGTH_SHORT).show();
    }
}
