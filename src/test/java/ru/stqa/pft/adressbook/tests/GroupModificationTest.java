package ru.stqa.pft.adressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.GroupData;

public class GroupModificationTest extends TestBase{

    @Test
    public void testGroupModification() {
        app.getNavigationHelp().gotoGroupPage();
        app.getGroupHelp().selectGroup();
        app.getGroupHelp().initGroupModification();
        app.getGroupHelp().fillGroupForm(new GroupData("test1", "test2", "test3"));
        app.getGroupHelp().submitGroupModification();
        app.getGroupHelp().returnToGroupPage();
    }
}
