package io7;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class CustomerService {

  private CustomerRepository repo = new CustomerRepository();

  public CustomerService() throws FileNotFoundException, IOException {
    repo.load();
  }

  /**
   * 모든 고객정보를 반환한다.
   * @return 고객 리스트
   */
  public List<Customer> getAllCustomers() {
    return repo.findAll();
  }

  /**
   * 신규고객 정보를 전달받아서 등록시킨다
   * 업무로직
   * -고객번호로 고객정보를 조회한다. 고객정보가 존재하면 예외를 발생시킨다
   * -고객아이디로 고객정보를 조회한다. 고객정보가 존재하면 예외를 발생시킨다
   * -고객정보가 존재하지 않으면 신규 고객정보를 등록시킨다.
   * @param customer 신규고객정보
   */

  public void addNewCustomer(Customer customer) {
    Customer savvedCustomer = repo.findByNo(customer.getNo());
    if (savvedCustomer != null) {
      throw new ShopException(
        "[" + customer.getNo() + "] 고객번호는 이미 사용중입니다."
      );
    }

    savvedCustomer = repo.findById(customer.getId());
    if (savvedCustomer != null) {
      throw new ShopException(
        "[" + customer.getId() + "] 아이디는 이미 사용중입니다."
      );
    }
    repo.save(customer);
  }

  /**
   * 지정된 번호의 고객정보를 반환한다.
   * @param no
   * @return
   */
  public Customer getCustomer(int no) {
    Customer customer = repo.findByNo(no);
    if (customer == null) {
      throw new ShopException(
        "[" + no + "] 지정된 고객번호에 해당하는 고객정보가 존재하지않습니다."
      );
    }
    return customer;
  }

  public void changePassword(int no, String password, String newPassword) {
    Customer customer = getCustomer(no);

    if (!customer.getPassword().equals(password)) {
      throw new ShopException("비밀번호가 일치하지 않습니다");
    }
    if (password.equals(newPassword)) {
      throw new ShopException(
        "이전 비밀번호와 같은 비밀번호로 지정할수없습니다."
      );
    }
    customer.setPassword(newPassword);

    repo.update(customer);
  }

  public void deleteCustomer(int no, String password) {
    Customer customer = getCustomer(no);

    if (!customer.getPassword().equals(password)) {
      throw new ShopException("비밀번호가 일치하지않습니다.")
      
    }
    repo.deleteByNo(no);
  }
}
