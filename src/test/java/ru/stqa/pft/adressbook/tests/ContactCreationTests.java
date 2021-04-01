package ru.stqa.pft.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

  @Test
  public void testCreationContact() throws Exception {
    app.getContactNavigationHelper().gotoHomeContact();
    int before = app.getContactHelper().getContactCount();
    app.getContactNavigationHelper().gotoNewContact();
    app.getContactHelper().fillContactForm(new ContactData("aaa", "bbb", "astrecova.marina@gmail.com", "ccc", "89110034406", "ddd", "mastretsova@rbc.ru", "1984"));
    app.getContactHelper().submitContact();
    app.getContactHelper().returnToContactPage();
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after, before + 1);
  }

}
