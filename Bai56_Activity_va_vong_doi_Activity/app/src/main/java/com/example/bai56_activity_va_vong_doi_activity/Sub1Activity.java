package com.example.bai56_activity_va_vong_doi_activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Sub1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub1);
    }

    public void closeActivity(View view) {
        finish();
    }
}
