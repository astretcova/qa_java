package ru.stqa.pft.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {

    @Test
    public void testCreationContact() throws Exception {
        app.getContactNavigationHelper().gotoHomeContact();
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactNavigationHelper().gotoNewContact();
        ContactData contact = new ContactData("aaa", "bbb", null, null, null, null, null, null);
        app.getContactHelper().fillContactForm(contact);
        app.getContactHelper().submitContact();
        app.getContactHelper().returnToContactPage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() + 1);

        before.add(contact);
        Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }
}


