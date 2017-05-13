package Core;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

/**
 * This class contains all procedures which will be executed before and after each suite.
 * @vatriables driver need to set the driver according to value which will be entered from outside.
 *
 * @author Admin
 * @since 13.05.2017
 * @locale Ukraine, Lviv
 * @version 0.1
 */
public class BaseTest {

    protected WebDriver driver;

    /**
     * This Method will set the browser driver returned from DriverMaster to execute all next test cases on this browser.
     * And set the browser to full screen.
     * @param browser - will be transmitted through parameter from maven run commend.
     *
     * Annotation Parameters identify which parameter will be taken from run configuration.
     */
    @BeforeSuite(alwaysRun = true)
    @Parameters({"browser"})
    public void setUp(String browser) {
       driver = DriverMaster.getDriver(browser);
       driver.manage().window().fullscreen();
    }


    /**
     * This will be executed after all suite to close the browser execution end.
     */
    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
