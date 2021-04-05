package ru.stqa.pft.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.adressbook.model.GroupData;

import java.util.List;


public class GroupDeletionsTests extends TestBase {

  @Test
  public void testGroupDeletions() throws Exception {
    app.getGroupNavigationHelper().gotoGroupPage();
    if (! app.getGroupHelp().isThereAGroup()){
      app.getGroupHelp().createGroup(new GroupData("test1", null, null));

    }
    List<GroupData> before = app.getGroupHelp().getGroupList();
    app.getGroupHelp().selectGroup(before.size() - 1);
    app.getGroupHelp().deleteSelectedGroup();
    app.getGroupHelp().returnToGroupPage();
    List<GroupData> after = app.getGroupHelp().getGroupList();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(before.size() - 1);
      Assert.assertEquals(before, after);
    }
  }

