package com.example.bai30_variable_as_listener;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Button btnAn, btnHienThi;
    ImageView imgHinh;

    View.OnClickListener myEvent = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(v == btnAn){
                imgHinh.setVisibility(View.INVISIBLE);
            }
            else if(v == btnHienThi){
                imgHinh.setVisibility(View.VISIBLE);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
    }

    private void addEvents() {
        btnAn.setOnClickListener(myEvent);
        btnHienThi.setOnClickListener(myEvent);
    }

    private void addControls() {
        btnAn = findViewById(R.id.btnAn);
        btnHienThi = findViewById(R.id.btnHienThi);
        imgHinh = findViewById(R.id.imgHinh);
    }
}
