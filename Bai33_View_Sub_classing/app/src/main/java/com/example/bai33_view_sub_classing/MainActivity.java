package com.example.bai33_view_sub_classing;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void xyLyMoGioiThieu(View view) {
        LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT);
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setLayoutParams(params);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        TextView txtMessage = new TextView(this);
        txtMessage.setText("Hello World!");
        txtMessage.setLayoutParams(params);
        linearLayout.addView(txtMessage);

        Button btnBack = new android.support.v7.widget.AppCompatButton(this){
            @Override
            public boolean performClick() {
                setContentView(R.layout.activity_main);
                return super.performClick();
            }
        };
        btnBack.setText("Go back");
        btnBack.setLayoutParams(params);
        linearLayout.addView(btnBack);

        setContentView(linearLayout);
    }
}
