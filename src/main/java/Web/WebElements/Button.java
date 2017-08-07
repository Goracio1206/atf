package Web.WebElements;

import Web.WebComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Admin on 15-May-17.
 */
public class Button extends WebComponent<Button> {

    public Button(WebDriver driver, By findByMethod) {
        super(driver, findByMethod);
    }

    public void pressButton() {
        click();
    }



}
