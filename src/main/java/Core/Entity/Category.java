package Core.Entity;

/**
 * Created by Admin on 07-Jul-17.
 */
public class Category {

    private int id;
    private String name;
    private String seftitle;
    private String description;
    private boolean published;
    private int catorder;
    private int subcat;

    public Category(){}

    public Category(int id, String name, String selftitle, String description, boolean published, int catorder, int subcat) {
        this.id = id;
        this.name = name;
        this.seftitle = selftitle;
        this.description = description;
        this.published = published;
        this.catorder = catorder;
        this.subcat = subcat;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSeftitle() {
        return seftitle;
    }

    public String getDescription() {
        return description;
    }

    public boolean isPublished() {
        return published;
    }

    public int getCatorder() {
        return catorder;
    }

    public int getSubcat() {
        return subcat;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", selftitle='" + seftitle + '\'' +
                ", description='" + description + '\'' +
                ", published=" + published +
                ", catorder=" + catorder +
                ", subcat=" + subcat +
                '}';
    }
}
