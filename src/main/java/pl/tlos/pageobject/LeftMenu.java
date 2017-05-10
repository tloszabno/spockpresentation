package pl.tlos.pageobject;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tlos
 */
public class LeftMenu {
    private List<MenuItem> items;

    private String title;

    private LeftMenu(Builder builder) {
        this.items = builder.items;
        this.title = builder.title;
    }

    public List<MenuItem> getItems() {
        return items;
    }

    @Override
    public String toString() {
        return "LeftMenu{" + "items=" + items + ", title='" + title + '\'' + '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private List<MenuItem> items = new ArrayList<MenuItem>();

        private String title;

        public LeftMenu buildDummy() {
            return new LeftMenu(this);
        }

        public Builder titled(String title) {
            this.title = title;
            return this;
        }

        public Builder withItem(String title, String url) {
            this.items.add(new MenuItem(title,url));
            return this;
        }
    }
}
