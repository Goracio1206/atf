package Web.WebElements;

import Web.WebComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Admin on 16-May-17.
 */
public class Link extends WebComponent<Link> {
    public Link(WebDriver driver, By findByMethod) {
        super(driver, findByMethod);
    }
}
