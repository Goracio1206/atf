package Web.WebElements;

import Web.WebComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class TextInput extends WebComponent<TextInput> {

    protected WebElement element;

    public TextInput(WebDriver driver, WebElement element) {
        super(driver, element);
        this.element = element;
        this.element.clear();
    }

    public TextInput(WebDriver driver, By findByElement){
        super(driver, findByElement);
        this.element = driver.findElement(findByElement);
        this.element.clear();
    }

    public TextInput inputText(String text) {
        this.element.sendKeys();
        return this;
    }
}
