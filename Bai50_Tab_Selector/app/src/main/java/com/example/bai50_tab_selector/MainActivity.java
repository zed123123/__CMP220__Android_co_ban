package com.example.bai50_tab_selector;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TabHost;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TabHost tabHost;
    Button btnLogin, btnExit;
    EditText txtUsername, txtPwd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
    }

    private void addEvents() {
        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                if(tabId.equals("t1")){
                    Toast.makeText(MainActivity.this, "Bạn đang chọn tab Đăng nhập", Toast.LENGTH_SHORT).show();
                }
                else if(tabId.equals("t2")){
                    Toast.makeText(MainActivity.this, "Bạn đang chọn tab Hướng dẫn", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xyLyDangNhap();
            }
        });

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void xyLyDangNhap() {
        Toast.makeText(MainActivity.this, "Username: " + txtUsername.getText().toString() + "\nPassword: " + txtPwd.getText().toString(), Toast.LENGTH_SHORT).show();
    }


    private void addControls() {
        tabHost = findViewById(R.id.tabHost);
        tabHost.setup();

        TabHost.TabSpec tab1 = tabHost.newTabSpec("t1");
        tab1.setContent(R.id.tab1);
        tab1.setIndicator("", getResources().getDrawable(R.drawable.account));
        tabHost.addTab(tab1);


        TabHost.TabSpec tab2 = tabHost.newTabSpec("t2");
        tab2.setContent(R.id.tab2);
        tab2.setIndicator("Hướng dẫn");
        tabHost.addTab(tab2);

        txtUsername = findViewById(R.id.txtUsername);
        txtPwd = findViewById(R.id.txtPassword);
        btnLogin = findViewById(R.id.btnDangNhap);
        btnExit = findViewById(R.id.btnThoat);
    }
}
