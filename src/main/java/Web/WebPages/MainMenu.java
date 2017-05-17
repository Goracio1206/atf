package Web.WebPages;

import Web.WebElements.Link;
import Web.WebPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Admin on 15-May-17.
 */
public class MainMenu extends WebPage<MainMenu> {
    private static final String MAIN_MENU = "//*[@id='topmenu']";

    public MainMenu(WebDriver driver) {
        super(driver);
    }


    @Override
    public MainMenu load() {
        return this;
    }

    @Override
    public boolean isAvailable() {
        if (driver.findElement(By.xpath(MAIN_MENU)) != null) {
            return true;
        }
        return false;
    }

    public void logOut(){
        new Link(driver, By.xpath(".//*[@id='footer']/p/a[3]")).click();
    }
}
