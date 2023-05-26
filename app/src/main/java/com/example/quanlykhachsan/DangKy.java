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

    EditText matkhau, matkhau2, taikhoan, quyen;
    Button dangnhap, dangky;
    Provider provider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ky);

        matkhau = findViewById(R.id.txtMatKhau);
        matkhau2 = findViewById(R.id.txtMatKhau2);
        taikhoan = findViewById(R.id.txtTaiKhoan);
        quyen = findViewById(R.id.txtQuyen);

        dangnhap = findViewById(R.id.btnDangNhap);
        dangky = findViewById(R.id.btnDangKy);

        provider = new Provider(this, "QLKS.sqlite", null, 1);

        dangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mk = matkhau.getText().toString();
                String mk2 = matkhau2.getText().toString();
                String tk = taikhoan.getText().toString();
                String q = quyen.getText().toString();

                if (TextUtils.isEmpty(mk) || TextUtils.isEmpty(mk2) || TextUtils.isEmpty(tk) || TextUtils.isEmpty(q)) {
                    Toast.makeText(DangKy.this, "Vui lòng nhập đầy đủ thông tin đăng ký", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!mk.equals(mk2)) {
                    Toast.makeText(DangKy.this, "Mật khẩu không trùng nhau", Toast.LENGTH_SHORT).show();
                    return;
                }

                int quyenValue = Integer.parseInt(q);

                // Insert new user into the database
                provider.truyvankhonglayketqua("INSERT INTO NguoiDung (UserName, Pass, quyen) VALUES ('" + tk + "', '" + mk + "', " + quyenValue + ")");
                Toast.makeText(DangKy.this, "Đã tạo thành công tài khoản!", Toast.LENGTH_SHORT).show();

                // Clear input fields
                matkhau.setText("");
                matkhau2.setText("");
                taikhoan.setText("");
                quyen.setText("");

                // Redirect to the main activity
                Intent intent = new Intent(DangKy.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        dangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DangKy.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
