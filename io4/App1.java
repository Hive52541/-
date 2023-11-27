package io4;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import org.apache.commons.io.IOUtils;

public class App1 {

  public static void main(String[] args) throws Exception {

    /*
     * URL
     * -URL 객체는 지정된 URL 주소가 가리키는 자원을 표현하는 객체다
     * 
     * -URL 객체의 OpenStream() 메소드는 해당 자원과 연결된 읽기 스트림을 반환한다
     * 
     * -URL객체의 OpenStream() 메소드를 실행해서 획득한 InputStream을 활용하면 URL주소가 표현하는 자원을 읽어올수 있다.
     * 
     * 
     * 
     */
    URL url = new URL(
      "https://images.khan.co.kr/article/2023/05/04/news-p.v1.20230504.6238f947d5b5426a83ab5c81e1f88212_P1.jpg"
    );

    InputStream in = url.openStream();
    System.out.println(in);

    FileOutputStream out = new FileOutputStream("src/io4/Sample.jpg");

    IOUtils.copy(in, out);
  }
}
