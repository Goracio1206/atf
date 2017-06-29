package Web.WebElements;

import Web.WebComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Admin on 19-Jun-17.
 */
public class Categories extends WebComponent<Categories> {
    //TODO: Need to add xPath for Category List
    @FindBy(xpath = ".//*[@id='side']/div[1]/ul[1]/li")
    public List<WebElement> categoriesItems;
    public Map<String, Integer> topicPerCategory = new HashMap<String, Integer>();

    public Categories(WebDriver driver, By findByMethod) {
        super(driver, findByMethod);
        PageFactory.initElements(driver, this);
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
        for (WebElement element : categoriesItems) {
            String[] mass = new String[3];
            mass = element.getText().split("[()]");
            topicPerCategory.put(mass[0], Integer.valueOf(mass[1]));
        }
    }
}
