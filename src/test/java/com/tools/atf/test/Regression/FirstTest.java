package com.tools.atf.test.Regression;

import Core.BaseTest;
import Core.DriverMaster;
import Web.WebPages.AdminPage;
import Web.WebPages.HomePage;
import Web.WebPages.MainMenu;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.*;

import static Core.TestData.ADMIN_USER_NAME;
import static Core.TestData.ADMIN_USER_PASS;
import static org.hamcrest.Matchers.is;

public class FirstTest  {
    private static final String PATH_TO_CHROME_DRIVER = "src/drivers/chromedriver.exe";
    @Test(alwaysRun = true, threadPoolSize = 3)
    public void SimpleLoginAndLogOut() {

        System.setProperty("webdriver.chrome.driver", PATH_TO_CHROME_DRIVER);
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("http://google.com.ua");
        WebElement element = driver.findElement(By.id("spchl"));
        driver.get("http://facebook.com");
        driver.quit();


//        new HomePage(driver).loadAndWaitUntilAvailable().goToLoginPage().loginAs(ADMIN_USER_NAME, ADMIN_USER_PASS);
//        new AdminPage(driver).waitUntilAvailable().addNewPage("News4", "news3", "news3", true);
//        new HomePage(driver).loadAndWaitUntilAvailable();
//        Assert.assertTrue(new MainMenu(driver).isPagePresent("News4"));
//        new MainMenu(driver).logOut();


    }
}
