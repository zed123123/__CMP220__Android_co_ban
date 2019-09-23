package com.example.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class DanhBa implements Serializable {
    private String ten;
    private String phone;

    public DanhBa() {
    }

    public DanhBa(String ten, String phone) {
        this.ten = ten;
        this.phone = phone;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return ten + "\n" + phone;
    }

    public static ArrayList<DanhBa> duLieuMau(int n){

        ArrayList<DanhBa> ds = new ArrayList<>();
        Random random = new Random();

        for (int i = 1; i<=n; i++){
            DanhBa db = new DanhBa();
            db.setTen("Tên: " + i);
            String phone = "098";
            for (int p = 0; p<7; p++){
                phone += random.nextInt(10);
            }
            db.setPhone(phone);
        }
        return  ds;
    }
}
