package com.skanderjabouzi.simplerecyclerview;

import android.content.Intent;
import androidx.core.content.ContextCompat;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class RecyclerViewActivity extends AppCompatActivity implements ItemClickListener {

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
        final RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        DividerItemDecoration itemDecorator = new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL);
        itemDecorator.setDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.divider));
        recyclerView.addItemDecoration(itemDecorator);
        adapter = new MyAdapter(this, books);
        recyclerView.setAdapter(adapter);
//        TextView text = findViewById(R.id.text);
        adapter.setClickListener(this);
//        text.setOnClickListener(
//                new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        LinearLayout onbaord = findViewById(R.id.onbaord);
//                        onbaord.setVisibility(View.GONE);
//                    }
//                }
//        );
//

        Intent intent = new Intent(this, TransparentActivity.class);
        startActivity(intent);
    }

    @Override
    public void onItemClick(View view, int position) {
        if (findViewById(R.id.onbaord).getVisibility() == View.GONE)
        Toast.makeText(this, "You clicked " + adapter.getItem(position).getPublishTime() + " on row number " + position, Toast.LENGTH_SHORT).show();
    }
}
