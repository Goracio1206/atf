package Web.WebPages;

import Core.Environment;
import Web.WebPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Admin on 16-May-17.
 */
public class AdminPage extends WebPage<AdminPage> {

    private static final String ADMIN_PAGE = new Environment().BASE_URL + "/snews/administration/";

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

}
