package Web.WebPages;

import Web.WebElements.Link;
import Web.WebElements.Text;
import Web.WebPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


/**
 * Created by Admin on 15-May-17.
 */
public class MainPage extends WebPage<MainPage> {

    private static final String MAIN_PAGE = "http://localhost/snews/";


    public MainPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public MainPage load() {
        driver.get(MAIN_PAGE);
        return this;
    }

      @Override
    public boolean isAvailable() {
        return new MainMenu(driver).waitUntilAvailable().isAvailable() &&
                new Text(driver, By.id("footer")).waitUntilAvailable().isAvailable() &&
                new Link(driver, By.xpath(".//*[@id='footer']/p/a[2]")).waitUntilAvailable().isAvailable();
    }

    public LoginPage goToLoginPage() {
        new Link(driver, By.xpath(".//*[@id='footer']/p/a[2]")).click();
        return new LoginPage(driver).waitUntilAvailable();
    }

    public MainPage goToHomePage() {
        return new MainPage(driver).load();
    }

    public String getFirstTopic() {
        String topic = null;
        topic = driver.findElement(By.xpath(".//*[@id='main']/h2[1]/a")).getText();
        return topic;
    }

    public String getLatestNewTopic() {
        String topicTitle = null;
        topicTitle = driver.findElement(By.xpath(".//*[@id='side']/div[2]/ul[1]/li[1]/a")).getText();
        return topicTitle;
    }

    public String getUserName() {
        return driver.findElement(By.xpath(".//*[@id='footer']/p/a[2]")).getText();
    }

}
