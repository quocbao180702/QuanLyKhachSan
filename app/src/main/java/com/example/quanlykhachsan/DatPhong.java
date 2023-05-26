package com.example.quanlykhachsan;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class DatPhong extends AppCompatActivity {
    EditText txtTen,txtSDT,txtDiaChi,txtNgayO, txtTongTien;
    DatePicker txtNgayDat,txtNgayDen;
    RadioButton radDon,radDoi;
    Button btnDat;
    double phongdon = 150000;
    double phongdoi = 280000;
    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dat_phong);

        txtTen = (EditText) findViewById(R.id.txtTen);
        txtSDT = (EditText) findViewById (R.id.txtSdt);
        txtDiaChi = (EditText) findViewById(R.id.txtDiaChi);
        txtNgayO =(EditText) findViewById(R.id.txtNgayO);
        txtNgayDat = (DatePicker) findViewById(R.id.datNgayDat);
        txtNgayDen = (DatePicker) findViewById(R.id.datNgayDenO);
        txtTongTien = (EditText) findViewById(R.id.txtTong);
        radDon = (RadioButton) findViewById(R.id.radDon);
        radDoi = (RadioButton) findViewById(R.id.radDoi);
        btnDat = (Button) findViewById(R.id.btnDat);
        btnDat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Ten = txtTen.getText().toString().trim();
                String NgayO = txtNgayO.getText().toString().trim();
                if (Ten.isEmpty() || NgayO.isEmpty()) {
                    Toast.makeText(DatPhong.this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                    return;
                }
                int SoNgayO = Integer.parseInt(NgayO);

                int NgayDat = txtNgayDat.getDayOfMonth();
                int ThangDat = txtNgayDat.getMonth();
                int NamDat = txtNgayDat.getYear();

                int NgayDen = txtNgayDen.getDayOfMonth();
                int ThangDen = txtNgayDen.getMonth();
                int NamDen = txtNgayDen.getYear();

                if (NamDen < NamDat || (NamDen == NamDat && ThangDen < ThangDat)
                        || (NamDen == NamDat && ThangDen == ThangDat && NgayDen < NgayDat)) {
                    Toast.makeText(DatPhong.this, "Ngày đến không hợp lệ", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (SoNgayO < 1) {
                    Toast.makeText(DatPhong.this, "Số ngày ở không hợp lệ", Toast.LENGTH_SHORT).show();
                    return;
                }
                double TongTien = 0;

                if (radDon.isChecked()) {
                    TongTien = phongdon * SoNgayO;
                } else if (radDoi.isChecked()) {
                    TongTien = phongdoi * SoNgayO;
                }
                txtTongTien.setText("Tổng tiền phòng: "+ TongTien);
            }
        });
    }
}