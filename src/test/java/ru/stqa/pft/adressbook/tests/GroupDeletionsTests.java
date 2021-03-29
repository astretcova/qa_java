package ru.stqa.pft.adressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.adressbook.model.GroupData;


public class GroupDeletionsTests extends TestBase {

  @Test
  public void testGroupDeletions() throws Exception {
    app.getGroupNavigationHelper().gotoGroupPage();
    if (! app.getGroupHelp().isThereAGroup()){
      app.getGroupHelp().createGroup(new GroupData("test1", null, null));

    }
    app.getGroupHelp().selectGroup();
    app.getGroupHelp().deleteSelectedGroup();
    app.getGroupHelp().returnToGroupPage();  }

}
