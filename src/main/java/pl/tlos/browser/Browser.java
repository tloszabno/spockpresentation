package pl.tlos.browser;

import pl.tlos.pageobject.MainPage;
import pl.tlos.pl.tlos.generator.PageGenerator;

import static pl.tlos.pl.tlos.generator.PageGenerator.*;

/**
 * Emulate some dummy browser behaviour
 * @author tlos
 */
public class Browser {
    private MainPage currentPage;

    private boolean logged;

    public Browser() {
        this.currentPage = createLoginPage();
    }


    public MainPage getCurrentPage() {
        return currentPage;
    }

    public MainPage getCurrentPageNull() {
        return null;
    }

    public void clickSubmit(){
        if(!logged && "Login Page".equals(currentPage.getRightContent().getTitle())){
            tryToLogin();
        }
        else if( "Registration Page".equals(currentPage.getRightContent().getTitle())){
            tryToRegister();
        }
    }


    private void tryToLogin() {
        String login = currentPage.getRightContent()
                .getElements()
                .get(0)
                .getText();
        String password = currentPage.getRightContent()
                .getElements()
                .get(1)
                .getText();

        if( "1234".equals(password) && "admin".equals(login) ) {
            currentPage = createEmptyPageAfterLogin();
            logged = true;
        }else{
            currentPage = createLoginErrorPage();
        }
    }


    private void tryToRegister() {
        String login = currentPage.getRightContent()
                .getElements()
                .get(0)
                .getText();
        String password = currentPage.getRightContent()
                .getElements()
                .get(1)
                .getText();
        String repeatedPassword = currentPage.getRightContent()
                .getElements()
                .get(2)
                .getText();

        if( login.length() < 4){
            currentPage = PageGenerator.createRegistrationPageWithError("Login is to short");
            return;
        }
        if( !password.equals(repeatedPassword)){
            currentPage = PageGenerator.createRegistrationPageWithError("Passwords do not match");
            return;
        }
        if( password.length() < 10){
            currentPage = PageGenerator.createRegistrationPageWithError("Password is too weak");
            return;
        }
    }

    public void clickOnUsers(){
        currentPage = createPageWithSomeUserList();
    }

    public void goToRegistration(){
        currentPage = createRegistrationPage();
    }

    @Override
    public String toString() {
        return "Browser{name=Chrome " + "userLogged=" + logged + '}';
    }
}
