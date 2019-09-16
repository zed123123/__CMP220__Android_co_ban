package com.example.bai32_explicit_class_listener;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button btnMove, btnThoat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
    }

    private void addEvents() {
        btnMove.setOnClickListener(new MyEvent());
        btnThoat.setOnClickListener(new MyEvent());
        btnMove.setOnLongClickListener(new MyEvent());
    }

    private void addControls() {
        btnMove = findViewById(R.id.btnMove);
        btnThoat = findViewById(R.id.btnThoat);
    }

    class MyEvent implements View.OnClickListener, View.OnLongClickListener {

        @Override
        public void onClick(View v) {
            if(v == btnMove){
               Random rd = new Random();
               int x = rd.nextInt(300);
               int y = rd.nextInt(1000);
               btnMove.setX(x);
               btnMove.setY(y);
            }
            else if(v == btnThoat){
                finish();
            }
        }

        @Override
        public boolean onLongClick(View v) {
            btnMove.setTextColor(Color.RED);
            return false;
        }
    }
}
