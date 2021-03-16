package example.hw4;
import org.testng.annotations.*;

public class GroupDelitionsTests extends TestBase {


  @Test
  public void testGroupDelitions() throws Exception {
    goToGroupPage();
    selectGroup();
    deleteGroup();
    returnGroupPage();
  }

}
