package com.example.bai60_dung_implicitintent_de_goi_dien_thoai;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText edtSDT, edtSMS;
    Button btnSMS1, btnSMS2, btnDial, btnCall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();

        addEvents();
    }

    private void addEvents() {
        btnDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLyDial();
            }
        });

        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLyCall();
            }
        });
    }

    private void xuLyCall() {
        Intent intent = new Intent(Intent.ACTION_CALL);
        Uri uri = Uri.parse("tel:" + edtSDT.getText().toString());
        intent.setData(uri);
        startActivity(intent);
    }

    private void xuLyDial() {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        Uri uri = Uri.parse("tel:" + edtSDT.getText().toString());
        intent.setData(uri);
        startActivity(intent);
    }

    private void addControls() {
        edtSDT = findViewById(R.id.edtSDT);
        edtSMS = findViewById(R.id.edtSMS);

        btnSMS1 = findViewById(R.id.btnSMS1);
        btnSMS2 = findViewById(R.id.btnSMS2);
        btnDial = findViewById(R.id.btnDial);
        btnCall = findViewById(R.id.btnCall);
    }
}
