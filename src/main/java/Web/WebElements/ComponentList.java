package Web.WebElements;

import Web.WebComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;


public class ComponentList extends WebComponent<ComponentList> {

    public List<WebElement> componentList;

    public ComponentList(WebDriver driver, WebElement element) {
        super(driver, element);
//        componentList = element;
    }

    public List<WebElement> getComponentList(){
        return this.componentList;
    }
}
