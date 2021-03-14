package hw4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CreationAddressBook {
  private WebDriver driver;


  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    login("admin", "secret");
  }

  private void login(String user, String pass) {
    driver = new FirefoxDriver();
    driver.get("http://localhost/addressbook/group.php");
    driver.findElement(By.name("user")).click();
    driver.findElement(By.name("user")).clear();
    driver.findElement(By.name("user")).sendKeys(user);
    driver.findElement(By.name("pass")).click();
    driver.findElement(By.name("pass")).clear();
    driver.findElement(By.name("pass")).sendKeys(pass);
    driver.findElement(By.xpath("//input[@value='Login']")).click();
  }

  @Test
  public void testCreationAddressBook() throws Exception {

    goToNewGroup();
    fillGroupCreation(new ConactData("Марина", "Астрецова", "astrecova.marina@gmail.com", "санкт-петербург", "89110034406", "ул Федора Абрамова д.8", "mastretsova@rbc.ru", "1984"));
    submitGroup();
    returnToPage();
  }

  private void returnToPage() {
    driver.findElement(By.linkText("Logout")).click();
  }

  private void submitGroup() {
    driver.findElement(By.name("theform")).click();
    driver.findElement(By.xpath("(//input[@name='submit'])[2]")).click();
    driver.findElement(By.linkText("home page")).click();
  }

  private void fillGroupCreation(ConactData conactData) {
    driver.findElement(By.name("firstname")).click();
    driver.findElement(By.name("firstname")).clear();
    driver.findElement(By.name("firstname")).sendKeys(conactData.getFirstname());
    driver.findElement(By.name("lastname")).clear();
    driver.findElement(By.name("lastname")).sendKeys(conactData.getLastname());
    driver.findElement(By.name("address")).clear();
    driver.findElement(By.name("address")).sendKeys(conactData.getAddress());
    driver.findElement(By.name("email")).clear();
    driver.findElement(By.name("email")).sendKeys(conactData.getEmail());

    driver.findElement(By.name("address2")).clear();
    driver.findElement(By.name("address2")).sendKeys(conactData.getAddress2());

    driver.findElement(By.name("mobile")).click();
    driver.findElement(By.name("mobile")).clear();
    driver.findElement(By.name("mobile")).sendKeys(conactData.getMobile());
    driver.findElement(By.name("email2")).click();
    driver.findElement(By.name("email2")).clear();
    driver.findElement(By.name("email2")).sendKeys(conactData.getEmail2());
    driver.findElement(By.name("bday")).click();
    driver.findElement(By.name("bday")).click();
    driver.findElement(By.name("bmonth")).click();
    driver.findElement(By.name("bmonth")).click();
    driver.findElement(By.name("byear")).click();
    driver.findElement(By.name("byear")).clear();
    driver.findElement(By.name("byear")).sendKeys(conactData.getByear());
  }

  private void goToNewGroup() {
    driver.findElement(By.linkText("add new")).click();
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
  }
}
