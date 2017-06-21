package com.tools.atf.test.Test;

import Core.BaseTest;
import Web.WebPages.AdminPage;
import Web.WebPages.MainMenu;
import Web.WebPages.MainPage;
import org.testng.annotations.Test;

import static Core.TestData.ADMIN_ADD_NEW_TOPIC_CATEGORY_UNCATEGORIZED;
import static Core.TestData.ADMIN_USER_NAME;
import static Core.TestData.ADMIN_USER_PASS;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Admin on 22-Jun-17.
 */
public class AddNewTopic extends BaseTest {

    @Test(alwaysRun = true)
    public void addNewTopic() {
        new MainPage(driver).loadAnsWaitUntilAvailable().goToLoginPage().loginAs(ADMIN_USER_NAME, ADMIN_USER_PASS);
        new AdminPage(driver).waitUntilAvailable().addNewArticleOnHomePage(
                "Vitalii1",
                "kjdgfbjkdsbgkjsdbkgjbfdjgblfdsklgkjsldbjknvjksdfnjnfuihadsjkfadklf",
                ADMIN_ADD_NEW_TOPIC_CATEGORY_UNCATEGORIZED);
        new MainPage(driver).goToHomePage();
        assertThat("Topics are the same", new MainPage(driver).getLatestNewTopic().contains(new MainPage(driver).getFirstTopic()));
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
        }
        new MainMenu(driver).logOut();
    }
}
