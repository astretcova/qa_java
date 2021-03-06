package ru.stqa.pft.adressbook.appmeneger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    public WebDriver wd;

    private SessionHelper sessionHelper;
    private GroupNavigationHelper groupNavigationHelper;
    private GroupHelper groupHelp ;
    private ContactHelper contactHelper;
    private ContactNavigationHelper contactNavigationHelper;
    private String browser;


    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public void init() {
        if (browser.equals(BrowserType.FIREFOX)) {
            wd = new FirefoxDriver();
        } else if (browser.equals(BrowserType.CHROME)) {
            wd = new ChromeDriver();
        } else if (browser.equals(BrowserType.IE)) {
            wd = new InternetExplorerDriver();
        }

        wd.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
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

    public GroupHelper group() {
        return groupHelp;
    }

    public GroupNavigationHelper goTo() {
        return groupNavigationHelper;
    }

    public ContactHelper contact() {
        return contactHelper;
    }

    public ContactNavigationHelper goToPage() {
        return contactNavigationHelper;
    }

}
