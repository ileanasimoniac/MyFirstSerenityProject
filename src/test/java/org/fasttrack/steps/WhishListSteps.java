package org.fasttrack.steps;

import net.thucydides.core.annotations.Step;
import org.fasttrack.pages.AccountPage;
import org.fasttrack.pages.HomePage;
import org.fasttrack.pages.LoginPage;
import org.fasttrack.pages.WhishListPage;
import org.junit.Assert;

public class WhishListSteps {

    private AccountPage accountPage;
    private HomePage homePage;
    private LoginPage loginPage;
    private WhishListPage whishListPage;

    @Step
    public void navigateToLoginPage(){
        homePage.open();
        homePage.clickAccount();
        homePage.clickLoginLink();
    }

    @Step
    public void performLogin(String email, String pass){
        loginPage.setEmailField(email);
        loginPage.setPassField(pass);
        loginPage.clickLoginButton();
    }

    @Step
    public void navigateToWishList(){
        whishListPage.open();
    }

    @Step
    public void checkIfIsInWishlist(){
        whishListPage.verifyIsInWishList();
    }

}
