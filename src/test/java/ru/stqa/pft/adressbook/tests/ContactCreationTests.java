package ru.stqa.pft.adressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.ContactData;
import ru.stqa.pft.adressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ContactCreationTests extends TestBase {

    @Test
    public void testCreationContact() throws Exception {

        app.goToPage().home();
        Contacts before = app.contact().all();
        app.goToPage().newContact();
        ContactData contact = new ContactData()
                .withFirstname("11").withLastname("bbb").withMobile("111").withEmail("qqq").withEmail2("www")
                .withAddress("sss").withAddress2("ddd").withByear("123");
        app.contact().create(contact);
        Contacts after = app.contact().all();
        assertThat(after.size(), equalTo(before.size() + 1));
        assertThat(after, equalTo(
                before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
    }

}


