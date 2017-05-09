package pl.tlos.browser;

import static pl.tlos.pl.tlos.generator.PageGenerator.createEmptyPageAfterLogin;
import static pl.tlos.pl.tlos.generator.PageGenerator.createLoginPage;
import static pl.tlos.pl.tlos.generator.PageGenerator.createPageWithSomeUserList;
import static pl.tlos.pl.tlos.generator.PageGenerator.createLoginErrorPage;

import pl.tlos.pageobject.MainPage;

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
        else{
            //if necessary add error that user is not logged
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

    public void clickOnUsers(){
        currentPage = createPageWithSomeUserList();
    }

}
