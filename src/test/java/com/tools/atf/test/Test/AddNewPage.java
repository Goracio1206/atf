package com.tools.atf.test.Test;

import Core.BaseTest;
import Web.WebPages.AdminPage;
import Web.WebPages.HomePage;
import Web.WebPages.MainMenu;
import org.testng.Assert;
import org.testng.annotations.Test;

import static Core.TestData.*;
/**
 * Created by Admin on 22-Jun-17.
 */
public class AddNewPage extends BaseTest {

    @Test(alwaysRun = true)
    public void addNewPage(){
        new HomePage(driver).loadAndWaitUntilAvailable().goToLoginPage().loginAs(ADMIN_USER_NAME, ADMIN_USER_PASS);
        new AdminPage(driver).waitUntilAvailable().addNewPage("News4", "news3", "news3", true);
        new HomePage(driver).loadAndWaitUntilAvailable();
        Assert.assertTrue(new MainMenu(driver).isPagePresent("News4"));
        new MainMenu(driver).logOut();
    }
}
