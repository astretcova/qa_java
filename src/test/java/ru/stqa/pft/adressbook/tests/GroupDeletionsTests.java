package ru.stqa.pft.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.adressbook.model.GroupData;


public class GroupDeletionsTests extends TestBase {

  @Test
  public void testGroupDeletions() throws Exception {
    app.getGroupNavigationHelper().gotoGroupPage();
    int before = app.getGroupHelp().getGroupCount();

    if (! app.getGroupHelp().isThereAGroup()){
      app.getGroupHelp().createGroup(new GroupData("test1", null, null));

    }
    app.getGroupHelp().selectGroup(before - 1);
    app.getGroupHelp().deleteSelectedGroup();
    app.getGroupHelp().returnToGroupPage();
    int after = app.getGroupHelp().getGroupCount();
    Assert.assertEquals(after, before - 1);
  }

}
