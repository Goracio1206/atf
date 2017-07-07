package Web.WebPages;

import Core.Environment;
import Web.WebElements.*;
import Web.WebPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Random;

/**
 * Created by Admin on 16-May-17.
 */
public class AdminPage extends WebPage<AdminPage> {

    /*PAGE*/
    private static final String ADMIN_PAGE = new Environment().BASE_URL + "/snews/administration/";
    /*LINKS*/

    @FindBy(xpath = ".//*[@id='main']/div[1]/p[3]/a[1]")
    WebElement adminLinkAddNewTopic;

    private static final By ADMIN_LINK_ADD_NEW_TOPIC = By.xpath(".//*[@id='main']/div[1]/p[3]/a[1]");
    private static final By ADMIN_LINK_ADD_NEW_CATEGORY = By.xpath(".//*[@id='main']/div[1]/p[2]/a[1]");
    private static final By ADMIN_LINK_ADD_NEW_PAGE = By.xpath(".//*[@id='main']/div[1]/p[4]/a[1]");
    private static final By ADMIN_LINK_ADD_NEW_PAGE_CUSTOMIZE_SECTION = By.xpath(".//*[@id='post']/div[3]/p/a");
    /*INPUTS*/
    private static final By ADMIN_INPUT_NEW_TOPIC_TITLE = By.xpath(".//*[@id='at']");
    private static final By ADMIN_INPUT_NEW_TOPIC_TEXT = By.xpath(".//*[@id='txt']");
    private static final By ADMIN_INPUT_NEW_CATEGORY_NAME = By.xpath(".//*[@id='t']");
    private static final By ADMIN_INPUT_NEW_CATEGORY_SEARCH_ENGINE_FRIENDLY = By.xpath(".//*[@id='s']");
    private static final By ADMIN_INPUT_NEW_CATEGORY_DESCRIPTION = By.xpath(".//*[@id='desc']");
    private static final By ADMIN_INPUT_NEW_PAGE_TITLE = By.xpath(".//*[@id='at']");
    private static final By ADMIN_INPUT_NEW_PAGE_SEARCH_ENGINE_FRIENDLY = By.xpath(".//*[@id='as']");
    private static final By ADMIN_INPUT_NEW_PAGE_TEXT = By.xpath(".//*[@id='txt']");

    /*DROP DOWNS*/
    private static final By ADMIN_DROPDOWN_NEW_TOPIC_CATEGORY = By.xpath(".//*[@id='cat']");
    /*CHECK BOXES*/
    private static final By ADMIN_CHECKBOX_NEW_TOPIC_SHOW_ON_HOME_PAGE = By.xpath(".//*[@id='sho']");
    private static final By ADMIN_CHECKBOX_NEW_PAGE_ENABLE_COMMENTS = By.xpath(".//*[@id='ca']");
    /*BUTTONS*/
    private static final By ADMIN_BUTTON_NEW_TOPIC_SUBMIT = By.xpath(".//*[@id='add_article']");
    private static final By ADMIN_BUTTON_NEW_CATEGORY_SUBMIT = By.xpath(".//*[@id='add_category']");
    private static final By ADMIN_BUTTON_NEW_PAGE_SUBMIT = By.xpath(".//*[@id='add_article']");


    public AdminPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public AdminPage load() {
        driver.get(ADMIN_PAGE);
        return this;
    }

    @Override
    public boolean isAvailable() {
        return new MainMenu(driver).waitUntilAvailable().isAvailable() &&
                driver.findElement(By.xpath(".//*[@class='adminpanel']")).isDisplayed() &&
                driver.findElement(ADMIN_LINK_ADD_NEW_PAGE).isDisplayed() &&
                driver.findElement(ADMIN_LINK_ADD_NEW_CATEGORY).isDisplayed();
    }

    public void addTheSameTopic(String title, String text, String category) {
        new AdminPage(driver).load().waitUntilAvailable().addNewArticleOnHomePage(title, text, category);
        new AdminPage(driver).load().waitUntilAvailable().addNewArticleOnHomePage(title, text, category);

    }

    public void addNewArticleOnHomePage(String title, String text, String category) {
        new Link(driver, ADMIN_LINK_ADD_NEW_TOPIC).click();
        new TextInput(driver, ADMIN_INPUT_NEW_TOPIC_TITLE).inputText(title + new Random(System.currentTimeMillis()).nextInt());
        new TextInput(driver, ADMIN_INPUT_NEW_TOPIC_TEXT).inputText(text);
        new DropDown(driver, ADMIN_DROPDOWN_NEW_TOPIC_CATEGORY).selectByVisibleText(category);
        new CheckBox(driver, ADMIN_CHECKBOX_NEW_TOPIC_SHOW_ON_HOME_PAGE).check();
        new Button(driver, ADMIN_BUTTON_NEW_TOPIC_SUBMIT).click();
    }

    public void addNewCategory(String name, String engineFriendly, String description) {
        new Link(driver, ADMIN_LINK_ADD_NEW_CATEGORY).click();
        new TextInput(driver, ADMIN_INPUT_NEW_CATEGORY_NAME).inputText(name);
        new TextInput(driver, ADMIN_INPUT_NEW_CATEGORY_SEARCH_ENGINE_FRIENDLY).inputText(engineFriendly);
        new TextInput(driver, ADMIN_INPUT_NEW_CATEGORY_DESCRIPTION).inputText(description);
        new Button(driver, ADMIN_BUTTON_NEW_CATEGORY_SUBMIT).click();
    }

    public void addNewPage(String pageName, String searchEngine, String text, boolean comments) {
        new Link(driver, ADMIN_LINK_ADD_NEW_PAGE).click();
        new TextInput(driver, ADMIN_INPUT_NEW_PAGE_TITLE).inputText(pageName);
        new TextInput(driver, ADMIN_INPUT_NEW_PAGE_SEARCH_ENGINE_FRIENDLY).inputText(searchEngine);
        new TextInput(driver, ADMIN_INPUT_NEW_PAGE_TEXT).inputText(text);
        if (comments) {
            new Link(driver, ADMIN_LINK_ADD_NEW_PAGE_CUSTOMIZE_SECTION).click();
            new CheckBox(driver, ADMIN_CHECKBOX_NEW_PAGE_ENABLE_COMMENTS).check();
        }
        new Button(driver, ADMIN_BUTTON_NEW_PAGE_SUBMIT).click();
    }
}
