package Web.WebPages;

import Web.WebElements.Link;
import Web.WebElements.Text;
import Web.WebPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * Created by Admin on 15-May-17.
 */
public class HomePage extends WebPage<HomePage> {

    private static final String MAIN_PAGE = "http://localhost/snews/";

//    @FindBy(id = "footer")
//    private WebElement footer;

    private static By loginButton = By.xpath(".//*[@id='footer']/p/a[2]");
    private static By footer = By.id("footer");


    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public HomePage load() {
        driver.get(MAIN_PAGE);
        return this;
    }

      @Override
    public boolean isAvailable() {
        return new MainMenu(driver).waitUntilAvailable().isAvailable() &&
                new Text(driver, footer).waitUntilAvailable().isAvailable();
    }

    public LoginPage goToLoginPage() {
        new Link(driver, loginButton).click();
        return new LoginPage(driver).waitUntilAvailable();
    }

    public HomePage goToHomePage() {
        return new HomePage(driver).loadAndWaitUntilAvailable();
    }

    public String getFirstTopic() {
        String topic;
        topic = driver.findElement(By.xpath(".//*[@id='main']/h2[1]/a")).getText();
        return topic;
    }

    public String getLatestNewTopic() {
        String topicTitle;
        topicTitle = driver.findElement(By.xpath(".//*[@id='side']/div[2]/ul[1]/li[1]/a")).getText();
        return topicTitle;
    }

    public String getUserName() {
        return driver.findElement(By.xpath(".//*[@id='footer']/p/a[2]")).getText();
    }

}
