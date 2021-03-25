package ru.stqa.pft.adressbook.appmeneger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    public WebDriver wd;
    private GroupSessionHelper sessionHelp;
    private GroupNavigationHelper navigationHelp;
    private GroupHelper groupHelp ;
    private ContactHelper contactHelper;
    private ContactNavigationHelper contactNavigationHelper;

    public void init() {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wd.get("http://localhost/addressbook/");
        groupHelp = new GroupHelper(wd);
        navigationHelp = new GroupNavigationHelper(wd);
        sessionHelp = new GroupSessionHelper(wd);

        contactHelper = new ContactHelper(wd);
        contactNavigationHelper = new ContactNavigationHelper(wd);

        sessionHelp.login("admin", "secret");
    }

    public void stop() {
        wd.quit();
    }

    public GroupHelper getGroupHelp() {
        return groupHelp;
    }

    public GroupNavigationHelper getNavigationHelp() {
        return navigationHelp;
    }

    public ContactHelper getContactHelp() {
        return contactHelper;
    }

    public ContactNavigationHelper getContactNavigationHelp() {
        return contactNavigationHelper;
    }

}
