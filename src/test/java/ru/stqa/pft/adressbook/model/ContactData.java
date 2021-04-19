package ru.stqa.pft.adressbook.model;

import java.util.Objects;

public class ContactData {
  private int id= Integer.MAX_VALUE;;
  private  String firstname;
  private  String lastname;
  private  String email;
  private  String address2;
  private  String mobile;
  private  String address;
  private  String email2;
  private String home;
  private String work;


  public ContactData withId(int id) {
    this.id = id;
    return this;
  }
  public ContactData withFirstname(String firstname) {
    this.firstname = firstname;
    return this;
  }

  public ContactData withLastname(String lastname) {
    this.lastname = lastname;
    return this;
  }

  public ContactData withEmail(String email) {
    this.email = email;
    return this;
  }

  public ContactData withAddress2(String address2) {
    this.address2 = address2;
    return this;
  }


  public ContactData withMobile(String mobile) {
    this.mobile = mobile;
    return this;
  }

  public ContactData withAddress(String address) {
    this.address = address;
    return this;
  }

  public ContactData withEmail2(String email2) {
    this.email2 = email2;
    return this;
  }

  public ContactData withByear(String byear) {
    this.byear = byear;
    return this;
  }
  public ContactData withHomeNumber(String home) {
    this.home = home;
    return this;
  }

  public ContactData withMobileNumber(String mobile) {
    this.mobile = mobile;
    return this;
  }
  public ContactData withWorkNumber(String work) {
    this.work = work;
    return this;
  }



  private  String byear;


  public String getFirstname() {
    return firstname;
  }

  public int getId() {
    return id;
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


  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return id == that.id && Objects.equals(firstname, that.firstname) && Objects.equals(lastname, that.lastname);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, firstname, lastname);
  }


  @Override
  public String toString() {
    return "ContactData{" +
            "id='" + id + '\'' +
            ", firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            '}';
  }


  public String getHomeNumber() {
    return home;
  }

  public String getMobileNumber() {
    return mobile;
  }

  public String getWorkNumber() {
    return work;
  }
}
