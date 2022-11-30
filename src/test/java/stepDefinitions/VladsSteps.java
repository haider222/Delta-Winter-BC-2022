package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Given;
import org.junit.Assert.*;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import static org.junit.Assert.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class VladsSteps {
    private WebDriver driver;

    public VladsSteps() {
        this.driver = Hooks.driver;
    }

    @Given("User is at Homepage")
    public void iGoToDemoshopUrl()
    {
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
}
