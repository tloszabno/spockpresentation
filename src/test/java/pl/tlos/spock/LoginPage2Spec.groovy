package pl.tlos.spock

import pl.tlos.browser.Browser
import spock.lang.Issue
import spock.lang.Narrative
import spock.lang.Specification
import spock.lang.Subject
import spock.lang.Title

@Title('Login Page Specification')
@Narrative('''
    As a User I want to login to application
''')
class LoginPage2Spec extends Specification {

    @Subject
    Browser browser = new Browser()
    def loginBox = browser.currentPage.rightContent.elements.find({ it -> it.title == "login" })
    def passwordBox = browser.currentPage.rightContent.elements.find({ it -> it.title == "password" })

    @Issue("http://some.fatcat.customer.jira.com/issue?title=menu_not_visible_after_login.html")
    def "Should show left menu after login"() {

        given: "User admin with password 1234"
        def login = "admin"
        def password = "1234"

        when: "User enters login, password"
        loginBox.enterText login
        passwordBox.enterText password
        and: "Submits page"
        browser.clickSubmit()

        then: "Left menu is visible"
        browser.currentPage.hasMenu()
    }
}

