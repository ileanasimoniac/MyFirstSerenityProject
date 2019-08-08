package org.fasttrack.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://fasttrackit.org/selenium-test/wishlist/index/")
public class WhishListPage extends PageObject {

    @FindBy(css = "#header #header-nav #nav .nav-5 > a")
    private WebElementFacade saleButton;

    @FindBy(id = ".main .category-products ul.products-grid .item > a")
    private WebElementFacade firstProduct;


    @FindBy(css = "a.link-wishlist")
    private WebElementFacade addToWishListButton;


    @FindBy(css = "page-title.title-buttons > h1")
    private WebElementFacade whishListPageTitle;



    public void verifyIsInWishList(){
        whishListPageTitle.shouldContainText("My Wishlist");
    }

}
