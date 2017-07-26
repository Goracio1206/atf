package com.tools.atf.test.Test;

import Core.BaseTest;
import Core.DB.SelectByName;
import Core.Entity.Article;
import Web.WebPages.ArticlePage;
import Web.WebPages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.SQLException;

import static Core.TestData.*;

public class TheSameArticleInDBandPageTest extends BaseTest {


    @Test(alwaysRun = true)
    public void TheSameArticleInDBandPageTest() throws SQLException, InterruptedException {
        new HomePage(driver).loadAndWaitUntilAvailable().findTopicByNameAndOpen(TOPIC_NAME_Vitalii1_1508637454);
        Article fromPage = new ArticlePage(driver).getArticleFromPage();
        Article fromDB = new SelectByName().selectArticle(TOPIC_NAME_Vitalii1_1508637454);
        Assert.assertEquals(fromPage.getTitle(), fromDB.getTitle());
        Assert.assertEquals(fromPage.getText(), fromDB.getText());
    }
}
