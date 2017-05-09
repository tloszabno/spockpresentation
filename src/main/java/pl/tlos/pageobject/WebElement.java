package pl.tlos.pageobject;

/**
 * @author tlos
 */
public class WebElement {
    private  String title;
    private String text;

    public WebElement(String title, String text) {
        this.title = title;
        this.text = text;
    }
    public WebElement(String title) {
        this.title = title;
        this.text = "";
    }

    public void enterText(String text){
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public String getTitle() {
        return title;
    }
}
