package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Given;
import org.junit.Assert;
import org.junit.Assert.*;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import pages.ComparisonPage;
import pages.HeaderPage;
import pages.ProductPage;
import pages.SearchPage;

import static org.junit.Assert.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class VladsSteps {
    private WebDriver driver;

    private HeaderPage headerPage;

    private SearchPage searchPage;

    private ProductPage productPage;

    private ComparisonPage comparisonPage;

    public VladsSteps() {
        this.driver = Hooks.driver;
        headerPage = PageFactory.initElements(driver, HeaderPage.class);
        searchPage = PageFactory.initElements(driver, SearchPage.class);
        productPage = PageFactory.initElements(driver, ProductPage.class);
        comparisonPage = PageFactory.initElements(driver, ComparisonPage.class);
    }

    @Given("User is at Homepage")
    public void iGoToDemoshopUrl() {
        driver.get("http://www.demoshop24.com/");
    }


    @And("User selects {string} in categories dropdown menu")
    public void userClicksDropdownMenu(String arg0) {
        Select categories = new Select(driver.findElement(By.cssSelector("#content > div > div:nth-child(2) > select")));
        categories.selectByVisibleText(arg0);
    }

    @And("User enters {string} into Search criteria field")
    public void userEntersValueIntoSearchCriteriaField(String arg0) {
        driver.findElement(By.cssSelector("#input-search")).sendKeys(arg0);
    }

    @And("User clicks search button \\(on page)")
    public void userClicksSearchButtonOnPage() {
        driver.findElement(By.cssSelector("#button-search")).click();
    }

    @And("user checks the Search in subcategories checkbox")
    public void userChecksTheSearchInSubcategoriesCheckbox() {
        driver.findElement(By.cssSelector("#content > div > div:nth-child(3) > label > input[type=checkbox]")).click();
    }

    @And("User checks that Search in subcategories checkbox is unchecked")
    public void userChecksThatSearchInSubcategoriesCheckboxIsUnchecked() {
        assertFalse(driver.findElement(By.cssSelector("#content > div > div:nth-child(3) > label > input[type=checkbox]")).isSelected());
    }

    @Then("User sees empty search list")
    public void userSeesTextInSearchList() {
        assertTrue(driver.findElement(By.cssSelector("#content > p:nth-child(7)")).isDisplayed());
    }

    @Then("User sees result list contain product {string}")
    public void userSeesResultListContainProductValue(String arg0) {
        WebElement searchList = driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]"));
        assertTrue(searchList.isDisplayed());
        assertTrue(searchList.getText().contains(arg0));
    }

    @When("User clicks search button in the header")
    public void userClicksSearchButtonInTheHeader() {
        headerPage.clickSearchButton();
    }


    @Then("User sees pagination in the bottom left corner")
    public void userSeesPaginationInTheBottomLeftCorner() {
        assertTrue(driver.findElement(By.className("pagination")).isDisplayed());
    }

}

