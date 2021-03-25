package ru.stqa.pft.adressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.adressbook.model.GroupData;


public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {
    app.getNavigationHelp().gotoGroupPage();
    app.getGroupHelp().initGroupCreation();
    app.getGroupHelp().fillGroupForm(new GroupData("test1", "test2", "test3"));
    app.getGroupHelp().submitGroupCreation();
    app.getGroupHelp().returnToGroupPage();
  }

}