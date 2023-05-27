package com.example.quanlykhachsan;

public class Phong {

    private int IdPhong;
    private String hoten;
    private int ngayden;
    private int ngaydat;
    private int songay;
    private String loaiphong;
    private float dongia;
    private float tongtien;

    public Phong(int idPhong, String hoten, int ngayden, int ngaydat, int songay, String loaiphong, float dongia, float tongtien) {
        IdPhong = idPhong;
        this.hoten = hoten;
        this.ngayden = ngayden;
        this.ngaydat = ngaydat;
        this.songay = songay;
        this.loaiphong = loaiphong;
        this.dongia = dongia;
        this.tongtien = tongtien;
    }


    public int getIdPhong() {
        return IdPhong;
    }

    public void setIdPhong(int idPhong) {
        IdPhong = idPhong;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public int getNgayden() {
        return ngayden;
    }

    public void setNgayden(int ngayden) {
        this.ngayden = ngayden;
    }

    public int getNgaydat() {
        return ngaydat;
    }

    public void setNgaydat(int ngaydat) {
        this.ngaydat = ngaydat;
    }

    public int getSongay() {
        return songay;
    }

    public void setSongay(int songay) {
        this.songay = songay;
    }

    public String getLoaiphong() {
        return loaiphong;
    }

    public void setLoaiphong(String loaiphong) {
        this.loaiphong = loaiphong;
    }

    public float getDongia() {
        return dongia;
    }

    public void setDongia(float dongia) {
        this.dongia = dongia;
    }

    public float getTongtien() {
        return tongtien;
    }

    public void setTongtien(float tongtien) {
        this.tongtien = tongtien;
    }

}
