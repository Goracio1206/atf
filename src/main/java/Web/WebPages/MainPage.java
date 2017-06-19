package Web.WebPages;

import Core.BaseTest;
import Core.Environment;
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
       return new MainMenu(driver).waitUntilAvailable().isAvailable() && new Text(driver, By.id("footer")).waitUntilAvailable().isAvailable();
    }

    public LoginPage goToLoginPage(){
        new Link(driver, By.xpath("//*[@id='footer']/p/a[2]")).click();
        return new LoginPage(driver).waitUntilAvailable();
    }

    public MainPage goToHomePage(){
        return new MainPage(driver).load();
    }
    public String getUserName(){
        return driver.findElement(By.xpath(".//*[@id='footer']/p/a[2]")).getText();
    }

}
