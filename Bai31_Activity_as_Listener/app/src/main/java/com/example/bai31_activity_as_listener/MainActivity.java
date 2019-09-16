package com.example.bai31_activity_as_listener;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnLongClickListener {

    Button btnHinh1, btnHinh2;
    ImageView imgHinh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
    }

    private void addEvents() {
        btnHinh1.setOnClickListener(this);
        btnHinh2.setOnClickListener(this);
        imgHinh.setOnLongClickListener(this);
        imgHinh.setOnClickListener(this);
    }

    private void addControls() {
        btnHinh1 = findViewById(R.id.btnHinh1);
        btnHinh2 = findViewById(R.id.btnHinh2);
        imgHinh = findViewById(R.id.imgHinh);
    }

    @Override
    public void onClick(View v) {
        if(v == btnHinh1){
            imgHinh.setImageResource(R.drawable.hinh1);
        }
        else if(v == btnHinh2){
            imgHinh.setImageResource(R.drawable.hinh2);
        }
        else if(v == imgHinh){
            imgHinh.setImageResource(R.drawable.hinh3);
        }
    }

    @Override
    public boolean onLongClick(View v) {
        imgHinh.setVisibility(View.GONE);
        return false;
    }
}
