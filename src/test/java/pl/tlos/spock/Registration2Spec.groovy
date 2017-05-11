package pl.tlos.spock

import pl.tlos.browser.Browser
import spock.lang.Specification

class Registration2Spec extends Specification{
    Browser browser = new Browser()


    def "Should not register when passwords not match"() {
        given:
        "Registration page"()

        when:
        enter login: "valid", password: "123", repeated_password: "1"

        and:
        "submit clicked"()

        then:
        'shown error'() == "Passwords do not match"

    }

    def enter(params) {
        browser.currentPage.rightContent.elements.find({ it -> it.title == "login" }).enterText params.login
        browser.currentPage.rightContent.elements.find({ it -> it.title == "password" }).enterText params.password
        browser.currentPage.rightContent.elements.find({ it -> it.title == "passwordRepeat" }).enterText params.repeated_password
    }
    def "submit clicked"() {
        browser.clickSubmit()
    }
    private String 'shown error'() {
        browser.currentPage.rightContent.error
    }

    def "Registration page"() {
        browser.goToRegistration()
    }
}
