package com.tools.atf.test;

import Core.BaseTest;
import Web.WebPages.AdminPage;
import Web.WebPages.LoginPage;
import Web.WebPages.MainMenu;
import Web.WebPages.MainPage;
import org.testng.annotations.Test;

public class FirstTest extends BaseTest {

    @Test
    public void TestMethod() {
        new MainPage(driver).loadAnsWaitUntilAvailable().goToLoginPage();
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
        }
        new LoginPage(driver).waitUntilAvailable().loginAs("test", "test");
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
        }
        new AdminPage(driver).waitUntilAvailable();
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
        }
        new MainMenu(driver).waitUntilAvailable().logOut();
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
        }
    }
}
