package com.example.bai63_baitaprenluyen12;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.adapter.MyFileAdapter;

public class MainActivity extends AppCompatActivity {

    ListView lvMyFile;
    MyFileAdapter myFileAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
