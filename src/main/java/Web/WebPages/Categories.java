package Web.WebPages;

import Web.WebComponent;
import Web.WebElements.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.ArrayList;

import static Core.TestData.*;

/**
 * Created by Admin on 19-Jun-17.
 */
public class Categories extends WebComponent<Categories> {

    List list;

    public Categories(WebDriver driver, By findByMethod) {
        super(driver, findByMethod);
        list = new List(driver, By.xpath(CATEGORIES_SECTION));
    }

    public boolean isPresent(String categoryName) {
        ArrayList<String> allCategory = list.getList();
        for (String elem : allCategory) {
            System.out.println(elem);
        }
        for (String elem : allCategory) {
            if (elem.contains(categoryName)) {
                return true;
            }
        }
        return false;
    }
}
