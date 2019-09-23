package com.example.bai54_baitaprenluyen9;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;

import com.example.adapter.NhanVienAdapter;
import com.example.model.NhanVien;

public class MainActivity extends AppCompatActivity {

    EditText txtMa, txtTen;
    RadioButton radNu, radNam;
    Button btnNhap;
    ImageView imgXoa;
    ListView lvNhanVien;

    NhanVienAdapter nhanVienAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
    }

    private void addEvents() {
        btnNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLyNhapNhanVien();
                clearText();
            }
        });

        imgXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLyXoa();
            }
        });


    }

    private void xuLyXoa() {
        for(int i = nhanVienAdapter.getCount()-1; i >= 0; i--){
            NhanVien nv = nhanVienAdapter.getItem(i);
            if(nv.isXoa()){
                nhanVienAdapter.remove(nv);
            }
        }
    }

    private void clearText() {
        txtMa.setText("");
        txtTen.setText("");
        radNam.setChecked(true);
        radNu.setChecked(false);
    }


    private void xuLyNhapNhanVien() {
        NhanVien nv = new NhanVien();
        nv.setMa(txtMa.getText().toString());
        nv.setTen(txtTen.getText().toString());
        nv.setNu(radNu.isChecked());
        nv.setXoa(false);
        nhanVienAdapter.add(nv);
    }

    private void addControls() {
        txtMa = findViewById(R.id.txtMa);
        txtTen = findViewById(R.id.txtTen);
        radNu = findViewById(R.id.radNu);
        radNam = findViewById(R.id.radNam);
        btnNhap = findViewById(R.id.btnNhap);
        imgXoa = findViewById(R.id.imgXoa);
        lvNhanVien = findViewById(R.id.lvNhanVien);

        nhanVienAdapter = new NhanVienAdapter(MainActivity.this, R.layout.item);
        lvNhanVien.setAdapter(nhanVienAdapter);
    }
}
