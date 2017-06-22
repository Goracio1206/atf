package Web.WebPages;

import Web.WebElements.ComponentList;
import Web.WebElements.Link;
import Web.WebPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 15-May-17.
 */
public class MainMenu extends WebPage<MainMenu> {
    private static final String MAIN_MENU = ".//*[@id='topmenu']";


    public List<WebElement> menuItems;
    public List<String> pages = new ArrayList<>();

    public MainMenu(WebDriver driver) {
        super(driver);
        menuItems = new ComponentList(driver, By.xpath(".//*[@id='topmenu']/li")).getComponentList();
        this.setPages();
    }


    @Override
    public MainMenu load() {
        return this;
    }

    @Override
    public boolean isAvailable() {
        return driver.findElement(By.xpath(MAIN_MENU)).isDisplayed();
    }

    public void logOut() {
        new Link(driver, By.xpath(".//*[@id='footer']/p/a[3]")).click();
    }

    public boolean isPagePresent(String pageName) {
       return pages.contains(pageName);
    }

    private void setPages() {
        String item;
        for (WebElement elem : menuItems) {
            pages.add(elem.getText());
        }
    }
}
