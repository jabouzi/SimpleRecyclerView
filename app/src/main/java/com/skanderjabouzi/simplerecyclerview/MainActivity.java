package com.skanderjabouzi.simplerecyclerview;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button button1;
    Button button2;
    Button button3;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button1.setOnClickListener(buttonClicked);
        button2.setOnClickListener(buttonClicked);
        button3.setOnClickListener(buttonClicked);
        button2.setBackground(getDrawable(R.drawable.button_blue));
        button3.setBackground(getDrawable(R.drawable.button_blue));

    }

    private View.OnClickListener buttonClicked = new View.OnClickListener() {
        public void onClick(View v) {
            // So we will make
            switch (v.getId() /*to get clicked view id**/) {
                case R.id.button1:
                    intent = new Intent(v.getContext(), RecyclerViewActivity.class);
                    startActivity(intent);
                    break;
                case R.id.button2:
                    intent = new Intent(v.getContext(), RecyclerViewActivity2.class);
                    startActivity(intent);
                    break;
                case R.id.button3:
                    intent = new Intent(v.getContext(), RecyclerViewDynamicActivity.class);
                    startActivity(intent);
                    break;
                default:
                    break;
            }
        }
    };
}
