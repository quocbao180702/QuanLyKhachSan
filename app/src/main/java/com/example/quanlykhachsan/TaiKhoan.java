package com.example.quanlykhachsan;

public class TaiKhoan {


    private String username;
    private String pass;

    public Integer getQuyen() {
        return quyen;
    }

    private Integer quyen;

    public TaiKhoan() {
    }

    public TaiKhoan(String username, String pass, Integer quyen) {
        this.username = username;
        this.pass = pass;
        this.quyen = quyen;
    }

    public String getUsername() {
        return username;
    }


    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setQuyen(Integer quyen) {
        this.quyen = quyen;
    }


}
