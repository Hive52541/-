package io1;

import java.io.FileOutputStream;

public class OutputStreamApp1 {

  public static void main(String[] args) throws Exception {
    FileOutputStream out = new FileOutputStream("src/io1/app3.txt");

    out.write(65);
    out.write(66);
    out.write(67);
    out.write(68);
    out.write(69);
    out.write(70);

    String str = "안녕하세요";

    /*
     * byte[] getbytes()
     * -문자열을 byte배열로 변환해서 반환한다
     * -문자열을 분석해서 각 문자를 utf-8
     */

    byte[] buf = str.getBytes();
    out.write(buf, 0, buf.length);

    out.close();
  }
}
