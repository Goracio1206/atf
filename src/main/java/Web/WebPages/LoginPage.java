package Web.WebPages;

import Web.WebElements.Button;
import Web.WebElements.TextInput;
import Web.WebPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Admin on 15-May-17.
 */
public class LoginPage extends WebPage<LoginPage> {

    private static final String LOGIN_PAGE = "http://localhost/snews/login/";

    @FindBy(id = "uname")
    WebElement userName;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public LoginPage load() {
        driver.get(LOGIN_PAGE);
        return this;
    }

    @Override
    public boolean isAvailable() {
        return getUsernameInput().waitUntilAvailable().isAvailable() &&
                getPasswordInput().waitUntilAvailable().isAvailable() &&
                getCapchaInput().waitUntilAvailable().isAvailable() &&
                getLoginButton().waitUntilAvailable().isAvailable();
    }

    public AdminPage loginAs(String username, String password) {
        userName.sendKeys(username);
        getPasswordInput().inputText(password);
        String capcha = Capchainput();
        getCapchaInput().inputText(capcha);
        getLoginButton().click();
        return new AdminPage(driver);
    }

    private TextInput getUsernameInput() {
        return new TextInput(driver, By.id("uname"));
    }

    private TextInput getPasswordInput() {

        return new TextInput(driver, By.id("pass"));
    }

    private TextInput getCapchaInput() {
        return new TextInput(driver, By.id("calc"));
    }

    private Button getLoginButton() {
        return new Button(driver, By.id("submit"));
    }

    private String Capchainput() {
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
