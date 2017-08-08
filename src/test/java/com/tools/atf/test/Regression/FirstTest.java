package com.tools.atf.test.Regression;

import Core.BaseTest;
import Web.WebElements.Link;
import Web.WebPages.HomePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class FirstTest extends BaseTest {
    private static final String PATH_TO_CHROME_DRIVER = "src/drivers/chromedriver.exe";

    @Test(alwaysRun = true)
    public void SimpleLoginAndLogOut() throws InterruptedException {
//        driver.get("http://localhost/snews/");
//        Thread.sleep(3000);
//        Link button = new Link(driver, By.xpath(".//*[@id='main']/h2[1]/a"));
//        button.click();
//        Thread.sleep(3000);
//        //List<WebElement> elements = driver.findElements(By.xpath(".//*[@id='main']"));
//        WebElement test = driver.findElement(By.xpath(".//*[@id='main']"));
//
//        String text[] = test.getText().split("\\n");
//        for (String elem: text) {
//            System.out.println(text.length);
//            System.out.println(elem);
//        }

        new HomePage(driver).loadAndWaitUntilAvailable().findTopicByNameAndOpen("Vitalii1-1508637454");


//        new HomePage(driver).loadAndWaitUntilAvailable().goToLoginPage().loginAs(ADMIN_USER_NAME, ADMIN_USER_PASS);
//        new AdminPage(driver).waitUntilAvailable().addNewPage("News4", "news3", "news3", true);
//        new HomePage(driver).loadAndWaitUntilAvailable();
//        Assert.assertTrue(new MainMenu(driver).isPagePresent("News4"));
//        new MainMenu(driver).logOut();


    }
}
