package hw4;

public class ConactData {
  private final String firstname;
  private final String lastname;
  private final String email;
  private final String address2;
  private final String mobile;
  private final String address;
  private final String email2;
  private final String byear;

  public ConactData(String firstname, String lastname, String email, String address2, String mobile, String address, String email2, String byear) {
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
