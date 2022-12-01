package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HeaderPage {
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
    @FindBy(how = How.XPATH, using = "//*[@id='menu']//a[text()='Laptops & Notebooks']")
    WebElement laptopsAndNotebookMenu;
    @FindBy(how = How.XPATH, using = "//*[@id='menu']//a[text()='Show All Laptops & Notebooks']")
    WebElement laptopsAndNotebookAllMenu;

    @FindBy(id= "form-currency")
    WebElement currencyField;

    public void pressEnterToSearch() {
        searchField.sendKeys(Keys.ENTER);
    }

    public void enterSearchValue(String value) {
        searchField.clear();
        searchField.sendKeys(value);
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public void clickCartButton() {
        cartButton.click();
    }

    public void clickLoginPage() {
        loginRegisterButton.click();
        loginPageButton.click();
    }

    public void clickLaptopsAndNotebooksAll() {
        laptopsAndNotebookMenu.click();
        laptopsAndNotebookAllMenu.click();
    }

    public void selectCurrency(String currency)
    {
        currencyField.click();
        currencyField.findElement(By.name(currency)).click();
    }
}
