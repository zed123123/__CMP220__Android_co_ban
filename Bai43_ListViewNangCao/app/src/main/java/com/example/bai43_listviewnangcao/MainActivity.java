package com.example.bai43_listviewnangcao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.adapter.SanPhamAdapter;
import com.example.model.SanPham;

public class MainActivity extends AppCompatActivity {

    ListView lvSanPham;
    SanPhamAdapter sanPhamAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
        addEvents();
        fakeData();
    }

    private void fakeData() {
        sanPhamAdapter.add(new SanPham(R.drawable.book1, "Sach 1", 15000));
        sanPhamAdapter.add(new SanPham(R.drawable.book2, "Sach 2", 30000));
        sanPhamAdapter.add(new SanPham(R.drawable.book3, "Sach 3", 150000));
        sanPhamAdapter.add(new SanPham(R.drawable.book4, "Sach 4", 25000));
        sanPhamAdapter.add(new SanPham(R.drawable.book5, "Sach 5", 50000));
        sanPhamAdapter.add(new SanPham(R.drawable.book6, "Sach 6", 95000));
    }

    private void addEvents() {
        lvSanPham.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SanPham sp = sanPhamAdapter.getItem(position);
                Toast.makeText(MainActivity.this, sp.getTen(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void addControls() {
        lvSanPham = findViewById(R.id.lvSanPham);
        sanPhamAdapter = new SanPhamAdapter(MainActivity.this, R.layout.item);
        lvSanPham.setAdapter(sanPhamAdapter);
    }
}
