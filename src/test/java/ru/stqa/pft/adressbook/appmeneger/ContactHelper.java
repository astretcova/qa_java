package ru.stqa.pft.adressbook.appmeneger;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.adressbook.model.ContactData;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void fillContactForm(ContactData conactData, boolean creation) {
        type(By.name("firstname"), conactData.getFirstname());
        type(By.name("lastname"), conactData.getLastname());
        type(By.name("address"), conactData.getAddress());
        type(By.name("email"), conactData.getEmail());
        type(By.name("address2"), conactData.getAddress2());
        type(By.name("mobile"), conactData.getMobile());
        type(By.name("email2"), conactData.getEmail2());
        type(By.name("byear"), conactData.getByear());


        if (creation) {
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(conactData.getGroup());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
    }

    public void submitContact() {
        click(By.xpath("(//input[@name='submit'])[2]"));
    }

    public void returnToContactPage() {
        click(By.linkText("home page"));
    }
    public void selectContact() {
        click(By.name("selected[]"));
    }

    public void deleteSelectedContact() {
        click(By.xpath("//div[2]/input"));
    }

    public void allertAccept() {
        wd.switchTo().alert().accept();
    }

    public void initContactModification() {
        click(By.xpath("(//img[@alt='Edit'])[2]"));
    }

    public void submitContactModification() {
        click(By.name("update"));
    }
}
