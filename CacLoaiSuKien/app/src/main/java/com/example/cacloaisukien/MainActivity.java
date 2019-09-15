package com.example.cacloaisukien;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnAnonymous, btnNhanLau1, btnNhanLau2;


    View.OnLongClickListener eventNhanLau;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvent();
        EventNhanLau();

    }

    private void EventNhanLau() {
        eventNhanLau = new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                return false;
            }
        };nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn
    }


    private void addEvent() {
        btnAnonymous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnAnonymous.setVisibility(View.INVISIBLE);
            }
        });
    }

    private void addControls() {
        btnAnonymous = findViewById(R.id.btnAnonymous);
        btnNhanLau1 = findViewById(R.id.btnNhanLau1);
        btnNhanLau2 = findViewById(R.id.btnNhanLau2);
    }

    public void toChuDo(View view) {
        Button btn = (Button) view;
        btn.setTextColor(Color.RED);
    }

    public void clickAn(View view) {
    }
}
