package example.hw4;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class CreationTest extends TestBase {

  @Test
  public void testCreation() throws Exception {

    goToGroupPage();
    initGroupCreation();
    fillGroup(new GroupData("test1", "test2", "test3"));
    wd.findElement(By.name("submit")).click();
    wd.findElement(By.linkText("group page")).click();
    wd.findElement(By.linkText("Logout")).click();
  }

}