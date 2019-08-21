package org.fasttrack.steps;

import net.thucydides.core.annotations.Step;
import org.fasttrack.pages.AccountPage;
import org.fasttrack.pages.HomePage;
import org.fasttrack.pages.LoginPage;
import org.fasttrack.pages.SearchPage;
import org.junit.Assert;

public class SearchSteps {

    private SearchPage searchPage;

    @Step
    public void search(String searchTerm){
        searchPage.open();
        searchPage.setSearchInput(searchTerm);
        searchPage.clickSearchButton();

    }

    @Step
    public void selectProducts() {
        searchPage.selectProducts();
    }

    @Step
    public void checkIfProductExists(String productTitle) {
        searchPage.checkIfProductExists(productTitle);
    }

    @Step
    public void sortByPrice() {
        searchPage.sortByPrice();
    }

    @Step
    public void compareFirstAndLastPrice() {
        searchPage.compareFirstAndLastPrice();
    }

}
