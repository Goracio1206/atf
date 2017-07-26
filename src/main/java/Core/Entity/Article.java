package Core.Entity;

import Core.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by Admin on 07-Jul-17.
 */
public class Article extends BaseTest {
    private int id;
    private String title;
    private String seftitle;
    private String text;
    private String date;
    private int category;
    private int position;
    private String extraid;
    private String page_extra;
    private boolean displaytitle;
    private boolean displayinfo;
    private boolean commentable;
    private int published;
    private String description_meta;
    private String keywords_meta;
    private boolean show_on_home;
    private boolean show_in_subcats;
    private int artorder;
    private boolean visible;
    private boolean default_page;

    public Article(){}

    public Article(String title, String text, String date){
        this.title = title;
        this.text = text;
        this.date = date;
    }

    public Article(int id, String title, String seftitle, String text, String date, int category, int position, String extradid, String page_extra, boolean displaytitle, boolean displayinfo, boolean commentable, int published, String description_meta, String keyword_meta, boolean show_on_home, boolean show_in_subcats, int artorder, boolean visibdle, boolean default_page) {
        this.id = id;
        this.title = title;
        this.seftitle = seftitle;
        this.text = text;
        this.date = date;
        this.category = category;
        this.position = position;
        this.extraid = extradid;
        this.page_extra = page_extra;
        this.displaytitle = displaytitle;
        this.displayinfo = displayinfo;
        this.commentable = commentable;
        this.published = published;
        this.description_meta = description_meta;
        this.keywords_meta = keyword_meta;
        this.show_on_home = show_on_home;
        this.show_in_subcats = show_in_subcats;
        this.artorder = artorder;
        this.visible = visibdle;
        this.default_page = default_page;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getSeftitle() {
        return seftitle;
    }

    public String getText() {
        return text;
    }

    public String getDate() {
        return date;
    }

    public int getCategory() {
        return category;
    }

    public int getPosition() {
        return position;
    }

    public String getExtradid() {
        return extraid;
    }

    public String getPage_extra() {
        return page_extra;
    }

    public boolean isDisplaytitle() {
        return displaytitle;
    }

    public boolean isDisplayinfo() {
        return displayinfo;
    }

    public boolean isCommentable() {
        return commentable;
    }

    public int getPublished() {
        return published;
    }

    public String getDescription_meta() {
        return description_meta;
    }

    public String getKeywords_meta() {
        return keywords_meta;
    }

    public boolean isShow_on_home() {
        return show_on_home;
    }

    public boolean isShow_in_subcats() {
        return show_in_subcats;
    }

    public int getArtorder() {
        return artorder;
    }

    public boolean isVisibdle() {
        return visible;
    }

    public boolean isDefault_page() {
        return default_page;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", seftitle='" + seftitle + '\'' +
                ", text='" + text + '\'' +
                ", date='" + date + '\'' +
                ", category=" + category +
                ", position=" + position +
                ", extraid='" + extraid + '\'' +
                ", page_extra='" + page_extra + '\'' +
                ", displaytitle=" + displaytitle +
                ", displayinfo=" + displayinfo +
                ", commentable=" + commentable +
                ", published=" + published +
                ", description_meta='" + description_meta + '\'' +
                ", keywords_meta='" + keywords_meta + '\'' +
                ", show_on_home=" + show_on_home +
                ", show_in_subcats=" + show_in_subcats +
                ", artorder=" + artorder +
                ", visible=" + visible +
                ", default_page=" + default_page +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Article article = (Article) o;

        if (id != article.id) return false;
        if (category != article.category) return false;
        if (position != article.position) return false;
        if (displaytitle != article.displaytitle) return false;
        if (displayinfo != article.displayinfo) return false;
        if (commentable != article.commentable) return false;
        if (published != article.published) return false;
        if (show_on_home != article.show_on_home) return false;
        if (show_in_subcats != article.show_in_subcats) return false;
        if (artorder != article.artorder) return false;
        if (visible != article.visible) return false;
        if (default_page != article.default_page) return false;
        if (!title.equals(article.title)) return false;
        if (!seftitle.equals(article.seftitle)) return false;
        if (!text.equals(article.text)) return false;
        if (!date.equals(article.date)) return false;
        if (!extraid.equals(article.extraid)) return false;
        if (!page_extra.equals(article.page_extra)) return false;
        if (!description_meta.equals(article.description_meta)) return false;
        return keywords_meta.equals(article.keywords_meta);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + title.hashCode();
        result = 31 * result + seftitle.hashCode();
        result = 31 * result + text.hashCode();
        result = 31 * result + date.hashCode();
        result = 31 * result + category;
        result = 31 * result + position;
        result = 31 * result + extraid.hashCode();
        result = 31 * result + page_extra.hashCode();
        result = 31 * result + (displaytitle ? 1 : 0);
        result = 31 * result + (displayinfo ? 1 : 0);
        result = 31 * result + (commentable ? 1 : 0);
        result = 31 * result + published;
        result = 31 * result + description_meta.hashCode();
        result = 31 * result + keywords_meta.hashCode();
        result = 31 * result + (show_on_home ? 1 : 0);
        result = 31 * result + (show_in_subcats ? 1 : 0);
        result = 31 * result + artorder;
        result = 31 * result + (visible ? 1 : 0);
        result = 31 * result + (default_page ? 1 : 0);
        return result;
    }
}
