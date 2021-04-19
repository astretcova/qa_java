package ru.stqa.pft.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.ContactData;
import ru.stqa.pft.adressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactModificationTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goToPage().home();
        if (app.contact().all().size() == 0) {
            app.contact().createContact(new ContactData()
                    .withFirstname("111").withLastname("222").withMobile("333").withEmail("444").withEmail2("555")
                    .withAddress("66").withAddress2("777").withByear("888"));
        }
    }

    @Test
    public void testContactModification() {
        Contacts before = app.contact().all();
        ContactData modifiedContact = before.iterator().next();
        ContactData contact = new ContactData().withId(modifiedContact.getId()).withFirstname("100").withLastname("200")
                .withMobile("333").withEmail("444").withEmail2("555")
                .withAddress("123").withAddress2("777").withByear("888");
        app.contact().modify(contact);
        assertThat(app.contact().count(), equalTo(before.size()));
        Contacts after = app.contact().all();
        Assert.assertEquals(after.size(), before.size());
    }
}