package ru.stqa.pft.adressbook.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.stqa.pft.adressbook.appmeneger.ApplicationMenege;


public class TestBase {

    protected final ApplicationMenege app = new ApplicationMenege();

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws Exception {
        app.init();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() throws Exception {
        app.stop();
    }

    public ApplicationMenege getApp() {
        return app;
    }
}
