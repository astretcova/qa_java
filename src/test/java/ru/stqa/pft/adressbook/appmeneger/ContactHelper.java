package ru.stqa.pft.adressbook.appmeneger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.adressbook.model.ContactData;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void fillContactForm(ContactData conactData) {
        type(By.name("firstname"), conactData.getFirstname());
        type(By.name("lastname"), conactData.getLastname());
        type(By.name("address"), conactData.getAddress());
        type(By.name("email"), conactData.getEmail());
        type(By.name("address2"), conactData.getAddress2());
        type(By.name("mobile"), conactData.getMobile());
        type(By.name("email2"), conactData.getEmail2());
        type(By.name("byear"), conactData.getByear());
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

    public void allertAccept() {
        wd.switchTo().alert().accept();
    }

    public void initContactModification(int i) {
        click(By.xpath("(//img[@alt='Edit'])"));
    }

    public void submitContactModification() {
        click(By.name("update"));
    }

    public void createContact(ContactData contact) {
        gotoNewContact();
        fillContactForm(new ContactData("aaa", "bbb", "astrecova.marina@gmail.com", "ccc", "89110034406", "ddd", "mastretsova@rbc.ru", "1984"));
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
}
