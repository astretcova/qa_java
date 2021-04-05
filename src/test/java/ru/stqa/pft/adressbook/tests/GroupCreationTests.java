package ru.stqa.pft.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.adressbook.model.GroupData;

import java.util.List;


public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {

    app.getGroupNavigationHelper().gotoGroupPage();
    List<GroupData> before = app.getGroupHelp().getGroupList();
    app.getGroupHelp().createGroup(new GroupData("test1", null, null));
    List<GroupData> after = app.getGroupHelp().getGroupList();
    Assert.assertEquals(after.size(), before.size() + 1);
  }

}