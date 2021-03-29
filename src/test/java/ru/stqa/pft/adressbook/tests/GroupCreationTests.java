package ru.stqa.pft.adressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.adressbook.model.GroupData;


public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {
    app.getGroupNavigationHelper().gotoGroupPage();
    app.getGroupHelp().createGroup(new GroupData("test1", null, null));

  }

}