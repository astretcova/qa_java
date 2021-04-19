package ru.stqa.pft.adressbook.tests;

import com.google.common.base.Predicate;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.ContactData;

import static com.google.common.base.Predicates.equalTo;

public class ContactPhoneTest extends TestBase {

    @Test
    public void testContactPhones() {
        app.goToPage().home();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

        assertThat(contact.getHomeNumber(), equalTo(cleaned(contactInfoFromEditForm.getHomeNumber())));
        assertThat(contact.getMobileNumber() , equalTo(cleaned(contactInfoFromEditForm.getMobileNumber())));
        assertThat(contact.getWorkNumber(), equalTo(cleaned(contactInfoFromEditForm.getWorkNumber())));
    }

    private void assertThat(String homeNumber, Predicate<String> equalTo) {
    }

    public String cleaned (String phone) {
        return phone.replaceAll("\\s","").replaceAll("[-()]", "");
    }

}
