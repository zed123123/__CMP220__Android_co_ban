package com.example.bai29_anonymous_listener;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnDo, btnVang;
    TextView txtMau;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
    }

    private void addEvents() {
        btnDo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtMau.setTextColor(Color.RED);
                txtMau.setBackgroundColor(Color.YELLOW);
            }
        });

        btnVang.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                txtMau.setTextColor(Color.YELLOW);
                txtMau.setBackgroundColor(Color.RED);
                return false;
            }
        });
    }

    private void addControls() {
        btnDo = findViewById(R.id.btnDo);
        btnVang = findViewById(R.id.btnVang);
        txtMau = findViewById(R.id.txtMau);
    }
}
