package ru.stqa.pft.adressbook.model;

import java.util.Objects;

public class ContactData {
  private final String id;
  private final String firstname;
  private final String lastname;
  private final String email;
  private final String address2;
  private final String mobile;
  private final String address;
  private final String email2;
  private final String byear;

  public ContactData(String id, String firstname,String lastname, String email, String address2, String mobile, String address, String email2, String byear) {
    this.id = id;
    this.firstname = firstname;
    this.lastname = lastname;
    this.email = email;
    this.address2 = address2;
    this.mobile = mobile;
    this.address = address;
    this.email2 = email2;
    this.byear = byear;
  }
  public ContactData(String firstname,String lastname, String email, String address2, String mobile, String address, String email2, String byear) {
    this.id = null;
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

  public String getId() {
    return id;
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id='" + id + '\'' +
            ", firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return Objects.equals(id, that.id) && Objects.equals(firstname, that.firstname) && Objects.equals(lastname, that.lastname);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, firstname, lastname);
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
