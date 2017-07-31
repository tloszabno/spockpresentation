package pl.tlos.spock

import pl.tlos.browser.Browser
import spock.lang.Specification
import spock.lang.Title
import spock.lang.Unroll

@Title("Registration page specification")
class Registration2Spec extends Specification{
    Browser browser = new Browser()


    @Unroll
    def "Should not register when passwords not match"() {
        given:
        'Registration page'()
        def repeatedPassword = "1"

        when:
        entered login: "valid", password: "123", repeated_password: repeatedPassword

        and:
        'submit clicked'()

        then:
        'shown error'() == "Passwords do not match"

    }


    def "Browser current page should be set"(){
        expect:
        browser.currentPage != null
    }

    def entered(params) {
        browser.currentPage.rightContent.elements.find({ it -> it.title == "login" }).enterText params.login
        browser.currentPage.rightContent.elements.find({ it -> it.title == "password" }).enterText params.password
        browser.currentPage.rightContent.elements.find({ it -> it.title == "passwordRepeat" }).enterText params.repeated_password
    }
    def 'submit clicked'() {
        browser.clickSubmit()
    }
    private String 'shown error'() {
        browser.currentPage.rightContent.error
    }

    def 'Registration page'() {
        browser.goToRegistration()
    }
}
