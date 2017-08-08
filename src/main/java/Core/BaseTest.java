package Core;

import Web.WebPages.MainMenu;
import Web.WebPages.HomePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

/**
 * This class contains all procedures which will be executed before and after each suite.
 *
 * @author Admin
 * @version 0.1
 * @vatriables driver need to set the driver according to value which will be entered from outside.
 * @locale Ukraine, Lviv
 * @since 13.05.2017
 */
public class BaseTest {

    protected WebDriver driver;


    /**
     * This Method will set the browser driver returned from DriverMaster to execute all next test cases on this browser.
     * And set the browser to full screen.
     *
     * @param browser - will be transmitted through parameter from maven run commend.
     *                <p>
     *                Annotation Parameters identify which parameter will be taken from run configuration.
     */
    @BeforeClass(alwaysRun = true)
    @Parameters({"browser"})
    @Step("Run {browser} browser!")
    public void setUp(@Optional("chrome") String browser) {
        driver = DriverMaster.getDriver(browser);
        driver.manage().window().maximize();
    }


//    @AfterTest(alwaysRun = true)
//    public void logout(){
//        new HomePage(driver).loadAndWaitUntilAvailable();
//        WebElement element = driver.findElement(By.xpath(".//*[@id='footer']/p/a[2]"));
//        if (!element.getText().equals("Login")){
//            new MainMenu(driver).logOut();
//        }
//    }


    /**
     * This will be executed after all suite to close the browser execution end.
     */
    @AfterClass(alwaysRun = true)
    @Step("Log out and close browser.")
    public void tearDown() {
        new HomePage(driver).loadAndWaitUntilAvailable();
        WebElement element = driver.findElement(By.xpath(".//*[@id='footer']/p/a[2]"));
        if (!element.getText().equals("Login")){
            new MainMenu(driver).logOut();
        }
        try{
            Thread.sleep(5000);
        }catch(Exception e){

        }
        driver.quit();
    }
}
