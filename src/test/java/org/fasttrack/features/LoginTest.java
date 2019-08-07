package org.fasttrack.features;


import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.fasttrack.steps.LoginSteps;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class LoginTest {

    @Managed(uniqueSession = true)
    private   WebDriver driver;

    @Before
    public  void maximiseWindow(){
        driver.manage().window().maximize();
    }


    @Steps
    private LoginSteps loginSteps;


    private String userEmail = "cosmin@fasttrackit.org";
    private String userPass = "123456";
    private String userName = "asdasda asdasd";

    @Test
    public void validLoginTest() {
        loginSteps.navigateToLoginPage();
        loginSteps.performLogin(userEmail, userPass);
        loginSteps.checkLoggedIn(userName);
    }

    @Test
    public void invalidLoginTest() {
        loginSteps.navigateToLoginPage();
        loginSteps.performLogin(userEmail, "aaaaaaaaa");
        loginSteps.checkNotLoggedIn();
    }


}
