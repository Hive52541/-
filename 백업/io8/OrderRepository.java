package io8;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class OrderRepository {

  private List<Order> db = new ArrayList<Order>();

  /*
   * 지정된 회차의 주문내역을 로딩한다
   */
  public void load(int lottoNo) {
    try {
      String path = "src/io8" + getLottoNo() + ".csv";
      BufferedReader reader = new BufferedReader(new FileReader(path));
      String text = null;
      while ((text= reader.readLine()) != null) {
        db.add(Order.toOrder(text));
        
      }
      reader.close();
    } catch (FileNotFoundException ex) {
      throw new RuntimeException("파일을 찾을 수 없습니다.", ex);
      // TODO: handle exception
    } catch (IOException ex) {
      throw new RuntimeException(
        "파일을 읽어오는 중 오류가 발생하였습니다.",
        ex
      );
      // TODO: handle exception
    }
  }

  public void stored() {
    try {
      String path = "src/io8/" + getLottoNo() + ".csv";
      PrintWriter writer = new PrintWriter(path);
    } catch (FileNotFoundException ex) {
      throw new RuntimeException("파일을 찾을 수 없습니다.", ex);
    }
  }

  private int getLottoNo() {
    return null;
  }

  private void save(Order order) {
    db.add(order);
  }
}
