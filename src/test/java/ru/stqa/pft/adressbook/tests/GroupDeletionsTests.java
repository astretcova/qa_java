package ru.stqa.pft.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.adressbook.model.GroupData;

import java.util.List;


public class GroupDeletionsTests extends TestBase {
  @BeforeMethod
  public void ensurePreconditions() {
    app.getGroupNavigationHelper().gotoGroupPage();
    if (!app.getGroupHelp().isThereAGroup()) {
      app.getGroupHelp().createGroup(new GroupData("testik", null, null));
    }
  }

  @Test
  public void testGroupDeletions() throws Exception {
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

