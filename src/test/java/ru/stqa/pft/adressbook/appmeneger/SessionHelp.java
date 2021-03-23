package ru.stqa.pft.adressbook.appmeneger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelp extends HelperBase{

    public SessionHelp(WebDriver wd) {
        super(wd);
        this.wd = wd;
    }
    public void login(String username, String password) {
        type(By.name("user"), username);
        type(By.name("pass"), password);
        wd.findElement(By.id("LoginForm")).submit();
    }

}
