package ru.stqa.pft.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.adressbook.model.GroupData;


public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {

    app.getGroupNavigationHelper().gotoGroupPage();
    int before = app.getGroupHelp().getGroupCount();
    app.getGroupHelp().createGroup(new GroupData("test1", null, null));
    int after = app.getGroupHelp().getGroupCount();
    Assert.assertEquals(after, before + 1);
  }

}