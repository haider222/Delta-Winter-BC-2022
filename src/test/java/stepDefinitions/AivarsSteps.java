package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.HeaderPage;
import pages.SearchPage;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AivarsSteps {

    private WebDriver driver;
    static HeaderPage headerPage;
    static SearchPage searchPage;

    public AivarsSteps() {
        this.driver = Hooks.driver;
        headerPage = PageFactory.initElements(Hooks.driver, HeaderPage.class);
        searchPage = PageFactory.initElements(Hooks.driver, SearchPage.class);
    }

    @Given("User is at home page")
    public void userIsAtHomePage() {
        driver.get("http://www.demoshop24.com/");
    }

    @When("User enters value {string} into search field in header")
    public void userEntersValueIntoSearchFieldInHeader(String arg0) {
        headerPage.enterSearchValue(arg0);
    }

    @And("User clicks search button magnifying glass")
    public void userClicksSearchButtonMagnifyingGlass() {
        headerPage.clickSearchButton();
    }

    @Then("User see search result list contains product name {string}")
    public void userSeeSearchResultListContainsProductName(String arg0) {
        System.out.println("getProductNames() " + searchPage.getProductNames());
        assertTrue(searchPage.getProductNames().contains(arg0));
    }


    @And("User press Enter for search field in header")
    public void userPressEnterForSearchFieldInHeader() {
        headerPage.pressEnterToSearch();
    }

    @Then("User see search result list is empty")
    public void userSeeSearchResultListIsEmpty() {
        assertTrue(searchPage.isSearchResultIsEmpty());
    }

    @And("User selects sorting {string}")
    public void userSelectsSorting(String arg0) {
        searchPage.selectSortBy(arg0);
    }

    @Then("User see search result list contains items {string}")
    public void userSeeSearchResultListContainsItems(String arg0) {
        List<String> productNames = searchPage.getProductNames();
        String actualString = String.join(",", productNames);
        assertEquals(actualString, arg0);
    }
}
