package Web.WebPages;

import Web.WebElements.Button;
import Web.WebElements.TextInput;
import Web.WebPage;
import io.qameta.allure.Step;
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
    WebElement userName;

    @FindBy(id = "pass")
    WebElement userPassword;

    @FindBy(id = "calc")
    WebElement capchaInput;

    @FindBy(id = "submit")
    WebElement submitButton;

    private static By USER_NAME_INPUT = By.id("uname");
    private static By USER_PASSWORD_INPUT = By.id("pass");
    private static By USER_CAPCHA_INPUT = By.id("calc");
    private static By SUBMIT_BUTTON = By.id("submit");
    private static By CAPCHA_TEXT = By.xpath(".//*[@id='post']/p[4]");

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    @Step("Load Login page.")
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

    @Step("Login with user_name={username} and password={password}.")
    public AdminPage loginAs(String username, String password) {
        userName.sendKeys(username);
        userPassword.sendKeys(password);
        String capcha = Capchainput();
        capchaInput.sendKeys(capcha);
        submitButton.click();
        return new AdminPage(driver);
    }

    private TextInput getUsernameInput() {
        return new TextInput(driver, USER_NAME_INPUT);
    }

    private TextInput getPasswordInput() {

        return new TextInput(driver, USER_PASSWORD_INPUT);
    }

    private TextInput getCapchaInput() {
        return new TextInput(driver, USER_CAPCHA_INPUT);
    }

    private Button getLoginButton() {
        return new Button(driver, SUBMIT_BUTTON);
    }

    private String Capchainput() {
        String result = null;
        WebElement elemnt = driver.findElement(CAPCHA_TEXT);
        String expression = elemnt.getText();
        char splitedExpression[] = expression.toCharArray();
        int a = Integer.valueOf(String.valueOf(splitedExpression[splitedExpression.length - 3]));
        int b = Integer.valueOf(String.valueOf(splitedExpression[splitedExpression.length - 7]));
        int sum = a + b;
        result = String.valueOf(sum);
        return result;
    }

}
