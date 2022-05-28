package com.bkacad.cucumber.steps;

import com.bkacad.cucumber.Customer;
import com.bkacad.cucumber.Visit;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class BussinessSteps {
    private Customer customer;
    private Visit visit;
    private double actual;

    @Given("^khach hang (\\w+)$")
    public void khachHang(String name) {
        customer = new Customer(name);
    }

    @And("^la thanh vien ([A-Z]+)$")
    public void laThanhVien(String type) {
        customer.setMember(true);
        customer.setMemberType(type);
    }


    @And("^ngay thanh toan la (.+)$")
    public void ngayThanhToanLa(String date) throws ParseException {
        System.out.println(date);
        Date d = new SimpleDateFormat("dd/MM/yyyy").parse(date);
        visit = new Visit(customer, d);
    }

    @And("^co phi dich vu la ([0-9\\.]+)$")
    public void coPhiDichVuLa(double phiDichVu) {
        visit.setServiceExpense(phiDichVu);
    }

    @And("^co phi san pham la ([0-9\\.]+)$")
    public void coPhiSanPhamLa(double phiSanPham) {
        visit.setProductExpense(phiSanPham);
    }

    @When("^tinh tong tien phai tra$")
    public void tinhTongTienPhaiTra() {
        actual = visit.getTotalExpense();
    }

    @Then("so tien phai tra la {double}")
    public void soTienPhaiTraLa(double expected) {
        Assertions.assertTrue(Math.abs(expected - actual) < 0.001);
    }
}
