package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.ComparisonPage;
import pages.HeaderPage;
import pages.ProductPage;
import pages.SearchPage;

import java.time.Duration;
import java.util.List;

/**
 * @author Victor
 */
public class VictorSteps
{
    private final WebDriver driver;
    private final HeaderPage headerPage;

    private final SearchPage searchPage;

    private final ProductPage productPage;

    private final ComparisonPage comparisonPage;

    public VictorSteps()
    {
        this.driver = Hooks.driver;
        headerPage = PageFactory.initElements(driver, HeaderPage.class);
        searchPage = PageFactory.initElements(driver, SearchPage.class);
        productPage = PageFactory.initElements(driver,ProductPage.class);
        comparisonPage = PageFactory.initElements(driver, ComparisonPage.class);
    }

    @Given("User is on homepage")
    public void userIsOnHomepage()
    {
        driver.get("http://www.demoshop24.com/");
    }

    @When("User clicks the search button")
    public void userClicksTheSearchButton()
    {
        headerPage.clickSearchButton();
    }

    @And("User disables checking in product descriptions")
    public void userDisablesCheckingInProductDescriptions()
    {
        searchPage.disableSearchInDescription();
    }

    @And("User enters {string} in advanced search field")
    public void userEntersInAdvancedSearchField(String searchQuery)
    {
        searchPage.enterSearchValue(searchQuery);
        System.out.println(searchQuery);
    }

    @And("User clicks the advanced search button")
    public void userClicksTheAdvancedSearchButton()
    {
        searchPage.clickSearchButton();
    }

    @Then("User should see message {string} in search results")
    public void userShouldSeeMessageInSearchResults(String message)
    {
        Assertions.assertEquals(message,searchPage.getSearchErrorMessage());
    }

    @And("User enables checking in product descriptions")
    public void userEnablesCheckingInProductDescriptions()
    {
        searchPage.enableSearchInDescription();
    }

    @Then("User should see at least {int} products  with {string} in description.")
    public void userShouldSeeAtLeastProductsWithInDescription(int number, String text)
    {
        List<String> descriptions = searchPage.getProductDescpriptions();
        Assertions.assertTrue(descriptions.size() >= number);
        Assertions.assertTrue(descriptions.get(0).contains(text));
        Assertions.assertTrue(descriptions.get(1).contains(text));
    }

    @Given("User goes to compare page")
    public void userGoesToComparePage()
    {
        driver.get("http://www.demoshop24.com/index.php?route=product/compare");
    }

    @When("User enters value {string} in the search field")
    public void userEntersValueInTheSearchField(String searchQuery)
    {
        headerPage.enterSearchValue(searchQuery);
    }

    @And("User clicks on product by name {string} in search results")
    public void userClicksOnProductByNameInSearchResults(String productName)
    {
        searchPage.clickSearchResultByName(productName);
    }

    @Then("User should see Compare this product button")
    public void userShouldSeeCompareThisProductButton()
    {
        Assertions.assertTrue(productPage.isCompareButtonPresent());
    }

    @And("User removes all products from comparison")
    public void userRemovesAllProductsFromComparison()
    {
        comparisonPage.clearComparison();
    }


    @And("User clicks Compare this product button")
    public void userClicksCompareThisProductButton()
    {
        productPage.clickCompareButton();
    }

    @And("User clicks product comparison link.")
    public void userClicksProductComparisonLink()
    {
        productPage.compareProducts(driver);
    }

    @Then("User should see {string} product in comparison")
    public void userShouldSeeProductInComparison(String productName)
    {
        List<String> comparedProducts = comparisonPage.getComparedProductNames();
        Assertions.assertTrue(comparedProducts.contains(productName));
    }
}
