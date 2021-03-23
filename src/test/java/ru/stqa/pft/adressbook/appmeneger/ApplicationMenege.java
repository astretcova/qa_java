package ru.stqa.pft.adressbook.appmeneger;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationMenege {
    public WebDriver wd;
    private SessionHelp sessionHelp;
    private NavigationHelp navigationHelp;
    private GroupHelp groupHelp ;

    public void init() {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wd.get("http://localhost/addressbook/");
        groupHelp = new GroupHelp(wd);
        navigationHelp = new NavigationHelp(wd);
        sessionHelp = new SessionHelp(wd);
        sessionHelp.login("admin", "secret");
    }


    public void stop() {
        wd.quit();
    }


    public GroupHelp getGroupHelp() {
        return groupHelp;
    }

    public NavigationHelp getNavigationHelp() {
        return navigationHelp;
    }
}
