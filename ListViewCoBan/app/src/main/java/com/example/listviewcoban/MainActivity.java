package com.example.listviewcoban;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void moClickView1(View view) {
        Intent intent = new Intent(MainActivity.this, ListView1Activity.class);
        startActivity(intent);
    }
    public void moClickView2(View view) {
        Intent intent = new Intent(MainActivity.this, ListView2Activity.class);
        startActivity(intent);
    }
}
