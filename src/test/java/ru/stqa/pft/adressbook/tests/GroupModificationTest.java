package ru.stqa.pft.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.GroupData;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;

public class GroupModificationTest extends TestBase{

    @Test
    public void testGroupModification() {
        app.getGroupNavigationHelper().gotoGroupPage();
        if (! app.getGroupHelp().isThereAGroup()){
            app.getGroupHelp().createGroup(new GroupData("test1", null, null));

        }
        List<GroupData> before = app.getGroupHelp().getGroupList();
        app.getGroupHelp().selectGroup(before.size()-1);
        app.getGroupHelp().initGroupModification();
        GroupData group= new GroupData(before.get(before.size()-1).getId(),"test1", null, null);
        app.getGroupHelp().fillGroupForm(group);
        app.getGroupHelp().submitGroupModification();
        app.getGroupHelp().returnToGroupPage();
        List<GroupData> after = app.getGroupHelp().getGroupList();
        Assert.assertEquals(after.size(), before.size() );

        before.remove(before.size()-1);
        before.add(group);
        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
    }
}
