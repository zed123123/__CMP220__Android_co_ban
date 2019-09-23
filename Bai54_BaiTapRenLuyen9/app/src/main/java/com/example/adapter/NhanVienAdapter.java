package com.example.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bai54_baitaprenluyen9.R;
import com.example.model.NhanVien;

public class NhanVienAdapter extends ArrayAdapter<NhanVien> {

    Activity context;
    int resource;

    public NhanVienAdapter(Activity context, int resource) {
        super(context, resource);
        this.context = context;
        this.resource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View customView = this.context.getLayoutInflater().inflate(this.resource, null);


        ImageView imgHinh = customView.findViewById(R.id.imgHinh);
        TextView txtTen = customView.findViewById(R.id.txtTen);
        CheckBox chkXoa = customView.findViewById(R.id.chkXoa);

        final NhanVien nv = getItem(position);
        if(nv.isNu()){
            imgHinh.setImageResource(R.drawable.female);
        }
        else {
            imgHinh.setImageResource(R.drawable.male);

        }
        txtTen.setText(nv.getMa() + " - " + nv.getTen());

        chkXoa.setChecked(nv.isXoa());

        chkXoa.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                nv.setXoa(isChecked);
            }
        });

        return customView;
    }
}
