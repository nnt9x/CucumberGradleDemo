package com.bkacad.bank;

public class TaiKhoan {
    private String maTaiKhoan;
    private String hoTen;
    private String ngaySinh;
    private int gioiTinh;
    private long soDu;

    public TaiKhoan() {
        this.soDu = 50000;
    }

    public TaiKhoan(String maTaiKhoan, String hoTen) {
        this.maTaiKhoan = maTaiKhoan;
        this.hoTen = hoTen;
        this.soDu = 50000;
    }

    public void setMaTaiKhoan(String maTaiKhoan) {
        this.maTaiKhoan = maTaiKhoan;
    }

    public String getMaTaiKhoan() {
        return maTaiKhoan;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public int getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(int gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public long getSoDu() {
        return soDu;
    }

    public void setSoDu(long soDu) {
        this.soDu = soDu;
    }

    public long kiemTraSoDu() {
        return soDu;
    }

    @Override
    public String toString() {
        return "TaiKhoan{" +
                "maTaiKhoan='" + maTaiKhoan + '\'' +
                ", hoTen='" + hoTen + '\'' +
                ", ngaySinh='" + ngaySinh + '\'' +
                ", gioiTinh=" + gioiTinh +
                ", soDu=" + soDu +
                '}';
    }
}
