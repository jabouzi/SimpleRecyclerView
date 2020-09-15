package com.skanderjabouzi.simplerecyclerview;

import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.ItemTouchHelper;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RecyclerViewActivity2 extends AppCompatActivity implements ItemClickListener {

    MyAdapter2 adapter;
    private HashMap<String, ArrayList<String>> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view2);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        DividerItemDecoration itemDecorator = new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL);
        itemDecorator.setDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.divider));
        recyclerView.addItemDecoration(itemDecorator);

        adapter = new MyAdapter2(this);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);

        SwipeController swipeController = new SwipeController();
        ItemTouchHelper itemTouchhelper = new ItemTouchHelper(swipeController);
        itemTouchhelper.attachToRecyclerView(recyclerView);

        list = new HashMap<>();
        ArrayList<String> data1 = new ArrayList<String>();
        ArrayList<String> data2 = new ArrayList<String>();

        for (int i = 1; i < 20; i++) {
            data1.add("Row Item #" + i + "Section # 1");
        }
        for (int i = 1; i < 15; i++) {
            data2.add("Row Item #" + i + "Section # 2");
        }

        list.put("Section 1", data1);
        list.put("Section 2", data2);

        for (Map.Entry<String, ArrayList<String>> m : list.entrySet()) {
            Log.e("SECTION: ", m.getKey());
            adapter.addSectionHeaderItem(m.getKey());
            ArrayList<String> value = m.getValue();
            for (int i = 0; i < value.size(); i++) {
                adapter.addItem(value.get(i));
            }
        }
    }

    @Override
    public void onItemClick(View view, int position) {
        if (adapter.getItemViewType(position) == 0) {
            Toast.makeText(this, "You clicked " + adapter.getItem(position) + " on row number " + position, Toast.LENGTH_SHORT).show();
        }
    }
}
