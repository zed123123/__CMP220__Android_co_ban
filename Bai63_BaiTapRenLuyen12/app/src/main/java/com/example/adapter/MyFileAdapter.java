package com.example.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bai63_baitaprenluyen12.R;
import com.example.model.MyFile;

public class MyFileAdapter extends ArrayAdapter<MyFile> {

    Activity context;
    int resource;

    public MyFileAdapter(Activity context, int resource) {
        super(context, resource);

        this.context = context;
        this.resource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View customView = this.context.getLayoutInflater().inflate(this.resource, null);

        ImageView imgHinh = customView.findViewById(R.id.imgHinh);
        TextView txtTen = customView.findViewById(R.id.txtTen);
        TextView txtMoTa = customView.findViewById(R.id.txtMota);

        MyFile file = getItem(position);

        switch (file.getFileType()){
            case FOLDER:
                imgHinh.setImageResource(R.drawable.folder);
                break;
            case MP3:
                imgHinh.setImageResource(R.drawable.mp3);
                break;
            case MP4:
                imgHinh.setImageResource(R.drawable.mp4);
                break;
            case NOTSUPPORT:
                imgHinh.setImageResource(R.drawable.warning);
                break;
            default:
                imgHinh.setImageResource(R.drawable.warning);
                break;
        }

        txtMoTa.setText(file.getDesc());
        txtTen.setText(file.getDisplay());

        return customView;
    }
}
