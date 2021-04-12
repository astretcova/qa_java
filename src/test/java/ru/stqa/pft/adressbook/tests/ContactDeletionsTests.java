package ru.stqa.pft.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.ContactData;

import java.util.List;

public class ContactDeletionsTests extends TestBase {

    @Test
    public void testContactDeletions() throws Exception {

        app.goToPage().home();
        if (app.group().list().size() == 0) {
            app.contact().createContact(new ContactData()
                    .withFirstname("111").withLastname("222").withMobile("333").withEmail("444").withEmail2("555")
                    .withAddress("66").withAddress2("777").withByear("888"));
        }
        List<ContactData> before = app.contact().list();
        int index = before.size()-1;

        app.contact().delete(index);
        app.goToPage().home();
        List<ContactData> after = app.contact().list();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(index);
        Assert.assertEquals(before, after);
    }

}
