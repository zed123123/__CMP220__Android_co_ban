package com.example.listviewcoban;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListView1Activity extends AppCompatActivity {


    ListView lvTinhThanh;
    ArrayAdapter<String>adapterTinhThanh;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view1);
        addControls();
        addEvents();
    }

    private void addEvents() {
        lvTinhThanh.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String data = adapterTinhThanh.getItem(position);
                Toast.makeText(
                        ListView1Activity.this,
                        "Bạn chọn dòng " + position + "\nCó dữ liệu: " + data,
                        Toast.LENGTH_SHORT)
                        .show();
            }
        });

        lvTinhThanh.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                String data = adapterTinhThanh.getItem(position);
                adapterTinhThanh.remove(data);
                Toast.makeText(ListView1Activity.this, "Đã xóa dữ liệu: " + data, Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }

    private void addControls() {
        lvTinhThanh = findViewById(R.id.lvTinhThanh);
        adapterTinhThanh = new ArrayAdapter<>(ListView1Activity.this, android.R.layout.simple_list_item_1);
        lvTinhThanh.setAdapter(adapterTinhThanh);
        String []arrayTinhThanh = getResources().getStringArray(R.array.arrTinhThanh);
        adapterTinhThanh.addAll(arrayTinhThanh);
    }
}
