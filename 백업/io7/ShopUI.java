package io7;

import java.util.List;
import java.util.Scanner;

public class ShopUI {

  //CustomerService 객체, Scanner 객체에 의존하기 때문에
  //해당객체와 연결할 멤버변수를 정의한다.

  private CustomerService service;
  private Scanner scanner;

  //ShopUI의 생성자 메소드에서 객체 생성하자마자.
  //CustomerService객체, Scanner객체를 생성해서 각각의 멤버변수에 대입한다.

  public ShopUI() {
    service = new CustomerService();
    scanner = new Scanner(System.in);
  }

  public void showMenu() {
    System.out.println(
      "---------------------------------------------------------------------------------"
    );
    System.out.println("1.전체조회 2.상세조회 3.등록 4.수정 5.삭제 0.종료");
    System.out.println(
      "---------------------------------------------------------------------------------"
    );

    System.out.println("###메뉴선택: ");
    int menuNo = scanner.nextInt();

    try {
      switch (menuNo) {
        case 1:
          전체조회();
          break;
        case 2:
          상세조회();
          break;
        case 3:
          등록();
          break;
        case 4:
          수정();
          break;
        case 5:
          삭제();
          break;
        case 0:
          종료();
          break;
      }
    } catch (ShopException ex) {
      System.out.println("###오류: " + ex.getMessage());
    } catch (Exception ex) {
      System.out.println("###오류: " + ex.getMessage());
    }

    System.out.println();
    System.out.println();
    System.out.println();

    showMenu();
  }

  private void 전체조회() {
    System.out.println("<< 전체 조회 >>");

    List<Customer> customers = service.getAllCustomers();

    if (customers.isEmpty()) {
      System.out.println("### 등록된 고객이 없습니다.");
      return;
    }
    System.out.println(
      "---------------------------------------------------------------------"
    );
    System.out.println("고객번호\t아이디\t고객명");
    System.out.println(
      "---------------------------------------------------------------------"
    );
    for (Customer customer : customers) {
      System.out.print(customer.getNo() + "\t");
      System.out.print(customer.getId() + "\t");
      System.out.println(customer.getName());
    }
    System.out.println(
      "---------------------------------------------------------------------"
    );
  }

  private void 상세조회() {
    System.out.println("<<상세 조회>>");

    System.out.println("###조회할 고객의 번호를 입력하세요");
    System.out.print("###고객번호");
    int no = scanner.nextInt();

    Customer customer = service.getCustomer(no);

    System.out.println("---------------------------------------------");
    System.out.println("고객번호: " + customer.getNo());
    System.out.println("고객 아이디: " + customer.getId());
    System.out.println("고객이름: " + customer.getName());
    System.out.println("고객이메일" + customer.getEmail());
    System.out.println("탈퇴여부: " + customer.isDeleted());
    System.out.println("");
    System.out.println("");
    System.out.println("---------------------------------------------");
  }

  private void 등록() {
    System.out.println("<< 신규 고객 등록>>");
    System.out.println("### 고객 번호, 아이디, 이름, 이메일을 입력하세요");
    System.out.print("### 고객번호: ");
    int no = scanner.nextInt();
    System.out.print("### 아이디: ");
    String id = scanner.nextString();
    System.out.print("### 이름: ");
    String name = scanner.nextString();
    System.out.print("### 이메일: ");
    String email = scanner.nextString();

    Customer customer = new Customer(no, id, name, email);
    service.addNewCustomer(customer);
  }

  private void 수정() {
    System.out.println("<<고객 정보 수정>>");

    System.out.println(
      "### 고객번호, 비밀번호를 입력해서 고객비밀번호를 변경하세요. "
    );
    System.out.println("### 고객번호:");
    int no = scanner.nextInt();
    System.out.println("### 현재비밀번호: ");
    String password = scanner.nextString();
    System.out.println("### 새비밀번호:");
    String newPassword = scanner.nextString();

    service.changePassword(no, password, newPassword);

    System.out.println("### 비밀번호 변경이 완료되었습니다");
  }

  private void 삭제() {
    System.out.println("<<고객 삭제>>");

    System.out.println("### 고객번호와 비밀번호를 입력하고 삭제하세요.");
    System.out.print("###고객번호:");
    int no = scanner.nextInt();
    System.out.print("###비밀번호:");
    String password = scanner.nextString();

    service.deleteCustomer(no, password);
    System.out.println("### 고객정보가 삭제되었습니다");
  }

  private void 종료() {}
}
