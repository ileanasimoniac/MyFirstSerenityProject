package org.fasttrack.features;


import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.fasttrack.steps.LoginSteps;
import org.fasttrack.steps.WhishListSteps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class WhishlistTest {

    @Managed(uniqueSession = true)
    private   WebDriver driver;

    @Before
    public  void maximiseWindow(){
        driver.manage().window().maximize();
    }


    @Steps
    private WhishListSteps whishListSteps;


    private String userEmail = "cosmin@fasttrackit.org";
    private String userPass = "123456";
    private String userName = "asdasda asdasd";

    @Test
    public void validWhishList() {
        whishListSteps.navigateToLoginPage();
        whishListSteps.performLogin(userEmail, userPass);
        whishListSteps.checkIfIsInWishlist();
    }

}
