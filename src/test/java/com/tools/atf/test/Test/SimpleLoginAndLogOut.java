package com.tools.atf.test.Test;

import Core.BaseTest;
import Web.WebPages.AdminPage;
import Web.WebPages.HomePage;
import Web.WebPages.MainMenu;
import org.testng.annotations.Test;

import static Core.TestData.ADMIN_USER_NAME;
import static Core.TestData.ADMIN_USER_PASS;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Created by Admin on 22-Jun-17.
 */
public class SimpleLoginAndLogOut extends BaseTest {

    @Test(alwaysRun = true)
    public void SimpleLoginAndLogOut() {
        new HomePage(driver).loadAndWaitUntilAvailable();
        new HomePage(driver).loadAndWaitUntilAvailable().goToLoginPage().loginAs(ADMIN_USER_NAME, ADMIN_USER_PASS);
        //Verify that user logged in
        assertThat("Admin", is(new HomePage(driver).getUserName()));
        new AdminPage(driver).waitUntilAvailable();
        new MainMenu(driver).waitUntilAvailable().logOut();
    }
}
