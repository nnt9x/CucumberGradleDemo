Feature: Thu nghiem dich vu chuyen va nap tien tai ABC Bank

  Scenario: nap tien vao tai khoan mac dinh
    Given khoi tao tai khoan NguyenVanA, co so tai khoan 12340001
    When kiem tra so du
    Then so du bang 50000 VND
    When nap 100000 VND vao tai khoan
    And kiem tra so du
    Then so du bang 150000 VND


  Scenario: chuyen tien tai khoan (phi 3000VND)
    Given khoi tao tai khoan NguyenVanA, co so tai khoan 12340001
    And tai khoan A co so du la 5000000 VND
    Given khoi tao tai khoan NguyenVanB, co so tai khoan 12340002
    And tai khoan B co so du la 3000000 VND
    When chuyen 350000 tu tk A sang tk B
    When kiem tra tai khoan A
    And kiem tra so du
    And so du bang 4647000 VND
    When kiem tra tai khoan B
    And kiem tra so du
    Then so du bang 3350000 VND

  Scenario: chuyen tien tai khoan (phi 20000VND)
    Given khoi tao tai khoan NguyenVanA, co so tai khoan 12340001
    And tai khoan A co so du la 50000000 VND
    Given khoi tao tai khoan NguyenVanB, co so tai khoan 12340002
    And tai khoan B co so du la 3000000 VND
    When chuyen 40000000 tu tk A sang tk B
    When kiem tra tai khoan A
    And kiem tra so du
    And so du bang 9980000 VND
    When kiem tra tai khoan B
    And kiem tra so du
    Then so du bang 43000000 VND

  Scenario: chuyen tien tai khoan (so du khong du)
    Given khoi tao tai khoan NguyenVanA, co so tai khoan 12340001
    And tai khoan A co so du la 1000000 VND
    Given khoi tao tai khoan NguyenVanB, co so tai khoan 12340002
    And tai khoan B co so du la 3000000 VND
    When chuyen 999000 tu tk A sang tk B
    Then thong bao So du khong du
