package ru.stqa.pft.adressbook.tests;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class ContactDeletionsTests extends TestBase {

    @Test
    public void testContactDeletions() throws Exception {

        app.getContactNavigationHelper().gotoHomeContact();
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteSelectedContact();
        app.getContactHelper().allertAccept();
        app.getContactNavigationHelper().gotoHomeContact();
    }
}
