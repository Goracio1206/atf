package com.tools.atf.test.Test;

import Core.BaseTest;
import Web.WebPages.AdminPage;
import Web.WebPages.HomePage;
import Web.WebPages.MainMenu;
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
        new HomePage(driver).loadAndWaitUntilAvailable().goToLoginPage().loginAs(ADMIN_USER_NAME, ADMIN_USER_PASS);
        new AdminPage(driver).waitUntilAvailable().addNewArticleOnHomePage(
                "Vitalii1",
                "kjdgfbjkdsbgkjsdbkgjbfdjgblfdsklgkjsldbjknvjksdfnjnfuihadsjkfadklf",
                ADMIN_ADD_NEW_TOPIC_CATEGORY_UNCATEGORIZED);
        new HomePage(driver).goToHomePage();
        // Validate that new Topic present in the home page and the same topic is in the New Posts section in the first position.
        assertThat("Topics are the same", new HomePage(driver).getLatestNewTopic().contains(new HomePage(driver).getFirstTopic()));

        new MainMenu(driver).logOut();
    }
}
