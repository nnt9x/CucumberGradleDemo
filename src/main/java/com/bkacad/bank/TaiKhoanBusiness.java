package com.bkacad.bank;

public class TaiKhoanBusiness {
    public void napTienTaiKhoan(TaiKhoan taiKhoan, long soTien) {
        long soDu = taiKhoan.getSoDu() + soTien;
        taiKhoan.setSoDu(soDu);
    }

    public void chuyenTienDenSoTaiKhoan(TaiKhoan tkChuyen, TaiKhoan tkNhan, long soTien) {
        long phi = (long) (soTien * 0.001);
        if (phi < 3000) {
            phi = 3000;
        } else if (phi > 20000) {
            phi = 20000;
        }
        if (phi + soTien > tkChuyen.getSoDu()) {
            throw new RuntimeException("So du khong du");
        }
        tkChuyen.setSoDu(tkChuyen.getSoDu() - phi - soTien);
        tkNhan.setSoDu(tkNhan.getSoDu() + soTien);
    }
}
