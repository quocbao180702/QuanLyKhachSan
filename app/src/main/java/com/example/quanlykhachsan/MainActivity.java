package com.example.quanlykhachsan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Iterator;

public class MainActivity extends AppCompatActivity {

    Button dangnhap, dangky;
    EditText user, pass;

    Provider provider;
    ArrayList<TaiKhoan> taikhoan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user = (EditText) findViewById(R.id.txtTaiKhoan);
        pass =(EditText) findViewById(R.id.txtMatKhau);
        dangnhap = (Button) findViewById(R.id.btnDangNhap);
        dangky = (Button) findViewById(R.id.btnDangKy);

        Tao_data();

        taikhoan = new ArrayList<>();
        taikhoan.clear();

        Cursor data = provider.truyvanlaydulieu("Select * from NguoiDung");
        while (data.moveToNext())
        {
            String username= data.getString(1);
            String pass = data.getString(2);
            Integer quyen = data.getInt(3);
            taikhoan.add(new TaiKhoan(username,pass,quyen));
        }


        dangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usern,passw;
                Integer quyen;
                usern = user.getText().toString();
                passw = pass.getText().toString();
                if(TextUtils.isEmpty(usern))
                {
                    Toast.makeText(MainActivity.this,"Vui lòng nhập tài khoản",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(passw))
                {
                    Toast.makeText(MainActivity.this, "Vui lòng nhập mật khẩu", Toast.LENGTH_SHORT).show();
                    return;
                }

                Iterator<TaiKhoan> iterator = taikhoan.iterator();
                while (iterator.hasNext())
                {
                    TaiKhoan tk = iterator.next();
                    if(usern.equals(tk.getUsername()) && passw.equals(tk.getPass())) //kiểm tra coi 2 thằng tài khoản có giống nhau
                    {
                        Toast.makeText(MainActivity.this, "Xin Chào Bạn", Toast.LENGTH_SHORT).show();
                        Intent intent= new Intent(MainActivity.this, DatPhong.class);
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(MainActivity.this, "đăng nhập không thành công", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        dangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this, DangKy.class);
                    startActivity(intent);
            }
        });
    }
    public void Tao_data()
    {
        provider = new Provider(this, "QLKS.sqlite", null, 1 );
        provider.truyvankhonglayketqua("CREATE TABLE IF NOT EXISTS NguoiDung(id_user INTEGER PRIMARY KEY AUTOINCREMENT, UserName VARCHAR(50) ,  Pass Varchar(50), quyen INTEGER)");
        provider.truyvankhonglayketqua("INSERT INTO NguoiDung VALUES (null,'dqbao','abc123','1')");
    }

}