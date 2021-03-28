package ru.stqa.pft.adressbook.appmeneger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends HelperBase {

    public SessionHelper(WebDriver wd) {
        super(wd);
    }
    public void login(String username, String password) {
        type(By.name("user"), username);
        type(By.name("pass"), password);
        wd.findElement(By.id("LoginForm")).submit();
    }

}