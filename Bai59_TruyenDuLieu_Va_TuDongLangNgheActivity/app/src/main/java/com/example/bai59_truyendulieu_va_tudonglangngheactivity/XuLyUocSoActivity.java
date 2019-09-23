package com.example.bai59_truyendulieu_va_tudonglangngheactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class XuLyUocSoActivity extends AppCompatActivity {

    TextView txtN;
    Button btnTraVe;
    Intent intent = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xu_ly_uoc_so);
        addControls();
        addEvents();
    }

    private void addEvents() {
        btnTraVe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLyTraUocSo();
            }
        });
    }

    private void xuLyTraUocSo() {
        int n = Integer.parseInt(txtN.getText().toString());
        ArrayList<Integer> dsUocSo = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            if(n % i == 0){
                dsUocSo.add(i);
            }
        }

        intent.putExtra("DSUS", dsUocSo);
        setResult(115, intent);
        finish();
    }

    private void addControls() {
        intent = getIntent();
        int n = intent.getIntExtra("N", 0);
        txtN = findViewById(R.id.txtN);
        btnTraVe = findViewById(R.id.btnTraVe);
        txtN.setText(n + "");
    }
}
