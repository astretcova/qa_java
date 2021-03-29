package ru.stqa.pft.adressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

  @Test
  public void testCreationAddressBook() throws Exception {
    app.getContactNavigationHelper().gotoNewContact();
    app.getContactHelper().fillContactForm(new ContactData("aaa", "bbb", "astrecova.marina@gmail.com", "ccc", "89110034406", "ddd", "mastretsova@rbc.ru", "1984"));
    app.getContactHelper().submitContact();
    app.getContactHelper().returnToContactPage();
  }

}
