package Web;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class WebComponent<T extends WebComponent<T>> extends Component<T> {

    protected WebElement webElement;


    public WebComponent(WebDriver driver, WebElement webElement) {
        super(driver);
        this.webElement = webElement;
    }

    public WebComponent(WebDriver driver, By findByMethod){
        super(driver);
        this.webElement = getWebElement(findByMethod);
    }
    @Override
    public boolean isAvailable(){
        try {
        return this.webElement != null;
        } catch (NoSuchElementException e){
            return false;
        }
    }

    public void click(){
        this.webElement.click();
    }

    public String getText(){
        return this.webElement.getText();
    }

    protected WebElement getWebElement(By findByMethod){
        return driver.findElement(findByMethod);
    }

}
