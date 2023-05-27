package com.example.quanlykhachsan;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.net.Inet4Address;
import java.util.ArrayList;

public class Phong_Activity extends AppCompatActivity {
    ListView lvDsPhong;
    EditText txtId, txtNgayden, txtSongay;
    Button btnSua, btnXoa;

    ArrayList<Phong> phongArrayList;
    Provider provider;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_sach_phong);
        lvDsPhong = (ListView) findViewById(R.id.lvDSphong);
        txtId = (EditText) findViewById(R.id.txtIdPhong);
        txtNgayden = (EditText) findViewById(R.id.txtNgayDen);
        txtSongay = (EditText) findViewById(R.id.txtsongayo);
        btnSua = (Button) findViewById(R.id.btnSua);
        btnXoa = (Button) findViewById(R.id.btnXoa);
        phongArrayList =  new ArrayList<Phong>();
        provider = new Provider(this, "QLKS.sqlite", null, 1);
        Phong_Adapter da =  new Phong_Adapter(this,R.layout.item_phong,phongArrayList);

        Cursor c = provider.truyvanlaydulieu("SELECT * FROM HOADON");
        phongArrayList.clear();
        while (c.moveToNext()){
            String id = c.getString(0);
            String hoten = c.getString(1);
            Integer ngaydat = c.getInt(2);
            Integer ngayden = c.getInt(3);
            Integer songay = c.getInt(4);
            String loaiphong = c.getString(5);
            Float dongia = c.getFloat(6);
            Float tongtien = c.getFloat(7);
        }
        da.notifyDataSetChanged();
        lvDsPhong.setAdapter(da);
    }
}
