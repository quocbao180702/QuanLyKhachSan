package com.example.quanlykhachsan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Phong_Adapter extends ArrayAdapter<Phong> {
    private Context myContext;
    private int myResource;
    ArrayList<Phong> arrphong;

    public Phong_Adapter(@NonNull Context context, int resource, @NonNull ArrayList<Phong> objects) {
        super(context, resource, objects);
        this.myContext=context;
        this.myResource=resource;
        arrphong = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(myContext);
        convertView = inflater.inflate(myResource, parent, false);
        {
            TextView IdPhong = convertView.findViewById(R.id.idPhong);
            IdPhong.setText(getItem(position).getIdPhong());

            TextView hoten = convertView.findViewById(R.id.hoten);
            hoten.setText(getItem(position).getHoten());

            TextView ngaydat = convertView.findViewById(R.id.ngaydat);
            ngaydat.setText(getItem(position).getNgaydat());

            TextView ngayden = convertView.findViewById(R.id.ngayden);
            ngayden.setText(getItem(position).getNgayden());

            TextView songay = convertView.findViewById(R.id.songay);
            songay.setText(getItem(position).getNgayden());

            TextView loaiphong = convertView.findViewById(R.id.loai);
            loaiphong.setText(getItem(position).getLoaiphong());

            TextView dongia = convertView.findViewById(R.id.giatien);
            dongia.setText(getItem(position).getDongia() + "");

            TextView tongtien = convertView.findViewById(R.id.tongtien);
            tongtien.setText(getItem(position).getTongtien() + "");
        }
        return convertView;
    }
}
