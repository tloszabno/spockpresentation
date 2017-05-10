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
        browser = new Browser()
    }

    @Test
    void shouldShowLoginScreen() {
        def elementsOnPage = browser.currentPage.rightContent.elements*.getTitle()
        assert "login" in elementsOnPage
        assert "password" in elementsOnPage
    }

    @Test
    void shouldShowLoginScreen_BDD() {
        then(browser.currentPage.rightContent.elements*.getTitle()).contains("login", "password")
    }


    @Test
    void shouldFindLoginWebElement() {
        def element = browser.currentPage.rightContent.elements*.find( {el -> el.title == "login"} )
        //do something other with element
        then(element).isNotNull()
    }

    @Test
    void shouldShowLoginScreenTitle_nullHandling() {
        assert "Login page" == browser.getCurrentPageNull()?.rightContent?.title
    }



    def "login screen should be visible on start"(){
        WebElement element = browser.currentPage.rightContent.elements*.find( {el -> el.title == "login"} )

        then(element.text).isEqualTo("Login")
        //vs
        then element.text isEqualTo "Login"
    }


}
