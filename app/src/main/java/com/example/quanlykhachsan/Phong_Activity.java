package com.example.quanlykhachsan;


import android.app.Dialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_sach_phong);

        lvDsPhong = findViewById(R.id.lvDSphong); // Initialize the ListView
        phongArrayList = new ArrayList<>();
        provider = new Provider(this, "QLKS.sqlite", null, 1);
        adapter = new Phong_Adapter(this, R.layout.item_phong, phongArrayList);
        lvDsPhong.setAdapter(adapter);
        loadPhongData();

        lvDsPhong.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                int itemId = phongArrayList.get(i).getIdPhong();
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(Phong_Activity.this);
                alertDialog.setTitle("Question").setMessage("Bạn Có Muốn Xóa" + itemId);

                // Create "No" button with OnClickListener.
                alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Toast.makeText(Phong_Activity.this,"You choose No button",
                                Toast.LENGTH_SHORT).show();
                        //  Cancel
                        dialog.cancel();
                    }
                });
                alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(Phong_Activity.this,"Đã xóa hóa đơn",
                                Toast.LENGTH_SHORT).show();
                        //  Cancel
                        provider.truyvankhonglayketqua("DELETE FROM HoaDon WHERE id_dh = " + itemId);
                        loadPhongData();
                    }
                });

                // Create AlertDialog:
                AlertDialog alert = alertDialog.create();
                alert.show();
                return false;
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

