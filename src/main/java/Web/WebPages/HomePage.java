package Web.WebPages;

import Web.WebElements.Link;
import Web.WebElements.Text;
import Web.WebPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


/**
 * Created by Admin on 15-May-17.
 */
public class HomePage extends WebPage<HomePage> {

    private static final String MAIN_PAGE = "http://localhost/snews/";

//    @FindBy(id = "footer")
//    private WebElement footer;

    @FindBy(xpath = ".//*[@id='keywords']")
    private WebElement searchBox;

    @FindBy(xpath = ".//*[@id='search_engine']/p/input[2]")
    private WebElement searchButton;

    private static By loginButton = By.xpath(".//*[@id='footer']/p/a[2]");
    private static By footer = By.id("footer");
    private static By FIRST_TOPIC_IN_THE_PAGE = By.xpath(".//*[@id='main']/h2[1]/a");
    private static By FIRST_TOPIC_IN_THE_SIDE_BAR = By.xpath(".//*[@id='side']/div[2]/ul[1]/li[1]/a");
    private static By USER_NAME = By.xpath(".//*[@id='footer']/p/a[2]");

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
        topic = driver.findElement(FIRST_TOPIC_IN_THE_PAGE).getText();
        return topic;
    }

    public String getLatestNewTopic() {
        String topicTitle;
        topicTitle = driver.findElement(FIRST_TOPIC_IN_THE_SIDE_BAR).getText();
        return topicTitle;
    }

    public String getUserName() {
        return driver.findElement(USER_NAME).getText();
    }

    @Step
    public void findTopicByNameAndOpen(String name) throws InterruptedException {
        searchBox.clear();
        searchBox.sendKeys(name);
        searchButton.isDisplayed();
        searchButton.click();
        //Thread.sleep(2000);
        List<WebElement> topics = driver.findElements(By.xpath(".//*[@id='main']/p/a"));
        for (WebElement elem : topics) {
            if (elem.getText().contains(name)) {
                elem.click();
                break;
            }
        }
       // Thread.sleep(2000);
    }

}
