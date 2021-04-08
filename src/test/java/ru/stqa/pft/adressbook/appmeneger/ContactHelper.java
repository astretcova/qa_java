package ru.stqa.pft.adressbook.appmeneger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.adressbook.model.ContactData;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void fillContactForm(ContactData contactData) {
        type(By.name("firstname"), contactData.getFirstname());
        type(By.name("lastname"), contactData.getLastname());
        type(By.name("address"), contactData.getAddress());
        type(By.name("email"), contactData.getEmail());
        type(By.name("address2"), contactData.getAddress2());
        type(By.name("mobile"), contactData.getMobile());
        type(By.name("email2"), contactData.getEmail2());
        type(By.name("byear"), contactData.getByear());
    }

    public void submitContact() {
        click(By.xpath("(//input[@name='submit'])[2]"));
    }

    public void returnToContactPage() {
        click(By.linkText("home page"));
    }

    public void selectContact(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
    }

    public void deleteSelectedContact() {
        click(By.xpath("//input[@value='Delete']"));
    }

    public void alertAccept() {
        wd.switchTo().alert().accept();
    }

    public void editContactModification() {
        click(By.xpath("(//img[@alt='Edit'])"));
        // wd.findElements(By.xpath("(//img[@alt='Edit'])")).get(index).click();
    }

    public void submitContactModification() {
        click(By.name("update"));
    }

    public void createContact(ContactData contact) {
        gotoNewContact();
        fillContactForm(contact);
        submitContact();
        returnToContactPage();

    }

    private void gotoNewContact() {
        click(By.linkText("add new"));
    }

    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));
    }

    public int getContactCount() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public List<ContactData> getContactList() {
        List<ContactData> contacts = new ArrayList<>();
        List<WebElement> elements = wd.findElements(By.tagName("tr"));
        elements.remove(0);
        for (WebElement element : elements) {
            List<WebElement> rowColumns = element.findElements(By.tagName("td"));
            String lastName = rowColumns.get(1).getText();
            String firstName = rowColumns.get(2).getText();
            //String id = element.findElement(By.tagName("input")).getAttribute("value");
            ContactData contact = new ContactData(firstName, lastName, null, null,null,null,null,null);
            contacts.add(contact);
        }
        return contacts;
    }
}
