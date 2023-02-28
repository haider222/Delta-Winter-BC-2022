package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class HeaderFooterPage {

    @FindBy(how = How.CLASS_NAME, using = "dropdown-toggle")
    private WebElement currencyDropdown;
    @FindBy(how = How.CSS, using = "#top-links [href*='route=account/account']")
    private WebElement accountDropdown;
    @FindBy(how = How.CSS, using = "#top-links [href*='route=account/wishlist']")
    private WebElement wishListIcon;
    @FindBy(how = How.CSS, using = "#top-links [href*='route=checkout/checkout']")
    private WebElement checkoutIcon;
    @FindBy(how = How.CSS, using = "#top-links [href*='route=information/contact']")
    private WebElement phoneIcon;
    @FindBy(how = How.CSS, using = "#top-links [href*='route=checkout/cart']")
    private WebElement shoppingCartIcon;
    @FindBy(how = How.XPATH, using = "(//ul[@class='list-unstyled']/li)")
    public List<WebElement> footerLinks;
    @FindBy(how = How.CSS, using = "#search input")
    WebElement searchField;
    @FindBy(how = How.CSS, using = "#search button")
    WebElement searchButton;
    @FindBy(how = How.CSS, using = "#top-links [href*='route=account/login']")
    WebElement loginPageButton;
    @FindBy(how = How.CSS, using = "#top-links [title='My Account']")
    WebElement loginRegisterButton;
    @FindBy(how = How.CSS, using = "#top-links [href*='route=checkout/cart']")
    WebElement cartButton;



    public void selectCurrency() {
        currencyDropdown.click();
    }

    public void clickAccountIcon () {
        accountDropdown.click();
    }

    public void clickPhoneIcon() {
        phoneIcon.click();
    }

    public void clickWishListIcon() {
        wishListIcon.click();
    }

    public void clickShoppingCartIcon() {
        shoppingCartIcon.click();
    }

    public void clickCheckoutIcon() {
        checkoutIcon.click();
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public void clickCartButton() {
        cartButton.click();
    }

    public void clickRegisterAtHeader () {
        loginRegisterButton.click();
    }

    public void clickLoginAtHeader () {
        loginPageButton.click();
    }

}
