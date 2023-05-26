package com.example.quanlykhachsan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DangKy extends AppCompatActivity {

    EditText matkhau,matkhau2, taikhoan, quyen;
    Button dangnhap, dangky;
    Provider provider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ky);
        matkhau = (EditText) findViewById(R.id.txtTaiKhoan);
        matkhau2 = (EditText) findViewById(R.id.txtMatKhau2);
        taikhoan = (EditText) findViewById(R.id.txtMatKhau);
        quyen = (EditText)  findViewById(R.id.txtQuyen);

        dangnhap  = (Button)  findViewById(R.id.btnDangNhap);
        dangky = (Button) findViewById(R.id.btnDangKy);
        provider = new Provider(this, "QLKS.sqlite", null, 1 );
        dangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mk = matkhau.getText().toString();
                String mk2 = matkhau2.getText().toString();
                String tk = taikhoan.getText().toString();
                String q = quyen.getText().toString();
                if(TextUtils.isEmpty(mk) || TextUtils.isEmpty(mk2) || TextUtils.isEmpty(q) || TextUtils.isEmpty(tk))
                {
                    Toast.makeText(DangKy.this, "Vui lòng nhập đầy đủ thông tin đăng ký", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!mk.equals(mk2))
                {
                    Integer quyens  = Integer.parseInt(quyen.getText().toString());
                    provider.truyvankhonglayketqua("INSERT INTO NguoiDung VALUES (null,'"+ tk + "','"+mk+"','" +quyens + "')");
                    Toast.makeText(DangKy.this, "Đã Tọa Thành Công Tài Khoản! ", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(DangKy.this, MainActivity.class);
                    startActivity(intent);
                    return;
                }
                Toast.makeText(DangKy.this, "Nhập lại mật khẩu không đúng", Toast.LENGTH_SHORT).show();
            }
        });

        dangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DangKy.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}