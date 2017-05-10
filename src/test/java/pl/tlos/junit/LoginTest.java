package pl.tlos.junit;

import static java.util.Optional.ofNullable;
import static org.assertj.core.api.BDDAssertions.then;

import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import pl.tlos.browser.Browser;
import pl.tlos.pageobject.MainPage;
import pl.tlos.pageobject.RightContent;
import pl.tlos.pageobject.WebElement;

/**
 * @author tlos
 */
public class LoginTest {

    Browser browser;

    @Before
    public void init() {
        browser = new Browser();
    }

    @Test
    public void shouldShowLoginScreen_v1() {
        // when
        List<WebElement> elementsInContent = browser.getCurrentPage()
                .getRightContent()
                .getElements();

        // then
        then(elementsInContent).hasSize(2);
        then(elementsInContent.get(0)
                .getTitle()).isEqualTo("login");
        then(elementsInContent.get(1)
                .getTitle()).isEqualTo("password");
    }

    @Test
    public void shouldShowLoginScreen_BDD() {
        // when
        List<WebElement> elementsInContent = browser.getCurrentPage()
                .getRightContent()
                .getElements();

        // then
        then(elementsInContent).extracting("title")
                .containsExactly("login", "password");
    }

    @Test
    public void shouldShowLoginScreenTitle_nullHandling() {
        // when
        String title = browser.getCurrentPageNull() // NULL
                .getRightContent()
                .getTitle();

        // then
        then(title).isEqualTo("Login Page");
    }

    @Test
    public void shouldShowLoginScreenTitle_nullHandling_v2() {
        // when
        String title = null;
        MainPage currentPage = browser.getCurrentPageNull();
        if ( currentPage != null ) {
            RightContent rightContent = currentPage.getRightContent();
            if ( rightContent != null ) {
                title = rightContent.getTitle();
            }
        }

        // then
        then(title).isEqualTo("Login Page");
    }

    @Test
    public void shouldShowLoginScreenTitle_nullHandling_jdk8() {
        String title = ofNullable(browser.getCurrentPageNull())//
                .map(mainPage -> mainPage.getRightContent())
                .map(content -> content.getTitle())
                .orElse(null);
        then(title).isEqualTo("Login page");
    }

}

