package ru.stqa.pft.adressbook.tests;

import org.testng.annotations.*;


public class GroupDeletionsTests extends TestBase {

  @Test
  public void testGroupDeletions() throws Exception {
    app.gotoGroupPage();
    app.selectGroup();
    app.deleteSelectedGroup();
    app.returnToGroupPage();  }

}
