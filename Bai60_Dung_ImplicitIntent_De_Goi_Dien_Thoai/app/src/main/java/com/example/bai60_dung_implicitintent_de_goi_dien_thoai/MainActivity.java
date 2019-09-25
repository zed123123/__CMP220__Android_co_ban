package com.example.bai60_dung_implicitintent_de_goi_dien_thoai;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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

        btnSMS1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLySMS1();
            }
        });

        btnSMS2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLySMS2();
            }
        });
    }

    private void xuLySMS2() {
        SmsManager smsManager = SmsManager.getDefault();
        Intent msgIntent = new Intent("ACTION_MSG_SENT");
        PendingIntent pendingMsgSent = PendingIntent.getBroadcast(MainActivity.this, 0, msgIntent, 0);
        registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                int kq = getResultCode();
                if(kq == Activity.RESULT_OK){
                    Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                }
            }
        }, new IntentFilter("ACTION_MSG_SENT"));

        smsManager.sendTextMessage(edtSDT.getText().toString(),
                null,
                edtSMS.getText().toString(),
                pendingMsgSent,
                null);
    }

    private void xuLySMS1() {
        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(edtSDT.getText().toString(),
                null,
                edtSMS.getText().toString(),
                null,
                null);
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
