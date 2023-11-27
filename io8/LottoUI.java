package io8;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class LottoUI {

  private LottoService service = new LottoService();
  private Scanner scanner = new Scanner(System.in);

  private void showMenu() {
    System.out.println(
      "----------------------------------------------------------------------------------------------"
    );
    System.out.println("1.구매 2. 당첨확인 0.종료");
    System.out.println(
      "----------------------------------------------------------------------------------------------"
    );
    System.out.println("### 메뉴선택: ");
    int menuNo = scanner.nextInt();
    System.out.println();

    switch (menuNo) {
      case 1:
        구매();
        break;
      case 2:
        당첨확인();
        break;
      case 3:
        추첨();
        break;
      case 0:
        종료();
        break;
    }
    System.out.println();
    System.out.println();
    System.out.println();

    showMenu();
  }

  private void 구매() {
    System.out.println("<< 구매하기 >>");

    System.out.println("### 구매금액을 입력하세요");
    System.out.println("## 구매금액 : ");
    int orderAmount = scanner.nextInt();

    Order order = service.buy(orderAmount);

    System.out.println(
      "----------------------------------------------------------------------------------------------"
    );
    System.out.println("구매내역");
    System.out.println(
      "----------------------------------------------------------------------------------------------"
    );
    System.out.println("회차번호: " + order.getLottoNo());
    System.out.println("주문번호: " + order.getOrderNo());
    System.out.println(
      "----------------------------------------------------------------------------------------------"
    );
    List<Set<Integer>> numberList = order.getNumbers();
    for (Set<Integer> set : numberList) {
      System.out.println(set);
    }
    System.out.println(
      "----------------------------------------------------------------------------------------------"
    );
  }

  private void 구매내역() {
    System.out.println("<<구매내역 확인>>");
    System.out.println("### 회차번호와 주문번호를 입력하세요");
    System.out.println("### 회차번호: ");
    int lottoNo = scanner.nextInt();
    System.out.println("### 주문번호: ");
    long orderNo = scanner.nextLong();

    Order order = service.getOrder();
  }

  private void 당첨확인() {

    System.out.println(
      "----------------------------------------------------------------------------------------------"
    );
    System.out.println("구매내역");
    System.out.println(
      "----------------------------------------------------------------------------------------------"
    );
    System.out.println("회차번호: " + order.getLottoNo());
    System.out.println("주문번호: " + order.getOrderNo());
    System.out.println(
      "----------------------------------------------------------------------------------------------"
    );
    List<Set<Integer>> numberList = order.getNumbers();
    for (Set<Integer> set : numberList) {
      System.out.println(set);
    }
    System.out.println(
      "----------------------------------------------------------------------------------------------"
    );
  }
  }

  private void 추첨() {}

  private void 종료() {}

  public static void main(String[] args) {
    LottoUI ui = new LottoUI();
    ui.showMenu();
  }
}
