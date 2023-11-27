package io2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.commons.io.IOUtils;

public class App4 {

  public static void main(String[] args) throws Exception {
    String src = "C://Users//jhta//eclipse-workspace//api//dskfj//src//io";
    String dest =
      "C://Users//jhta//eclipse-workspace//api//dskfj//src//io/KakaoTalk_20231122_142457324.mp4";
    // String src = "C:/Users/jhta/Downloads";
    // String dest = "C:/Users/jhta/Downloads/KakaoTalk_20231122_142457324.mp4";

    //apache-commons -io 라이브러리를 사용해서 읽고 쓰기
    FileInputStream in = new FileInputStream(src);
    FileOutputStream out = new FileOutputStream(dest);

    IOUtils.copy(in, out);
  }
}
