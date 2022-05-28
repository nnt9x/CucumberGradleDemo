Feature: Khach hang su dung dich vu va san pham

#  Phan loai khach hang thanh vien va khong la thanh vien

  Scenario Outline: khach hang la member
    Given khach hang <hoTen>
    And la thanh vien <loaiThanhVien>
    And ngay thanh toan la <ngayThanhToan>
    And co phi dich vu la <phiDichVu>
    And co phi san pham la <phiSanPham>
    When tinh tong tien phai tra
    Then so tien phai tra la <tongTien>

    Scenarios:
      | hoTen      | loaiThanhVien | ngayThanhToan | phiDichVu | phiSanPham | tongTien |
      | John       | GOLD          | 1/1/2022      | 500       | 400        | 785      |
      | Emily      | PREMIUM       | 10/10/2021    | 799       | 567.999    | 1150.399 |
      | Jessica    | PREMIUM       | 5/10/2021     | 799       | 0          | 639.2    |
      | Hiddleston | SLIVER        | 5/1/2021      | 789       | 199        | 889.2    |


  Scenario Template: khach hang khong la member
    Given khach hang <hoTen>
    And ngay thanh toan la <ngayThanhToan>
    And co phi dich vu la <phiDichVu>
    And co phi san pham la <phiSanPham>
    When tinh tong tien phai tra
    Then so tien phai tra la <tongTien>

    Examples:
      | hoTen | ngayThanhToan | phiDichVu | phiSanPham | tongTien |
      | Jame  | 10/10/2021    | 499.99    | 349.99     | 849.98   |
      | Brian | 7/1/2022      | 899.99    | 0          | 899.99   |
