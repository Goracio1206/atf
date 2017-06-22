package Web.WebPages;

import Web.WebComponent;
import Web.WebElements.ComponentList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Admin on 19-Jun-17.
 */
public class Categories extends WebComponent<Categories> {

    public List<WebElement> categoriesItems;
    public Map<String, Integer> topicPerCategory = new HashMap<String, Integer>();

    public Categories(WebDriver driver, By findByMethod) {
        super(driver, findByMethod);
        categoriesItems = new ComponentList(driver, findByMethod).getComponentList();
        this.setTopicPerCategory();
    }

    public boolean isNewCategoryPresent(String categoryName) {
        for (Map.Entry<String, Integer> elem : topicPerCategory.entrySet()) {
            if (elem.getKey().equals(categoryName) && elem.getValue().equals(0)) {
                return true;
            }
        }
        return false;
    }

    private void setTopicPerCategory() {
        String categoryName;
        Integer topicsNumber;
        for (WebElement element : categoriesItems) {
            String[] mass = new String[3];
            mass = element.getText().split("[()]");
            categoryName = mass[0];
            topicsNumber = Integer.valueOf(mass[1]);
            topicPerCategory.put(mass[0], Integer.valueOf(mass[1]));
        }
    }
}
