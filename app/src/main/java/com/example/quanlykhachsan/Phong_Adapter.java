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
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View v = convertView;
        v = inflater.inflate(R.layout.item_phong, null);
        convertView = inflater.inflate(myResource, parent, false);
        {
            TextView IdPhong = v.findViewById(R.id.idPhong);
            IdPhong.setText(String.valueOf(arrphong.get(position).getIdPhong()));

            TextView hoten = v.findViewById(R.id.hoten);
            hoten.setText(arrphong.get(position).getHoten());

            TextView ngaydat = v.findViewById(R.id.ngaydat);
            ngaydat.setText(String.valueOf(arrphong.get(position).getNgaydat()));

            TextView ngayden = v.findViewById(R.id.ngayden);
            ngayden.setText(String.valueOf(arrphong.get(position).getNgayden()));

            TextView songay = v.findViewById(R.id.songay);
            songay.setText(String.valueOf(arrphong.get(position).getNgayden()));

            TextView loaiphong = v.findViewById(R.id.loai);
            loaiphong.setText(arrphong.get(position).getLoaiphong());

            TextView dongia = v.findViewById(R.id.giatien);
            dongia.setText(String.valueOf(arrphong.get(position).getDongia()));

            TextView tongtien = v.findViewById(R.id.tongtien);
            tongtien.setText(String.valueOf(arrphong.get(position).getTongtien()));
        }
        return v;
    }
}
