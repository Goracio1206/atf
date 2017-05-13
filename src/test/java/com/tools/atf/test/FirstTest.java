package com.tools.atf.test;

import Core.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class FirstTest extends BaseTest {

    @Test
    public void TestMethod() {
        driver.get("https://facebook.com/");
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
        }
        driver.quit();
    }
}
