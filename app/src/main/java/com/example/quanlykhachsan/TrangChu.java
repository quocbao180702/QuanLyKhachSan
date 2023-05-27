package com.example.quanlykhachsan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import android.os.Bundle;

public class TrangChu extends AppCompatActivity {

    Button tt,dp, ql;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trang_chu);
        tt  = (Button) findViewById(R.id.btnThonTin);
        dp = (Button) findViewById(R.id.btnDatPhong);
        ql = (Button) findViewById(R.id.btnQLPhong);
        int quyen = getIntent().getIntExtra("quyen", 0);
        if (quyen != 1) {
            ql.setVisibility(View.GONE);
        }
        tt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        dp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TrangChu.this, OrderRoom.class);
                startActivity(intent);
            }
        });
        ql.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TrangChu.this, Phong_Activity.class);
                startActivity(intent);
            }
        });
    }
}