package org.fasttrack.features;


import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.fasttrack.steps.LoginSteps;
import org.fasttrack.steps.SearchSteps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class SearchTest {

    @Managed(uniqueSession = true)
    private   WebDriver driver;

    @Before
    public  void maximiseWindow(){
        driver.manage().window().maximize();
    }


    @Steps
    private SearchSteps searchSteps;


    private String searchString = "necklace";
    private String productName = "SILVER DESERT NECKLACE";

    @Test
    public void validSearch() {
        searchSteps.search(searchString);
        searchSteps.selectProducts();
        searchSteps.checkIfProductExists(productName);
    }

    @Test
    public void searchByPriceTest() {
        searchSteps.search(searchString);
        searchSteps.sortByPrice();
        searchSteps.selectProducts();
        searchSteps.compareFirstAndLastPrice();
    }

}
