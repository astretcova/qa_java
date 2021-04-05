package ru.stqa.pft.adressbook.model;

import java.util.Objects;

public class ContactData {
  private final String firstname;
  private final String lastname;
  private final String email;
  private final String address2;
  private final String mobile;
  private final String address;
  private final String email2;
  private final String byear;

  public ContactData(String firstname, String lastname, String email, String address2, String mobile, String address, String email2, String byear) {
    this.firstname = firstname;
    this.lastname = lastname;
    this.email = email;
    this.address2 = address2;
    this.mobile = mobile;
    this.address = address;
    this.email2 = email2;
    this.byear = byear;
  }

  public String getFirstname() {
    return firstname;
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "lastname='" + lastname + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return Objects.equals(firstname, that.firstname) && Objects.equals(lastname, that.lastname) && Objects.equals(email, that.email) && Objects.equals(mobile, that.mobile) && Objects.equals(address, that.address);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstname, lastname, email, mobile, address);
  }

  public String getLastname() {
    return lastname;
  }

  public String getEmail() {
    return email;
  }

  public String getAddress2() {
    return address2;
  }

  public String getMobile() {
    return mobile;
  }

  public String getAddress() {
    return address;
  }

  public String getEmail2() {
    return email2;
  }

  public String getByear() {
    return byear;
  }

}
