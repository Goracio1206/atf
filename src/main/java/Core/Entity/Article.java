package Core.Entity;

import java.util.Calendar;

/**
 * Created by Admin on 07-Jul-17.
 */
public class Article {
    private int id;
    private String title;
    private String selftitle;
    private String text;
    private Calendar date;
    private int category;
    private int position;
    private String extradid;
    private String page_extra;
    private boolean displaytitle;
    private boolean displayinfo;
    private boolean commentable;
    private int published;
    private String description_meta;
    private String keyword_meta;
    private boolean show_on_home;
    private boolean show_in_subcats;
    private int artorder;
    private boolean visibdle;
    private boolean default_page;

    public Article(int id, String title, String selftitle, String text, Calendar date, int category, int position, String extradid, String page_extra, boolean displaytitle, boolean displayinfo, boolean commentable, int published, String description_meta, String keyword_meta, boolean show_on_home, boolean show_in_subcats, int artorder, boolean visibdle, boolean default_page) {
        this.id = id;
        this.title = title;
        this.selftitle = selftitle;
        this.text = text;
        this.date = date;
        this.category = category;
        this.position = position;
        this.extradid = extradid;
        this.page_extra = page_extra;
        this.displaytitle = displaytitle;
        this.displayinfo = displayinfo;
        this.commentable = commentable;
        this.published = published;
        this.description_meta = description_meta;
        this.keyword_meta = keyword_meta;
        this.show_on_home = show_on_home;
        this.show_in_subcats = show_in_subcats;
        this.artorder = artorder;
        this.visibdle = visibdle;
        this.default_page = default_page;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getSelftitle() {
        return selftitle;
    }

    public String getText() {
        return text;
    }

    public Calendar getDate() {
        return date;
    }

    public int getCategory() {
        return category;
    }

    public int getPosition() {
        return position;
    }

    public String getExtradid() {
        return extradid;
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

    public String getKeyword_meta() {
        return keyword_meta;
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
        return visibdle;
    }

    public boolean isDefault_page() {
        return default_page;
    }
}
