package com.tools.atf.test.Test;

import Core.BaseTest;
import Web.WebElements.Link;
import Web.WebPages.AdminPage;
import Web.WebPages.Categories;
import Web.WebPages.MainMenu;
import Web.WebPages.MainPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static Core.TestData.*;


public class AddNewCategory extends BaseTest {



    @Test(alwaysRun = true)
    public void addNewCategory() {
        String categoryName = "testr7";
        new MainPage(driver).loadAnsWaitUntilAvailable().goToLoginPage().loginAs(ADMIN_USER_NAME, ADMIN_USER_PASS);

      //  new AdminPage(driver).waitUntilAvailable().addNewCategory(categoryName, categoryName, categoryName);
         Assert.assertTrue(new Categories(driver, By.xpath(CATEGORIES_SECTION)).isPresent(categoryName));
        //new MainMenu(driver).logOut();
    }

//

}
