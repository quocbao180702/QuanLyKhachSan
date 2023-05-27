package com.example.quanlykhachsan;


import android.app.Dialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Phong_Activity extends AppCompatActivity {
    ListView lvDsPhong;
    ArrayList<Phong> phongArrayList;
    Phong_Adapter adapter;
    Provider provider;
    Button xoa, sua;
    EditText id_hd, ngayden, ngayo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_sach_phong);

        id_hd = findViewById(R.id.txtIdPhong);
        ngayden = findViewById(R.id.txtNgayDen);
        ngayo = findViewById(R.id.txtsongayo);
        xoa = findViewById(R.id.btnSua);
        sua = findViewById(R.id.btnXoa);

        lvDsPhong = findViewById(R.id.lvDSphong); // Initialize the ListView
        phongArrayList = new ArrayList<>();
        provider = new Provider(this, "QLKS.sqlite", null, 1);
        adapter = new Phong_Adapter(this, R.layout.item_phong, phongArrayList);
        lvDsPhong.setAdapter(adapter);
        loadPhongData();

        xoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
        sua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    private void loadPhongData() {
        Cursor cursor = provider.truyvanlaydulieu("SELECT * FROM HoaDon");
        phongArrayList.clear();
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            int id = cursor.getInt(0);
            String hoten = cursor.getString(1);
            int ngaydat = cursor.getInt(2);
            int ngayden = cursor.getInt(3);
            int songay = cursor.getInt(4);
            String loaiphong = cursor.getString(5);
            float dongia = cursor.getFloat(6);
            float tongtien = cursor.getFloat(7);

            phongArrayList.add(new Phong(id, hoten, ngaydat, ngayden, songay, loaiphong, dongia, tongtien));
            cursor.moveToNext();
        }
        cursor.close();

        if (phongArrayList.isEmpty()) {
            Toast.makeText(this, "Không có dữ liệu", Toast.LENGTH_SHORT).show();
        }
        adapter.notifyDataSetChanged();
    }
}

