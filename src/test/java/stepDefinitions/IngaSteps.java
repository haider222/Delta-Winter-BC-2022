package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HeaderFooterPage;
import pages.HeaderPage;
import pages.MultiplePages;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class IngaSteps {
    private WebDriver driver;
    static MultiplePages search13;
    static HeaderFooterPage header;
    static WebDriverWait wait;

    public IngaSteps() {

        this.driver = Hooks.driver;
        search13 = PageFactory.initElements(Hooks.driver, MultiplePages.class);
        header = PageFactory.initElements(Hooks.driver, HeaderFooterPage.class);
        wait = (WebDriverWait) new WebDriverWait(driver, Duration.ofSeconds(10)).ignoring(StaleElementReferenceException.class);
    }

    @Given("user is at demoshop page")
    public void userIsAtDemoshopPage() {
        driver.get(search13.getPageUrl());
    }

    @When("user clicks currency dropdown at the header \\(top left)")
    public void userClicksCurrencyDropdownAtTheHeaderTopLeft() {
        header.selectCurrency();
    }

    @Then("user can see Search box")
    public void userCanSeeSearchBox() {
        assertTrue(search13.searchBox.isDisplayed());
    }

    @And("user selects currency:")
    public void userSelectsCurrency(List<String> currency) {
        header.selectCurrency();
        for (String value : currency) {
            header.selectCurrency();
            driver.findElement(By.cssSelector("[name='" + value + "']")).click();
        }
    }

    @When("user selects main menu category:")
    public void userSelectsMainMenuCategory(List<String> category) {
        for (String value : category) {
            WebElement mainDropdown = driver.findElement(By.partialLinkText(value));
            Actions a = new Actions(driver);
            a.moveToElement(mainDropdown).click().perform();
        }
    }

    @And("user selects sub-category")
    public void userSelectsSubCategory() {
        Actions a = new Actions(driver);
        a.moveToElement(search13.componentsDropdown).perform();
        List<WebElement> subCategories = driver.findElements(By.xpath("(//ul[@class='list-unstyled']/li/a)"));
        for (int i = 0; i < (subCategories.size()); i++) {
            //a.moveToElement(subCategories.get(i)).click();
            System.out.println(subCategories.get(i).getText());
        }
    }

    @When("user selects main menu category {string}")
    public void userSelectsMainMenuCategory(String arg0) {
        WebElement componentsDropdown = driver.findElement(By.partialLinkText(arg0));
        Actions a = new Actions(driver);
        a.moveToElement(componentsDropdown).click().perform();
    }

    @And("user selects sub-category {string}")
    public void userSelectsSubCategory(String arg0) {
        WebElement monitors = driver.findElement(By.partialLinkText(arg0));
        monitors.click();
    }

    @And("user selects minor sub-category {string}")
    public void userSelectsMinorSubCategory(String arg0) {
        WebElement itemFromList = driver.findElement(By.partialLinkText(arg0));
    }

    @When("user presses a footer link {string}")
    public void userPressesAFooterLink(String arg0) {
        driver.findElement(By.partialLinkText(arg0)).click();
    }

    @And("user fills in the form with valid credentials")
    public void userFillsInTheFormWithValidCredentials(Map<String, String> valuesToEnter) {
        search13.enterNameAtContactForm(valuesToEnter.get("name"));
        search13.enterEmailAtContactForm(valuesToEnter.get("email"));
        search13.enterEnquiryAtContactForm(valuesToEnter.get("enquiry"));
    }

    @And("user clicks Submit button")
    public void userClicksSubmitButton() {
        search13.clickSubmitAtContactUsForm();
    }

    @And("user clicks Continue button")
    public void userClicksContinueButton() {
        search13.clickContinueAtContactUsForm();
    }

    @When("user presses any footer link:")
    public void userPressesAnyFooterLink(List<String> link) {
        for (String value : link) {
            driver.findElement(By.partialLinkText(value)).click();
        }
    }

    @And("user fills in Returns form with valid credentials")
    public void userFillsInReturnsFormWithValidCredentials(Map<String, String> valuesToEnter) {
        search13.enterFirstNameAtReturnsForm(valuesToEnter.get("firstName"));
        search13.enterLastNameAtReturnsForm(valuesToEnter.get("lastName"));
        search13.enterEmailAtReturnsForm(valuesToEnter.get("email"));
        search13.enterPhoneAtReturnsForm(valuesToEnter.get("phone"));
        search13.enterOrderIdAtReturnsForm(valuesToEnter.get("orderId"));
        search13.enterProductAtReturnsForm(valuesToEnter.get("product"));
        search13.enterModelAtReturnsForm(valuesToEnter.get("model"));
    }

    @And("user selects return option")
    public void userSelectsReturnOption() {
        search13.selectRadioBtnAtReturnsForm();
    }

    @And("user selects brand {string}")
    public void userSelectsBrand(String arg0) {
        driver.findElement(By.partialLinkText(arg0)).click();
    }

    @And("user selects brand")
    public void userSelectsBrand(List<String> brand) {
        for (String value : brand) {
            driver.findElement(By.partialLinkText(value)).click();
        }
    }

    @And("user checks the checkbox")
    public void userChecksTheCheckbox() {
        search13.clickCheckboxAgree();
    }

    @When("user clicks My account")
    public void userClicksMyAccount() {
        header.clickAccountIcon();
    }

    @And("user clicks login")
    public void userClicksLogin() {
        header.clickLoginAtHeader();
    }


    @And("user enters data to log in")
    public void userEntersDataToLogIn(Map<String, String> valuesToEnter) {
        search13.enterEmail(valuesToEnter.get("myemail"));
        search13.enterPassword(valuesToEnter.get("mypassword"));
    }

    @And("user clicks login button")
    public void userClicksLoginButton() {
        search13.clickLogin();
    }

    @And("user clicks Edit Account link")
    public void userClicksEditAccountLink() {
        search13.editAccount();
    }

    @And("user edits phone")
    public void userEditsPhone() {
        driver.findElement(By.id("input-telephone")).clear();
        driver.findElement(By.id("input-telephone")).sendKeys("12345");
    }

    @And("user selects product {string}")
    public void userSelects(String arg0) {
        driver.findElement(By.xpath("//a[text()='" + arg0 + "']")).click();
    }


    @And("user presses {string} button")
    public void userPressesButton(String arg0) {
        driver.findElement(By.xpath("//button[text()='" + arg0 + "']")).click();
    }

    @And("user clicks {string} icon at header")
    public void userClicksIconAtHeader(String arg0) {
        driver.findElement(By.xpath("//a[text()='" + arg0 + "']")).click();
    }

    @And("user clicks {string} button")
    public void userClicksButton(String arg0) {
        driver.findElement(By.xpath("//li[text()='" + arg0 + "']")).click();
    }


    @Given("user is logged in")
    public void userIsLoggedIn() {
        driver.get("http://www.demoshop24.com/index.php?route=account/account");
    }

    @And("user clicks Shopping Cart icon at header")
    public void userClicksShoppingCartIconAtHeader() {
        header.clickCartButton();
    }


    @And("user clicks {string} button under product")
    public void userClicksButtonUnderProduct(String arg0) {
        driver.findElement(By.xpath("//a[text()='" + arg0 + "']")).click();
    }

    @When("user clicks Account icon at header")
    public void userClicksAccountIconAtHeader() {
        header.clickAccountIcon();
    }

    @And("user clicks Register at header")
    public void userClicksRegisterAtHeader() {
        header.clickRegisterAtHeader();
    }

    @And("user clicks Login at header")
    public void userClicksLoginAtHeader() {
        header.clickLoginAtHeader();
    }

    @When("user clicks Phone icon at header")
    public void userClicksPhoneIconAtHeader() {
        header.clickPhoneIcon();
    }

    @And("user clicks Wish List icon at header")
    public void userClicksWishListIconAtHeader() throws InterruptedException {
        Thread.sleep(3000);
        header.clickWishListIcon();
    }

    @And("user clicks Checkout icon at header")
    public void userClicksCkeckoutIconAtHeader() {
        header.clickCheckoutIcon();
    }

    @And("user presses Add to Cart button")
    public void userPressesAddToCartButton() {
        search13.pressAddToCartButtonAtProductPage();
    }

    @Then("product {string} is in the Shopping Cart")
    public void productIsInTheShoppingCart(String arg0) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='" + arg0 + "']")));
        assertEquals(arg0, driver.findElement(By.xpath("//a[text()='" + arg0 + "']")).getText());
    }

    @Then("product {string} is not in the Shopping Cart")
    public void productIsNotInTheShoppingCart(String arg0) {
        List<WebElement> productsInCart = driver.findElements(By.cssSelector(".text-left [href*='route=product']"));
        if (productsInCart.size() == 0) {
            assertTrue(productsInCart.size() == 0);
        } else {
            for (int i=0; i< (productsInCart.size()); i++) {
                assertNotEquals(productsInCart.get(i).getText(), arg0);
            }
        }
    }



    @And("user adds the product to the Wish List")
    public void userAddsTheProductToTheWishList() {
        search13.addToWishList();
    }

    @And("user clicks Add to Cart button in the Wish List")
    public void userClicksAddToCartButtonInTheWishList() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[data-original-title='Add to Cart']")));
        search13.addToCartFromWishList();
    }

    @Then("user is redirected to Login page")
    public void userIsRedirectedToLoginRegisterPage() {
        assertEquals("http://www.demoshop24.com/index.php?route=account/login", driver.getCurrentUrl());
    }
}


