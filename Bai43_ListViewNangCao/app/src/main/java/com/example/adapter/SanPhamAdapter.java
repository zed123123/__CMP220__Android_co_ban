package com.example.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bai43_listviewnangcao.R;
import com.example.model.SanPham;

public class SanPhamAdapter  extends ArrayAdapter<SanPham> {

    Activity context;
    int resource;

    public SanPhamAdapter(Activity context, int resource) {
        super(context, resource);
        this.context = context;
        this.resource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = this.context.getLayoutInflater();
        View customView = inflater.inflate(this.resource, null);

        ImageView imgHinh = customView.findViewById(R.id.imgHinh);
        TextView txtTen = customView.findViewById(R.id.txtTen);
        TextView txtGia = customView.findViewById(R.id.txtGia);

        SanPham sp = getItem(position);
        imgHinh.setImageResource(sp.getHinh());
        txtTen.setText(sp.getTen());
        txtGia.setText(sp.getGia() + "VND");

        return customView;
    }
}
