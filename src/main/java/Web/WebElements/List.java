package Web.WebElements;

import Web.WebComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;


public class List extends WebComponent<List> {

    private ArrayList<String> list;

    public List(WebDriver driver, By findByMethod) {
        super(driver, findByMethod);
        ArrayList<WebElement> allElements = new ArrayList<>(driver.findElements(findByMethod));
        for (WebElement elem: allElements) {
            list.add(elem.getText());
        }

    }
    public ArrayList<String> getList(){
        return this.list;
    }
}
