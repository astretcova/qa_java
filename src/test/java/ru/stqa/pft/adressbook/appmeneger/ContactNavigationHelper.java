package ru.stqa.pft.adressbook.appmeneger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactNavigationHelper extends HelperBase {
    public ContactNavigationHelper(WebDriver wd) {
        super(wd);
    }

    public void gotoNewContact() {
        click(By.linkText("add new"));
    }
    public void gotoHomeContact() {
        if (isElementPresent(By.id("maintable"))){
            return;
        }
        click(By.linkText("home"));
    }
}
