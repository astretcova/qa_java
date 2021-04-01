package ru.stqa.pft.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.GroupData;

public class GroupModificationTest extends TestBase{

    @Test
    public void testGroupModification() {
        app.getGroupNavigationHelper().gotoGroupPage();
        int before = app.getGroupHelp().getGroupCount();
        if (! app.getGroupHelp().isThereAGroup()){
            app.getGroupHelp().createGroup(new GroupData("test1", null, null));

        }
        app.getGroupHelp().selectGroup(before - 1);
        app.getGroupHelp().initGroupModification();
        app.getGroupHelp().fillGroupForm(new GroupData("test1", null, null));
        app.getGroupHelp().submitGroupModification();
        app.getGroupHelp().returnToGroupPage();
        int after = app.getGroupHelp().getGroupCount();
        Assert.assertEquals(after, before );
    }
}
