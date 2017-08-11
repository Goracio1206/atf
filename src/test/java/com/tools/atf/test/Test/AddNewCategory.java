package com.tools.atf.test.Test;

import Core.BaseTest;
import Web.WebPages.AdminPage;
import Web.WebElements.Categories;
import Web.WebPages.MainMenu;
import Web.WebPages.HomePage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Title;

import static Core.TestData.*;

@Description("Category functionality")
public class AddNewCategory extends BaseTest {

    @Test(alwaysRun = true, description = "Add Category TC")
    public void addNewCategory() {
        String categoryName = "testr9";
        new HomePage(driver).loadAndWaitUntilAvailable().goToLoginPage().loginAs(ADMIN_USER_NAME, ADMIN_USER_PASS);
        new AdminPage(driver).waitUntilAvailable().addNewCategory(categoryName, categoryName, categoryName);
        //Validate that new category is present and has 0 topics.
        Assert.assertTrue(new Categories(driver, By.xpath(CATEGORIES_SECTION)).isNewCategoryPresent(categoryName));
        new MainMenu(driver).logOut();
    }
}
