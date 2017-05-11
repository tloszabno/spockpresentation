package pl.tlos.spock

import pl.tlos.browser.Browser
import spock.lang.Specification
import spock.lang.Title
import spock.lang.Unroll

@Title("Registration Page Specification")
class RegistrationSpec extends Specification {

    Browser browser = new Browser()


    @Unroll
    def "Should show error '#expected_message' for user: '#login', password: '#password' and repeated password: '#repeated_password'"() {
        given:
        "Registration page"()

        when:
        "Login input"() enterText login
        "Password input"() enterText password
        "RepeatedPassword input"() enterText repeated_password
        and:
        browser.clickSubmit()

        then:
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
