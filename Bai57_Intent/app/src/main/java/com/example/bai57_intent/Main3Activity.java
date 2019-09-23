package com.example.bai57_intent;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.model.DanhBa;

import java.util.ArrayList;

public class Main3Activity extends AppCompatActivity {

    TextView txtData;
    DanhBa data;

    ListView lvDanhBa;
    ArrayAdapter<DanhBa> danhBaAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        addControls();
        addEvents();
    }

    private void addEvents() {
        txtData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:" + data.getPhone()));
                startActivity(intent);
            }
        });
    }

    private void addControls() {
        txtData = findViewById(R.id.txtData);
        Intent intent = getIntent();
        data = (DanhBa) intent.getSerializableExtra("OBJ");
        txtData.setText(data.getTen() + "\n" + data.getPhone());

        lvDanhBa = findViewById(R.id.lvDanhBa);
        danhBaAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        danhBaAdapter
    }
}
