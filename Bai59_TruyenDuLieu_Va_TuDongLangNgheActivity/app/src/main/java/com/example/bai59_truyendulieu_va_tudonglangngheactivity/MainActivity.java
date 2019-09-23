package com.example.bai59_truyendulieu_va_tudonglangngheactivity;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText edtN;
    Button btnLayUocSo;
    TextView txtKetQua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
    }

    private void addEvents() {
        btnLayUocSo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moManHinhXuLyUocSo();
            }
        });
    }

    private void moManHinhXuLyUocSo() {
        Intent intent = new Intent(MainActivity.this, XuLyUocSoActivity.class);
        intent.putExtra("N", Integer.parseInt(edtN.getText().toString()));
        startActivityForResult(intent, 113);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 113 && resultCode == 115){
            ArrayList<Integer> dsUS = data.getIntegerArrayListExtra("DSUS");
            txtKetQua.setText("");
            for (int us : dsUS){
                txtKetQua.append(us + "\n");
            }
        }
    }

    private void addControls() {
        edtN = findViewById(R.id.edtN);
        btnLayUocSo = findViewById(R.id.btnLayUocSo);
        txtKetQua = findViewById(R.id.txtKetQua);
    }
}
