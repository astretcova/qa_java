package ru.stqa.pft.adressbook.tests;

import org.testng.annotations.*;


public class GroupDeletionsTests extends TestBase {

  @Test
  public void testGroupDeletions() throws Exception {
    app.getGroupNavigationHelper().gotoGroupPage();
    app.getGroupHelp().selectGroup();
    app.getGroupHelp().deleteSelectedGroup();
    app.getGroupHelp().returnToGroupPage();  }

}
