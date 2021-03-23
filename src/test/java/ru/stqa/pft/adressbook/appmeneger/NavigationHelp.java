package ru.stqa.pft.adressbook.appmeneger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelp {
    private WebDriver wd;

    public NavigationHelp(WebDriver wd) {
        this.wd=wd;
    }

    public void gotoGroupPage() {
        wd.findElement(By.linkText("groups")).click();
    }
}
