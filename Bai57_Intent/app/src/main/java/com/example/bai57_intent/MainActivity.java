package com.example.bai57_intent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.model.DanhBa;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void xuLyTruyenDuLieu(View view) {
        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
        intent.putExtra("X", 5);
        intent.putExtra("y", 5.6);
        intent.putExtra("z", true);
        intent.putExtra("w", "Hey dude!");
        startActivity(intent);
    }

    public void xuLyTruyenDuLieuDoiTuong(View view) {
        Intent intent = new Intent(MainActivity.this, Main3Activity.class);
        DanhBa teo = new DanhBa("Tèo Đại Bàng", "0123456789");
        intent.putExtra("OBJ", teo);

        ArrayList<DanhBa> ds = DanhBa.duLieuMau(500);
        intent.putExtra("DS", ds);

        startActivity(intent);
    }
}
