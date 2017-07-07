package Core.DB;

import Core.Entity.Article;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

/**
 * Created by Admin on 07-Jul-17.
 */
public class SelectByName {
    final String USERNAME = "root";
    final String USERPASSWORD = "root";
    final String URL = "jdbc:mysql://localhost:3306/snews17";

    public Article selectArticle(String articleName) throws SQLException {
        Article article  = null;

//        try{
//            Class.forName("com.mysql.jdbc.Driver");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }

        DBConnector db = new DBConnector();
        Connection connection = db.getConnection(URL, USERNAME, USERPASSWORD);

        String query = "select * from articles WHERE title= ? and category > 0";
        PreparedStatement statement = connection.prepareStatement(query);

        statement.setString(1, articleName);
        ResultSet result = statement.executeQuery();

         int id;
        String title;
        String seftitle;
        String text;
        String date;
        int category;
        int position;
        String extraid;
        String page_extra;
        boolean displaytitle;
        boolean displayinfo;
        boolean commentable;
        int published;
        String description_meta;
        String keyword_meta;
        boolean show_on_home;
        boolean show_in_subcats;
        int artorder;
        boolean visible;
        boolean default_page;

        while(result.next()){
            id = result.getInt("id");
            title = result.getString("title");
            seftitle = result.getString("seftitle");
            text = result.getString("text");
            date = result.getString("date");
            category = result.getInt("category");
            position = result.getInt("position");
            extraid = result.getString("extraid");
            page_extra = result.getString("page_extra");
            displayinfo = result.getBoolean("displayinfo");
            displaytitle = result.getBoolean("displaytitle");
            commentable = result.getBoolean("commentable");
            published = result.getInt("published");
            description_meta = result.getString("description_meta");
            keyword_meta = result.getString("keyword_meta");
            show_on_home = result.getBoolean("show_on_home");
            show_in_subcats = result.getBoolean("show_on_subcats");
            artorder = result.getInt("artorder");
            visible = result.getBoolean("visible");
            default_page = result.getBoolean("default_page");

            article = new Article(id, title, seftitle, text, date, category, position, extraid, page_extra, displayinfo, displaytitle,
                    commentable, published, description_meta, keyword_meta, show_on_home, show_in_subcats, artorder, visible, default_page);
        }

        statement.close();
        connection.close();

        System.out.println(article);

        return article;
    }

    public static void main(String[] args) throws SQLException {
        new SelectByName().selectArticle("Hello");
    }
}
