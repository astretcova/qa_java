package ru.stqa.pft.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTest extends TestBase {

    @Test
    public void testContactModification() {
        app.goToPage().home();
        if (app.contact().list().size() == 0) {
            app.contact().createContact(new ContactData()
                    .withFirstname("111").withLastname("222").withMobile("333").withEmail("444").withEmail2("555")
                    .withAddress("66").withAddress2("777").withByear("888"));
        }
        List<ContactData> before = app.contact().list();
        app.contact().editContactModification(before.size() - 1);
        int index = before.size() - 1;
        ContactData contact = new ContactData().withId(before.get(index).getId()).withFirstname("100").withLastname("200")
                .withMobile("333").withEmail("444").withEmail2("555")
                .withAddress("123").withAddress2("777").withByear("888");
        app.contact().fillContactForm(contact);
        app.contact().submitContactModification();
        app.goToPage().home();
        List<ContactData> after = app.contact().list();

        Assert.assertEquals(after.size(), before.size());

        before.remove(index);
        before.add(contact);

        Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }
}