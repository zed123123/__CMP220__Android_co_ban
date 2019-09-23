package com.example.bai57_intent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    TextView txtData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        addControls();
        addEvents();
    }

    private void addEvents() {

    }

    private void addControls() {
        txtData = findViewById(R.id.txtData);
        Intent intent = getIntent();
        int x = intent.getIntExtra("X",0);
        double y = intent.getDoubleExtra("y", 0);
        boolean z = intent.getBooleanExtra("z", false);
        String w = intent.getStringExtra("w");
        String kq = "X= " + x + "\ny= " + y + "\nz= " + z + "\nw= " + w;
        txtData.setText(kq);
    }
}
