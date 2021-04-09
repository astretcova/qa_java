package ru.stqa.pft.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTest extends TestBase {

    @Test
    public void testContactModification() {
        app.getContactNavigationHelper().gotoHomeContact();
        if (! app.contact().isThereAContact()){
            app.contact().createContact(new ContactData("aaa", "bbb", "astrecova.marina@gmail.com", "ccc", "89110034406", "ddd", "mastretsova@rbc.ru", "1984"));
        }
        List<ContactData> before = app.contact().list();
        app.contact().selectContact(before.size()-1);
        app.contact().editContactModification();

        ContactData contact = new ContactData(before.get(before.size()-1).getId(), "333", "333", null, null, null, null, null, null);
        app.contact().fillContactForm(contact);
        app.contact().submitContactModification();
        app.getContactNavigationHelper().gotoHomeContact();
        List<ContactData> after = app.contact().list();

        Assert.assertEquals(after.size(), before.size());

        Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(),c2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }
}