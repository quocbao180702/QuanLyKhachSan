package com.example.quanlykhachsan;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class OrderRoom extends AppCompatActivity {

    EditText hoten, ngaydat, ngayden, songay;
    RadioButton phongthuong, phongdoi;
    Button dat;

    Provider provider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_room);

        hoten = (EditText) findViewById(R.id.txtHoTen);
        ngayden = (EditText) findViewById(R.id.txtNgayDen);
        ngaydat = (EditText) findViewById(R.id.txtNgayDat);
        songay = (EditText) findViewById(R.id.txtSoNgay);

        phongthuong = (RadioButton) findViewById(R.id.radThuong);
        phongdoi = (RadioButton) findViewById(R.id.radDoi);

        dat = (Button) findViewById(R.id.btnDat);
        Tao_data();

        dat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ht = hoten.getText().toString();
                Integer nden = Integer.parseInt(ngayden.getText().toString());
                Integer ndat = Integer.parseInt(ngaydat.getText().toString());
                Integer sn = Integer.parseInt(songay.getText().toString());
                String loaiphong;
                Float giaphong;

                if((nden > 30) || (nden<0) || (ndat > 30) || (ndat <0))
                {
                    Toast.makeText(OrderRoom.this, "Ngày nhỏ hơn 30", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(ndat > nden)
                {
                    Toast.makeText(OrderRoom.this, "Ngày đặt phải nhỏ hơn ngày đến", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(sn<1)
                {
                    Toast.makeText(OrderRoom.this, "Ngày ở phải lớn hơn 1", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (phongdoi.isChecked()) {
                    loaiphong = "Phòng Đôi";
                    giaphong = Float.parseFloat("280000");
                }
                else
                {
                    loaiphong = "Phòng Đơn";
                    giaphong = Float.parseFloat("150000");
                }
                Float tongtien = giaphong * sn;


                String ch = " " + ht + " + " + nden + " + " + ndat + " + " + sn + " + " + loaiphong + " + " + giaphong + " + " + tongtien;

                Dialog dialog = new Dialog(OrderRoom.this);
                dialog.setContentView(R.layout.dialog_xacnhan_custom);

                TextView hote = dialog.findViewById(R.id.txtHoTenHD);
                TextView ngade = dialog.findViewById(R.id.txtNgayDenHD);
                TextView ngada = dialog.findViewById(R.id.txtNgayDatHD);
                TextView songays = dialog.findViewById(R.id.txtSoNgayOHD);
                TextView lp = dialog.findViewById(R.id.txtLoaiPhongHD);
                TextView gia = dialog.findViewById(R.id.txtDonGiaHD);
                TextView tong = dialog.findViewById(R.id.txtTongTienHD);
                Button cancel = dialog.findViewById(R.id.btnHuy);
                Button submit = dialog.findViewById(R.id.btnDongY);

                hote.setText(ht);
                ngade.setText(String.valueOf(nden));
                ngada.setText(String.valueOf(ndat));
                songays.setText(String.valueOf(sn));
                lp.setText(loaiphong);
                gia.setText(String.valueOf(giaphong));
                tong.setText(String.valueOf(tongtien));


                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });


                submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        provider.truyvankhonglayketqua("INSERT INTO HoaDon (hotenkh, ngaydat, ngayden, songay, loaiphong, giaphong, tongtien) VALUES ('" + ht + "', " + ndat + ", " + nden + ", " + sn + ", '" + loaiphong + "', " + giaphong + ", " + tongtien + ")");
                        Toast.makeText(OrderRoom.this, "Thêm dữ liệu thành công" + ch, Toast.LENGTH_SHORT).show();
                        dialog.cancel();
                    }
                });
                dialog.show();

            }
        });
    }
    public void Tao_data()
    {
        provider = new Provider(this, "QLKS.sqlite", null, 1 );
        provider.truyvankhonglayketqua("CREATE TABLE IF NOT EXISTS HoaDon(id_dh INTEGER PRIMARY KEY AUTOINCREMENT, hotenkh VARCHAR(50),ngaydat INTEGER,ngayden INTEGER, songay INTEGER, loaiphong VARCHAR(50),GiaPhong FLOAT, TongTien FLOAT)");
        provider.truyvankhonglayketqua("INSERT INTO HoaDon (hotenkh, ngaydat, ngayden, songay, loaiphong, giaphong, tongtien) VALUES ('bao', 26, 27, 2, 'Phòng Đơn', 150000.0, 300000.0)");
    }
}