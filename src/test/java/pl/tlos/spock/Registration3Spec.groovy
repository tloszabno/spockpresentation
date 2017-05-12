package pl.tlos.spock

import pl.tlos.browser.Browser
import spock.lang.*

@Title("Registration Page Specification")
@Narrative('''As a guest I want to register to Application''')
class Registration3Spec extends Specification {

    @Subject
    Browser browser = new Browser()

    def "Should show error message when wrong registration data entered"() {
        given: "Registration page"
        "Registration page"()

        when: "Guest enters login, password  and repeated password"
        "Login input"() enterText login
        "Password input"() enterText password
        "RepeatedPassword input"() enterText repeated_password
        and: "Submits page"
        browser.clickSubmit()

        then: "proper error message is shown"
        browser.currentPage.rightContent.error == expected_message

        where:
        login  | password | repeated_password | expected_message
        "1"    | "1234"   | "1234"            | "Login is to short"
        "test" | "123"    | "1234"            | "Passwords do not match"
        "test" | "1234"   | "1234"            | "Password is too weak"
    }


    def "Registration page"() {
        browser.goToRegistration()
    }

    def "Login input"() {
        browser.currentPage.rightContent.elements.find({ it -> it.title == "login" })
    }

    def "Password input"() {
        browser.currentPage.rightContent.elements.find({ it -> it.title == "password" })
    }

    def "RepeatedPassword input"() {
        browser.currentPage.rightContent.elements.find({ it -> it.title == "passwordRepeat" })
    }
}
