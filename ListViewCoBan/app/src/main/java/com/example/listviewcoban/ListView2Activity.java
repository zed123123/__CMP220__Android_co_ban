package com.example.listviewcoban;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.model.DanhBa;

public class ListView2Activity extends AppCompatActivity {

    ListView lvData;
    ArrayAdapter<DanhBa> adapterData;

    EditText edtTen, edtSDT;

    int itemPosition = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view2);
        addControls();
        addEvent();
    }

    private void addEvent() {
        lvData.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                final DanhBa data = adapterData.getItem(position);

                AlertDialog.Builder builder = new AlertDialog.Builder(ListView2Activity.this);
                builder.setMessage("Bạn có muốn xóa:\n" + data.getTen() + "\n" + data.getPhone())
                        .setCancelable(true)
                        .setPositiveButton("Có", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                adapterData.remove(data);
                                edtTen.setText("");
                                edtSDT.setText("");
                                Toast.makeText(ListView2Activity.this, "Đã xóa dữ liệu: \n" + data.getTen() + "\n" +data.getPhone(), Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("Không xóa", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }

                        });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
                return false;
            }
        });

        lvData.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DanhBa data = adapterData.getItem(position);
                edtTen.setText(data.getTen());
                edtSDT.setText(data.getPhone());
                itemPosition = position;
            }
        });

    }

    private void addControls() {
        edtTen = findViewById(R.id.edtTen);
        edtSDT = findViewById(R.id.edtSDT);
        lvData = findViewById(R.id.lvData);
        adapterData = new ArrayAdapter<>(ListView2Activity.this, android.R.layout.simple_list_item_1);
        lvData.setAdapter(adapterData);
    }

    public void xuLyNhapDanhBa(View view) {
        String ten = edtTen.getText().toString();
        String sdt = edtSDT.getText().toString();
        DanhBa db = new DanhBa(ten, sdt);
        adapterData.add(db);
        edtTen.setText("");
        edtSDT.setText("");
    }


    public void xuLyCapNhatDanhBa(View view) {
        String ten = edtTen.getText().toString();
        String sdt = edtSDT.getText().toString();
        DanhBa data = adapterData.getItem(itemPosition);
        data.setTen(ten);
        data.setPhone(sdt);
        edtTen.setText("");
        edtSDT.setText("");
        adapterData.notifyDataSetChanged();
    }
}
