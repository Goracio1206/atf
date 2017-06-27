package Web.WebPages;

import Web.WebElements.Button;
import Web.WebElements.TextInput;
import Web.WebPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Admin on 15-May-17.
 */
public class LoginPage extends WebPage<LoginPage> {

    private static final String LOGIN_PAGE = "http://localhost/snews/login/";

    @FindBy(id = "uname")
    WebElement userNameInput;
    @FindBy(id = "pass")
    WebElement userPasswordInput;
    @FindBy(id = "calc")
    WebElement capchaInput;
    @FindBy(id = "submit")
    WebElement loginButton;


    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public LoginPage load() {
        driver.get(LOGIN_PAGE);
        return this;
    }

    @Override
    public boolean isAvailable() {
        return new TextInput(driver, userNameInput).waitUntilAvailable().isAvailable() &&
                new TextInput(driver, userPasswordInput).waitUntilAvailable().isAvailable() &&
                new TextInput(driver, capchaInput).waitUntilAvailable().isAvailable() &&
                new Button(driver, loginButton).waitUntilAvailable().isAvailable();
    }

    public AdminPage loginAs(String username, String password) {
        new TextInput(driver, userNameInput).inputText(username);
        new TextInput(driver, userPasswordInput).inputText(password);
        String capcha = capchaInput();
        new TextInput(driver, capchaInput).inputText(capcha);
        new Button(driver, loginButton).click();
        return new AdminPage(driver);
    }

    private String capchaInput() {
        String result = null;
        WebElement elemnt = driver.findElement(By.xpath(".//*[@id='post']/p[4]"));
        String expression = elemnt.getText();
        char splitedExpression[] = expression.toCharArray();
        int a = Integer.valueOf(String.valueOf(splitedExpression[splitedExpression.length - 3]));
        int b = Integer.valueOf(String.valueOf(splitedExpression[splitedExpression.length - 7]));
        int sum = a + b;
        result = String.valueOf(sum);
        return result;
    }

}
