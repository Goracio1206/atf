package Web.WebElements;

import Web.WebComponent;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Admin on 12-Jun-17.
 */
public class DropDown extends WebComponent<DropDown> {

    WebElement element = null;

    public DropDown(WebDriver driver, By findByMethod) {
        super(driver, findByMethod);
        element = driver.findElement(findByMethod);
    }

    public void selectByVisibleText(String text){
       Select select = new Select(this.element);
       select.selectByVisibleText(text);
    }

     public void selectByIndex(int index){
        Select select = new Select(this.element);
        select.selectByIndex(index);
    }
}
