package Web.WebElements;

import Web.WebComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class TextInput extends WebComponent<TextInput> {

    public TextInput(WebDriver driver, By findByMethod) {
        super(driver, findByMethod);
        driver.findElement(findByMethod).clear();
    }

    public TextInput inputText(String text) {
        getWebElement().sendKeys(text);
        return this;
    }
}
