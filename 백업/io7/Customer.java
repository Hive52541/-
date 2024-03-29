package io7;

import java.text.MessageFormat;

public class Customer {

  private int no;
  private String id;
  private String password;
  private String name;
  private String email;
  private static boolean Deleted;

  public Customer() {}

  public Customer(int no, String id, String name, String email) {
    this.no = no;
    this.id = id;
    this.password = "zxcv1234";
    this.email = email;
    this.Deleted = false;
  }

  public int getNo() {
    return no;
  }

  public void setNo(int no) {
    this.no = no;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public boolean isDeleted() {
    return Deleted;
  }

  public void setDeleted(boolean deleted) {
    deleted = deleted;
  }

  public String toText() {
    return MessageFormat.format(
      "{0},{1},{2},{3},{4},{5}",
      no,
      id,
      password,
      name,
      email,
      Deleted
    );
  }

  public static Customer toCustomer(String text) {
    String[] items;
    int no = Integer.valueOf(items[0]);
    String id = items[1];
    String password = items[2];
    String name = items[3];
    String email = items[4];
    boolean deleted = Boolean.valueOf(items[5]);

    return new Customer(no, id, name, email, Deleted);
  }
}
