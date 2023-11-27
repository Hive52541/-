package io3;

import java.io.BufferedReader;
import java.io.FileReader;

public class App1 {

  public static void main(String[] args) throws Exception {
    String path = "src/io3/data.csv";

    /*
     * BufferedReader
     * -�ٸ� Reader�� �����ؼ� �б� ������ ����Ű�� ��Ʈ���̴�.
     * -�ؽ�Ʈ�� �� �پ� �о���� readLine() �޼ҵ带 �����Ѵ�.
     * - �ֿ� �޼ҵ�
     *      String readLine()
     *          -�ؽ�Ʈ ������ �� �پ� �о���� ��Ʈ���̴�.
     *          -��Ʈ���� ���� ������ null�� ��ȯ�Ѵ�.
     *          -�ؽ�Ʈ�� �о�ö� �ٹٲ޹��� �ٷ� �ձ��� �о�´�.
     */

    BufferedReader reader = new BufferedReader(new FileReader(path));

    String text = null;
    while ((text = reader.readLine()) != null) {
      //System.out.println(text);

      //읽어온 문자열을 분석해서 평균점수를 계산하고 출력하는 수행문;

      //text에 대입된 문자열은 "홍길동,100,80,80"과 같은 형태다.
      //","를 구분자로 문자열을 잘라서 배열로 반환받는다.
      String[] items = text.split(",");
      //배열에 저장된 값을 조회하고, 필요한 경우 값을 변환한다.
      String name = items[0];
      int kor = Integer.parseInt(items[1]);
      int eng = Integer.parseInt(items[2]);
      int math = Integer.parseInt(items[3]);

      int total = kor + eng + math;
      int average = total / 3;

      System.out.println("�̸�: " + name);
      System.out.println("���: " + average);
      System.out.println();
    }
    reader.close();

    String text1 = reader.readLine();
    String text2 = reader.readLine();
    String text3 = reader.readLine();
    String text4 = reader.readLine();
    String text5 = reader.readLine();

    System.out.println(text1);
    System.out.println(text2);
    System.out.println(text3);
    System.out.println(text4);
    System.out.println(text5);

    reader.close();
  }
}
