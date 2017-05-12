package pl.tlos.pageobject;

/**
 * @author tlos
 */
public final class MainPage {
    private LeftMenu leftMenu;

    private RightContent rightContent;

    private MainPage(Builder builder) {
        this.leftMenu = builder.leftMenu;
        this.rightContent = builder.rightContent;
    }

    public static Builder builder() {
        return new Builder();
    }

    public LeftMenu getLeftMenu() {
        return leftMenu;
    }

    public RightContent getRightContent() {
        return rightContent;
    }

    public boolean hasMenu() {
        return leftMenu != null;
    }

    @Override
    public String toString() {
        return "MainPage{" + "hasLeftMenu=" + hasMenu()+ ", rightContent=" + (rightContent != null ? rightContent.getTitle() : "null") + '}';
    }

    public static class Builder {
        private LeftMenu leftMenu;

        private RightContent rightContent;

        public Builder withoutMenu() {
            this.leftMenu = null;
            return this;
        }

        public Builder withRightContent(RightContent rightContent) {
            this.rightContent = rightContent;
            return this;
        }

        public MainPage buildDummy() {
            return new MainPage(this);
        }

        public Builder withMenu(LeftMenu menu) {
            this.leftMenu = menu;
            return this;
        }

    }
}
