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

@DefaultUrl("https://fasttrackit.org/selenium-test/")
public class SearchPage extends PageObject {

    @FindBy(id = "search")
    private WebElementFacade searchInput;

    @FindBy(css = "button.search-button")
    private WebElementFacade searchButton;

    @FindBy(css = "products-grid")
    private WebElementFacade productGrid;

    @FindBy(css = ".sort-by > select")
    private WebElementFacade sortBy;

    private List<WebElementFacade> products;

    public void setSearchInput(String search) {
        typeInto(searchInput, search);
    }

    public void sortByPrice() {
        sortBy.selectByIndex(2);
    }

    public void clickSearchButton() {
        clickOn(searchButton);
    }

    public void selectProducts() {
        products = findAll(".products-grid > li");
    }

    private boolean searchProduct(String productTitle) {
        boolean exists = false;
        for (WebElementFacade product : products) {
            if (product.containsElements(By.linkText(productTitle))) {
                exists = true;
            }
        }
        return exists;
    }

    public void checkIfProductExists(String productTitle) {
        Assert.assertTrue("The product is in the list", searchProduct(productTitle));
    }

    private Number getProductPrice(Integer index) {
        try {
            NumberFormat format = NumberFormat.getInstance(Locale.FRANCE);
            return format.parse(products.get(index).findElement(By.className("price")).getText().replace(" RON", ""));
        } catch (ParseException exception) {
            return 0;
        }
    }

    public void compareFirstAndLastPrice() {
        Assert.assertTrue("The sort by price is correct", getProductPrice(0).doubleValue() < getProductPrice(products.size() - 1).doubleValue());
    }
}
