package pl.tlos.pageobject;

/**
 * @author tlos
 *
 */
public class MenuItem {
    private String title;
    private String url;

    public MenuItem(String title, String url) {
        this.title = title;
        this.url = url;
    }

    @Override
    public String toString() {
        return "MenuItem{" + "title='" + title + '\'' + '}';
    }
}
