package Web.WebPages;

import Web.WebElements.ComponentList;
import Web.WebElements.Link;
import Web.WebPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 15-May-17.
 */
public class MainMenu extends WebPage<MainMenu> {
    By mainPage = By.xpath(".//*[@id='topmenu']");
    By logOutLink = By.xpath(".//*[@id='footer']/p/a[3]");

    @FindBy(xpath = ".//*[@id='topmenu']/li")
    private List<WebElement> menuItems;

    public List<String> pages = new ArrayList<>();

    public MainMenu(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.setPages();
    }


    @Override
    public MainMenu load() {
        return this;
    }

    @Override
    public boolean isAvailable() {
        return driver.findElement(mainPage).isDisplayed();
    }

    public void logOut() {
        new Link(driver, logOutLink).click();
    }

    public boolean isPagePresent(String pageName) {
       return pages.contains(pageName);
    }

    private void setPages() {
        for (WebElement elem : menuItems) {
            pages.add(elem.getText());
        }
    }
}
