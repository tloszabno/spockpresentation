package pl.tlos.groovy

import org.junit.Before
import org.junit.Ignore
import org.junit.Test
import pl.tlos.browser.Browser
import pl.tlos.pageobject.WebElement

import static org.assertj.core.api.BDDAssertions.then

/**
 * @author tlos
 *
 */
class LoginTestGroovy {

    Browser browser

    @Before
    void init() {
        browser = new Browser();
    }

    @Test
    void shouldShowLoginScreen() {
        then(browser.currentPage.rightContent.elements*.getTitle()).contains("login", "password")
    }
    @Test
    void shouldFindLoginWebElement() {
        def element = browser.currentPage.rightContent.elements*.find( {el -> el.title == "login"} )
        //do something other with element
        then(element).isNotNull()
    }

    @Test
    @Ignore
    void shouldShowLoginScreenTitle_nullHandling() {
        then(browser.getCurrentPageNull()?.rightContent?.title).isEqualTo("Login page")
    }


}
