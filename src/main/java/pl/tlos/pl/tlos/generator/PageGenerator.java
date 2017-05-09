package pl.tlos.pl.tlos.generator;

import static pl.tlos.pageobject.RightContent.ofElements;

import pl.tlos.pageobject.LeftMenu;
import pl.tlos.pageobject.MainPage;
import pl.tlos.pageobject.WebElement;

/**
 * @author tlos
 */
public class PageGenerator {

    public static MainPage createEmptyPageAfterLogin() {
        return MainPage.builder()
                .withMenu(standardMenu())
                .buildDummy();
    }

    public static MainPage createPageWithSomeUserList() {
        return MainPage.builder()
                .withMenu(standardMenu())
                .withRightContent(ofElements(//
                        userRowElement("admin"), //
                        userRowElement("test"), //
                        userRowElement("root")//
                ))
                .buildDummy();
    }

    private static LeftMenu standardMenu() {
        return LeftMenu.builder()
                .titled("App")
                .withItem("Users", "users.html")
                .withItem("Roles", "roles.html")
                .withItem("Settings", "settings.html")
                .buildDummy();
    }

    public static MainPage createLoginPage() {
        return MainPage.builder()
                .withoutMenu()
                .withRightContent(ofElements(loginElement(), passwordElement()).titled("Login Page"))
                .buildDummy();
    }

    private static WebElement loginElement() {
        return new WebElement("login");
    }

    private static WebElement userRowElement(String login) {
        return new WebElement(login);
    }

    private static WebElement passwordElement() {
        return new WebElement("password");
    }

    public static MainPage createLoginErrorPage() {
        return MainPage.builder()
                .withoutMenu()
                .withRightContent(//
                        ofElements(loginElement(), passwordElement()).titled("Login Page")
                                .withError("Login or password is wrong"))
                .buildDummy();
    }
}
