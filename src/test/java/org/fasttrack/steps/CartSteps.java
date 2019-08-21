package org.fasttrack.steps;

import net.thucydides.core.annotations.Step;
import org.fasttrack.pages.CartPage;
import org.fasttrack.pages.SearchPage;
import org.openqa.selenium.WebDriver;

public class CartSteps {

    private CartPage cartPage;

    @Step
    public void addProductsToCartAndAssertTotal(WebDriver driver){
        addProductToCart(driver, 0);
        addProductToCart(driver, 1);
        addProductToCart(driver, 2);
        cartPage.verifyIfCartTotalIsCorrect();
    }

    private void addProductToCart(WebDriver driver, Integer index) {
        driver.get("https://fasttrackit.org/selenium-test/accessories/jewelry.html");
        cartPage.selectProducts();
        cartPage.addProductToCart(index);
    }

}
