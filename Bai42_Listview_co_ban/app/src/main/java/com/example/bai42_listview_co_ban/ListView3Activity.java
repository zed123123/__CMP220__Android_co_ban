package com.example.bai42_listview_co_ban;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.model.Contact;

public class ListView3Activity extends AppCompatActivity {

    EditText txtMa, txtTen, txtPhone;
    Button btnLuu;

    ListView lvContact;
    ArrayAdapter<Contact> contactAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view3);
        addControls();
        addEvents();
    }

    private void addEvents() {
        btnLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLyThemContact();
                txtMa.setText("");
                txtTen.setText("");
                txtPhone.setText("");
            }
        });

        lvContact.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Contact c = contactAdapter.getItem(position);
                contactAdapter.remove(c);
                txtMa.setText("");
                txtTen.setText("");
                txtPhone.setText("");
                return false;
            }
        });

        lvContact.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Contact c = contactAdapter.getItem(position);
                txtMa.setText(c.getId() + "");
                txtTen.setText(c.getName());
                txtPhone.setText(c.getPhone());
            }
        });
    }

    private void xuLyThemContact() {
        Contact c = new Contact();
        c.setId(Integer.parseInt(txtMa.getText().toString()));
        c.setName(txtTen.getText().toString());
        c.setPhone(txtPhone.getText().toString());
        contactAdapter.add(c);
    }

    private void addControls() {
        txtMa = findViewById(R.id.txtMa);
        txtTen = findViewById(R.id.txtTen);
        txtPhone = findViewById(R.id.txtPhone);
        btnLuu = findViewById(R.id.btnLuu);
        lvContact = findViewById(R.id.lvContact);
        contactAdapter = new ArrayAdapter<Contact>(ListView3Activity.this, android.R.layout.simple_list_item_1);
        lvContact.setAdapter(contactAdapter);
    }
}
