package Web.WebElements;

import Web.WebComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class Text extends WebComponent<Text> {
    public Text(WebDriver driver, WebElement element) {
        super(driver, element);
    }
    public Text(WebDriver driver, By findByMethod) {
        super(driver, findByMethod);
    }

}
