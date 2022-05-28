package com.bkacad.bank.steps;

import com.bkacad.bank.TaiKhoan;
import com.bkacad.bank.TaiKhoanBusiness;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class BankSteps {

    private TaiKhoan tk, tkA, tkB;
    private Exception exceptionActual;
    private final TaiKhoanBusiness taiKhoanBusiness = new TaiKhoanBusiness();
    private long soDuActual;

    @Given("^khoi tao tai khoan (\\w+), co so tai khoan (\\d+)$")
    public void khoiTaoTaiKhoan(String hoTen, String soTK) {
        tk = new TaiKhoan(hoTen, soTK);
    }

    @When("^kiem tra so du$")
    public void kiemTraSoDu() {
        soDuActual = tk.getSoDu();
    }

    @Then("^so du bang (\\d+) VND$")
    public void soDuBangVND(long soDuExpected) {
        Assertions.assertEquals(soDuExpected, soDuActual);
    }

    @When("^nap (\\d+) VND vao tai khoan$")
    public void napTienVaoTaiKhoan(long soTien) {
        taiKhoanBusiness.napTienTaiKhoan(tk, soTien);
    }

    @And("^tai khoan A co so du la (\\d+) VND$")
    public void taiKhoanACoSoDuLaVND(long soDu) {
        tkA = tk;
        tkA.setSoDu(soDu);
    }

    @And("^tai khoan B co so du la (\\d+) VND$")
    public void taiKhoanBCoSoDuLaVND(long soDu) {
        tkB = tk;
        tkB.setSoDu(soDu);
    }

    @When("^chuyen (\\d+) tu tk A sang tk B$")
    public void chuyenTuTkASangTkB(long soTien) {
        try {
            taiKhoanBusiness.chuyenTienDenSoTaiKhoan(tkA, tkB, soTien);
        } catch (Exception e) {
            exceptionActual = e;
        }
    }

    @When("^kiem tra tai khoan A$")
    public void kiemTraTaiKhoanA() {
        tk = tkA;
    }


    @When("^kiem tra tai khoan B$")
    public void kiemTraTaiKhoanB() {
        tk = tkB;
    }

    @Then("^thong bao ([\\w\\s]+)$")
    public void thongBaoSoDuKhongDu(String thongBao) {
        if (exceptionActual != null) {
            Assertions.assertEquals(thongBao, exceptionActual.getMessage());
        }
    }
}
