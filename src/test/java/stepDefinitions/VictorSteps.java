package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.HeaderPage;
import pages.SearchPage;

import java.util.List;

/**
 * @author Victor
 */
public class VictorSteps
{
    private final WebDriver driver;
    private final HeaderPage headerPage;

    private final SearchPage searchPage;

    public VictorSteps()
    {
        this.driver = Hooks.driver;
        headerPage = PageFactory.initElements(Hooks.driver, HeaderPage.class);
        searchPage = PageFactory.initElements(Hooks.driver, SearchPage.class);
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
}
