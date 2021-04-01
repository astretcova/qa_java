package ru.stqa.pft.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.ContactData;
import ru.stqa.pft.adressbook.model.GroupData;

public class ContactModificationTest extends TestBase {

    @Test
    public void testGroupModification() {
        app.getContactNavigationHelper().gotoHomeContact();
        int before = app.getContactHelper().getContactCount();
        if (! app.getContactHelper().isThereAContact()){
            app.getContactHelper().createContact(new ContactData("aaa", "bbb", "astrecova.marina@gmail.com", "ccc", "89110034406", "ddd", "mastretsova@rbc.ru", "1984"));
        }
        app.getContactHelper().initContactModification(before-1);
        app.getContactHelper().fillContactForm(new ContactData("aaa", "www", "zzz", "aaa", "111", "eee", "wqw", "200"));
        app.getContactHelper().submitContactModification();
        app.getContactNavigationHelper().gotoHomeContact();
        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after, before);
    }
}
