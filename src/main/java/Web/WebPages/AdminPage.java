package Web.WebPages;

import Core.Environment;
import Web.WebElements.*;
import Web.WebPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Random;

/**
 * Created by Admin on 16-May-17.
 */
public class AdminPage extends WebPage<AdminPage> {

    /*PAGE*/
    private static final String ADMIN_PAGE = new Environment().BASE_URL + "/snews/administration/";
    /*LINKS*/
    private static final String ADMIN_LINK_ADD_NEW_TOPIC = ".//*[@id='main']/div[1]/p[3]/a[1]";
    private static final String ADMIN_LINK_ADD_NEW_CATEGORY = ".//*[@id='main']/div[1]/p[2]/a[1]";
    /*INPUTS*/
    private static final String ADMIN_INPUT_NEW_TOPIC_TITLE = ".//*[@id='at']";
    private static final String ADMIN_INPUT_NEW_TOPIC_TEXT = ".//*[@id='txt']";
    private static final String ADMIN_INPUT_NEW_CATEGORY_NAME = ".//*[@id='t']";
    private static final String ADMIN_INPUT_NEW_CATEGORY_SEARCH_ENGINE_FRIENDLY = ".//*[@id='s']";
    private static final String ADMIN_INPUT_NEW_CATEGORY_DESCRIPTION = ".//*[@id='desc']";
    /*DROP DOWNS*/
    private static final String ADMIN_DROPDOWN_NEW_TOPIC_CATEGORY = ".//*[@id='cat']";
    /*CHECK BOXES*/
    private static final String ADMIN_CHECHBOX_NEW_TOPIC_SHOW_ON_HOME_PAGE = ".//*[@id='sho']";
    /*BUTTONS*/
    private static final String ADMIN_BUTTON_NEW_TOPIC_SUBMIT = ".//*[@id='add_article']";
    private static final String ADMIN_BUTTON_NEW_CATEGORY_SUBMIT = ".//*[@id='add_category']";

    public AdminPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public AdminPage load() {
        driver.get(ADMIN_PAGE);
        return this;
    }

    @Override
    public boolean isAvailable() {
        return new MainMenu(driver).waitUntilAvailable().isAvailable()&&
                driver.findElement(By.xpath(".//*[@class='adminpanel']")).isDisplayed();
    }

    public void addTheSameTopic(String title, String text, String category){
        new AdminPage(driver).load().waitUntilAvailable().addNewArticleOnHomePage(title, text, category);
        new AdminPage(driver).load().waitUntilAvailable().addNewArticleOnHomePage(title, text, category);

    }

    public void addNewArticleOnHomePage(String title, String text, String category){
        new Link(driver, By.xpath(ADMIN_LINK_ADD_NEW_TOPIC)).click();
        new TextInput(driver, By.xpath(ADMIN_INPUT_NEW_TOPIC_TITLE)).inputText(title + new Random(System.currentTimeMillis()).nextInt());
        new TextInput(driver, By.xpath(ADMIN_INPUT_NEW_TOPIC_TEXT)).inputText(text);
        new DropDown(driver, By.xpath(ADMIN_DROPDOWN_NEW_TOPIC_CATEGORY)).selectByVisibleText(category);
        new CheckBox(driver, By.xpath(ADMIN_CHECHBOX_NEW_TOPIC_SHOW_ON_HOME_PAGE)).check();
        try{
            Thread.sleep(500);
        }catch (Exception e){

        }
        new Button(driver, By.xpath(ADMIN_BUTTON_NEW_TOPIC_SUBMIT)).click();
        try{
            Thread.sleep(500);
        }catch (Exception e){

        }
    }

    public void addNewCategory(String name, String engineFriendly, String description ){
        new Link(driver, By.xpath(ADMIN_LINK_ADD_NEW_CATEGORY)).click();
        new TextInput(driver, By.xpath(ADMIN_INPUT_NEW_CATEGORY_NAME)).inputText(name);
        new TextInput(driver, By.xpath(ADMIN_INPUT_NEW_CATEGORY_SEARCH_ENGINE_FRIENDLY)).inputText(engineFriendly);
        new TextInput(driver, By.xpath(ADMIN_INPUT_NEW_CATEGORY_DESCRIPTION)).inputText(description);
        new Button(driver, By.xpath(ADMIN_BUTTON_NEW_CATEGORY_SUBMIT)).click();
    }
}
