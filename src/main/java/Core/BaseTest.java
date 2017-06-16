package Core;

import org.openqa.selenium.WebDriver;
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
    public void setUp(String browser) {
        //new Environment().setEnvironment(baseURL);
        driver = DriverMaster.getDriver(browser);
        driver.manage().window().maximize();
    }


    /**
     * This will be executed after all suite to close the browser execution end.
     */
    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
