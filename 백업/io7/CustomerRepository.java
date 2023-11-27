package io7;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.text.html.HTMLDocument.Iterator;

public class CustomerRepository {

  private List<Customer> db = new ArrayList<Customer>();

  //data.csv 파일을 읽어서 고객정보를 db에 저장시킨다
  public void load() {
    try {
      BufferedReader reader = new BufferedReader(
        new FileReader("src/io7/data.csv")
      );

      String text = null;
      while ((text = reader.readLine()) != null) {
        db.add(Customer.toCustomer(text));
        //text -> "10,kim,zxcv1234,김유신,kim@gmail.com,false"

        //text->{"10","kim","zxcv1234","김유신","kim@gmail.com","false"}

        // String[] items = text.split(",");

        // //배열에서 해당 위치를 값을 조회해서 적절한 타입으로 변환한다.
        // int no = Integer.valueOf(items[0]);
        // String id = items[1];
        // String password = items[2];
        // String name = items[3];
        // String email = items[4];
        // boolean deleted = Boolean.valueOf(items[5]);
        // //Customer객체를 생성해서 조회된 정보를 저장한다.
        // Customer customer = new Customer();
        // customer.setNo(no);
        // customer.setId(id);
        // customer.setPassword(password);
        // customer.setName(name);
        // customer.setEmail(email);
        // customer.setDeleted(deleted);
        // //Customer 객체를 List객체에 저장한다.
        // db.add(customer);

      }
      reader.close();
    } catch (FileNotFoundException ex) {
      throw new ShopException("파일을 찾을 수 없습니다.", ex);
    } catch (IOException ex) {
      throw new ShopException("파일을 읽기 중 오류가 발생하였습니다.", ex);
    }
  }

  //db의 고객정보를 data.csv 파일에 저장시킨다.
  public void store() {
    try {
      PrintWriter writer = new PrintWriter("src/io7/data.csv");

      for (Customer customer : db) {
        String text = customer.toText();
        writer.println(text);
      }
      writer.flush();
      writer.close();
    } catch (FileNotFoundException ex) {
      throw new ShopException("파일을 찾을 수 없습니다.", ex);
    }
  }

  //Method Signature
  public void save(Customer customer) {
    db.add(customer);
    stored();
  }

  private void stored() {}

  public List<Customer> findAll() {
    return db;
  }

  public Customer findByNo(int no) {
    for (Customer customer : db) {
      if (customer.getNo() == no) {
        return customer;
      }
    }
    return null;
  }

  public Customer findById(String id) {
    for (Customer customer : db) {
      if (customer.getId().equals(id)) {
        return customer;
      }
    }
    return null;
  }

  public void deleteByNo(int no) {
    Iterator<Customer> itr = db.iterator();
    while (itr.hasNext) {
      Customer customer = itr.next();
      if (customer.getNo() == no) {
        itr.remove();
        break;
      }
    }
    stored();
  }

  public void update() {
    stored();
  }
}
