package Web.WebElements;

import Web.WebComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Admin on 12-Jun-17.
 */
public class CheckBox extends WebComponent<CheckBox> {

    WebElement element = null;

    public CheckBox(WebDriver driver, By findByMethod) {
        super(driver, findByMethod);
        element = driver.findElement(findByMethod);
    }

    public void check(){
        if(!this.element.isSelected()){
            this.click();
        }
    }

    public void unCheck(){
        if(this.element.isSelected()){
            this.click();
        }
    }
}
