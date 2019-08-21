package org.fasttrack.pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.junit.Assert;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;
import java.util.Locale;

@DefaultUrl("https://fasttrackit.org/selenium-test/checkout/cart/")
public class CartPage extends PageObject {


    @FindBy(css = "#shopping-cart-totals-table tbody span.price")
    private WebElementFacade cartTotalElement;


    private List<WebElementFacade> products;

    private Double sum = 0.00;

    public void selectProducts() {
        products = findAll(".products-grid > li");
    }

    public void addProductToCart(Integer index) {
        sum = sum + getProductPrice(index).doubleValue();
        products.get(index).findElement(By.className("btn-cart")).click();
    }


    private Number getProductPrice(Integer index) {
        try {
            NumberFormat format = NumberFormat.getInstance(Locale.FRANCE);
            return format.parse(products.get(index).findElement(By.className("price")).getText().replace(" RON", ""));
        } catch (ParseException exception) {
            return 0;
        }
    }

    private Number getCartTotal() {
        try {
            NumberFormat format = NumberFormat.getInstance(Locale.FRANCE);
            return format.parse(cartTotalElement.getText().replace(" RON", ""));
        } catch (ParseException exception) {
            return 0;
        }
    }

    public void verifyIfCartTotalIsCorrect() {
        Assert.assertTrue("Total is correct", getCartTotal().doubleValue() == sum);
    }
}
