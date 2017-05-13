package Core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
public class DriverMaster {

    private static final String PATH_TO_CHROME_DRIVER = "src/drivers/chromedriver.exe";
    private static final String PATH_TO_IE_DRIVER = "src/drivers/IEDriverServer.exe";
    private static final String PATH_TO_FIREFOX_DRIVER = "src/drivers/geckodriver.exe";
    private static final String PATH_TO_EDGE_DRIVER = "src/drivers/MicrosoftWebDriver.exe";

    private DriverMaster() {}

    public static WebDriver getDriver(String driverKey){
        BrowserType browser = BrowserType.getBrowser(driverKey);
        WebDriver driver = null;
        switch (browser){
            case CHROME:
                System.setProperty("webdriver.chrome.driver", PATH_TO_CHROME_DRIVER);
                driver = new ChromeDriver();
                break;
            case FIREFOX:
                System.setProperty("webdriver.gecko.driver", PATH_TO_FIREFOX_DRIVER);
                driver = new FirefoxDriver();
                break;
            case IE:
                System.setProperty("webdriver.ie.driver", PATH_TO_IE_DRIVER);
                driver = new InternetExplorerDriver();
                break;
            case EDGE:
                System.setProperty("webdriver.edge.driver", PATH_TO_EDGE_DRIVER);
                driver = new EdgeDriver();
                break;
        }
        return driver;
    }

}
