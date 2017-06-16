package com.tools.atf.test;

import Core.BaseTest;
import Web.WebPages.AdminPage;
import Web.WebPages.MainMenu;
import Web.WebPages.MainPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


import static Core.TestData.ADMIN_ADD_NEW_TOPIC_CATEGORY_UNCATEGORIZED;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static Core.TestData.ADMIN_USER_NAME;
import static Core.TestData.ADMIN_USER_PASS;

public class RegressionTest extends BaseTest {

    @Test(alwaysRun = true)
    public void SimpleLoginAndLogOut1() {
        AdminPage adminPage = new MainPage(driver).loadAnsWaitUntilAvailable().goToLoginPage().loginAs(ADMIN_USER_NAME, ADMIN_USER_PASS);
        //Verify that user logger in
        assertThat("Admin", is(new MainPage(driver).getUserName()));
        new AdminPage(driver).waitUntilAvailable();
        new MainMenu(driver).waitUntilAvailable().logOut();
        System.out.println("Log out performed");
        try {
            Thread.sleep(10000);
        } catch (Exception e) {
        }

    }

    @Test(alwaysRun = true)
    public void addNewTopic() {
        new MainPage(driver).loadAnsWaitUntilAvailable().goToLoginPage().loginAs(ADMIN_USER_NAME, ADMIN_USER_PASS);
        new AdminPage(driver).waitUntilAvailable().addNewArticleOnHomePage(
                "Vitalii1",
                "kjdgfbjkdsbgkjsdbkgjbfdjgblfdsklgkjsldbjknvjksdfnjnfuihadsjkfadklf",
                ADMIN_ADD_NEW_TOPIC_CATEGORY_UNCATEGORIZED);
        new MainMenu(driver).logOut();

    }
}
