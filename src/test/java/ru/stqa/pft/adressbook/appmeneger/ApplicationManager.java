package ru.stqa.pft.adressbook.appmeneger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    public WebDriver wd;
    private SessionHelper sessionHelper;
    private GroupNavigationHelper groupNavigationHelper;
    private GroupHelper groupHelp ;
    private ContactHelper contactHelper;
    private ContactNavigationHelper contactNavigationHelper;

    public void init() {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wd.get("http://localhost/addressbook/");
        groupHelp = new GroupHelper(wd);
        groupNavigationHelper = new GroupNavigationHelper(wd);
        sessionHelper = new SessionHelper(wd);

        contactHelper = new ContactHelper(wd);
        contactNavigationHelper = new ContactNavigationHelper(wd);

        sessionHelper.login("admin", "secret");
    }

    public void stop() {
        wd.quit();
    }

    public GroupHelper getGroupHelp() {
        return groupHelp;
    }

    public GroupNavigationHelper getGroupNavigationHelper() {
        return groupNavigationHelper;
    }

    public ContactHelper getContactHelper() {
        return contactHelper;
    }

    public ContactNavigationHelper getContactNavigationHelper() {
        return contactNavigationHelper;
    }

}
