package Core.Entity;

/**
 * Created by Admin on 07-Jul-17.
 */
public class Category {

    private int id;
    private String name;
    private String selftitle;
    private String description;
    private boolean publisdhed;
    private int catorder;
    private int subcat;

    public Category(int id, String name, String selftitle, String description, boolean publisdhed, int catorder, int subcat) {
        this.id = id;
        this.name = name;
        this.selftitle = selftitle;
        this.description = description;
        this.publisdhed = publisdhed;
        this.catorder = catorder;
        this.subcat = subcat;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSelftitle() {
        return selftitle;
    }

    public String getDescription() {
        return description;
    }

    public boolean isPublisdhed() {
        return publisdhed;
    }

    public int getCatorder() {
        return catorder;
    }

    public int getSubcat() {
        return subcat;
    }
}
