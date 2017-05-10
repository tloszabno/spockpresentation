package pl.tlos.pageobject;

import static java.util.Arrays.asList;

import java.util.List;

/**
 * @author tlos
 */
public class RightContent {
    private List<WebElement> elements;

    private String title;

    private String error;

    public List<WebElement> getElements() {
        return elements;
    }

    public String getError() {
        return error;
    }

    public String getTitle() {
        return title;
    }

    public static RightContent ofElements(WebElement... webElements) {
        RightContent content = new RightContent();
        content.elements = asList(webElements);
        return content;
    }

    public RightContent titled(String title) {
        this.title = title;
        return this;
    }

    public RightContent withError(String error) {
        this.error = error;
        return this;
    }

    @Override
    public String toString() {
        return "RightContent{" + "elements=" + elements + ", title='" + title + '\'' + ", error='" + error + '\'' + '}';
    }
}
