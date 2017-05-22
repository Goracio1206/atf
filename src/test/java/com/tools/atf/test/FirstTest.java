package com.tools.atf.test;

import Core.BaseTest;
import Web.WebPages.AdminPage;
import Web.WebPages.LoginPage;
import Web.WebPages.MainMenu;
import Web.WebPages.MainPage;
import org.testng.annotations.Test;

public class FirstTest extends BaseTest {

    @Test
    public void SimpleLoginAndLogOut() {
        new MainPage(driver).loadAnsWaitUntilAvailable().goToLoginPage();
        new LoginPage(driver).waitUntilAvailable().loginAs("test", "test");
        new AdminPage(driver).waitUntilAvailable();
        new MainMenu(driver).waitUntilAvailable().logOut();

    }
}
