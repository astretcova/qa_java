package ru.stqa.pft.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.ContactData;
import ru.stqa.pft.adressbook.model.Contacts;
import ru.stqa.pft.adressbook.model.GroupData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDeletionsTests extends TestBase {

    @Test
    public void testContactDeletions() throws Exception {

        app.goToPage().home();
        if (app.contact().all().size() == 0) {
            app.contact().createContact(new ContactData()
                    .withFirstname("111").withLastname("222").withMobile("333").withEmail("444").withEmail2("555")
                    .withAddress("66").withAddress2("777").withByear("888"));
        }

        Contacts before = app.contact().all();
        ContactData deletedContact = before.iterator().next();
        app.contact().delete(deletedContact);

        app.goToPage().home();
        Contacts after = app.contact().all();
        Assert.assertEquals(after.size(), before.size() - 1);
        assertThat(after, equalTo(before.without(deletedContact)));
    }

}
