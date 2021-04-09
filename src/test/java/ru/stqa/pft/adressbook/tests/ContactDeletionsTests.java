package ru.stqa.pft.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.ContactData;

import java.util.List;

public class ContactDeletionsTests extends TestBase {

    @Test
    public void testContactDeletions() throws Exception {

        app.goToPage().home();
        if (! app.contact().isThereAContact()){
            app.contact().createContact(new ContactData("aaa", "bbb", "astrecova.marina@gmail.com", "ccc", "89110034406", "ddd", "mastretsova@rbc.ru", "1984"));
        }
        List<ContactData> before = app.contact().list();
        app.contact().selectContact(before.size()-1);
        app.contact().deleteSelectedContact();
        app.contact().alertAccept();
        app.goToPage().home();
        List<ContactData> after = app.contact().list();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(before.size() - 1);
        Assert.assertEquals(before, after);
    }

}
