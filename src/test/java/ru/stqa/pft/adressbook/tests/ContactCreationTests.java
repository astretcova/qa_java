package ru.stqa.pft.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;


public class ContactCreationTests extends TestBase {

    @Test
    public void testCreationContact() throws Exception {

        app.goToPage().home();
        Set<ContactData> before = app.contact().all();
        app.goToPage().newContact();
        ContactData contact = new ContactData()
                .withFirstname("11").withLastname("bbb").withMobile("111").withEmail("qqq").withEmail2("www")
                .withAddress("sss").withAddress2("ddd").withByear("123");
        app.contact().create(contact);
        Set<ContactData> after = app.contact().all();
        Assert.assertEquals(after.size(), before.size() + 1);

        contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt());
        before.add(contact);
        Assert.assertEquals(before, after);
    }

}


