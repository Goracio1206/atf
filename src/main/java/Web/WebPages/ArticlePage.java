package Web.WebPages;

import Core.BaseTest;
import Core.Entity.Article;
import Web.WebPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ArticlePage extends WebPage<ArticlePage> {

    @FindBy(xpath = ".//*[@id='main']/h2")
    private WebElement topicTitle;

    @FindBy(xpath = ".//*[@id='main']/p[1]")
    private WebElement topicDate;

    @FindBy(xpath = ".//*[@id='main']" )
    WebElement topic;

   public ArticlePage( WebDriver driver){
       super(driver);
       PageFactory.initElements(driver, this);
   }

    public Article getArticleFromPage() throws InterruptedException {
        String text = getTextFromTitle();
        return new Article( topicTitle.getText(), text, topicDate.getText());
    }

    private String getTextFromTitle() {
        String text[] = topic.getText().split("\\n");
        return text[1];
    }

    @Override
    public boolean isAvailable() {
        return false;
    }

    @Override
    public ArticlePage load() {
        return this;
    }

}
