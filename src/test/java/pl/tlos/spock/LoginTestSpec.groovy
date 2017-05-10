package pl.tlos.spock

import pl.tlos.browser.Browser
import spock.lang.Specification

class LoginTestSpec extends Specification {

    Browser browser = new Browser()
    def loginBox = browser.currentPage.rightContent.elements.find({ it -> it.title == "login" })
    def passwordBox = browser.currentPage.rightContent.elements.find({ it -> it.title == "password" })

    def "Should show left menu after login"() {
        given:
        def login = "admin"
        def password = "1234"

        when:
        loginBox.enterText login
        passwordBox.enterText password
        and:
        browser.clickSubmit()

        then:
        browser.currentPage.hasMenu()
    }

    def "Menu should contains Users"() {
        given:
        "logged user"()

        when:
        def currentPage = browser.getCurrentPage()

        then:
        "User" in currentPage.leftMenu.items*.title
    }

    def "logged user"(){
        def login = "admin"
        def password = "1234"
        loginBox.enterText login
        passwordBox.enterText password
        browser.clickSubmit()
    }

}
