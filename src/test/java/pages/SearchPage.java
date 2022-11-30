package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class SearchPage
{
    @FindBy(how = How.ID, using = "input-search")
    WebElement searchField;

    @FindBy(how = How.ID, using = "button-search")
    WebElement searchButton;

    @FindBy(how = How.ID, using = "description")
    WebElement searchInDescriptionCheckbox;

    @FindBy(how = How.XPATH, using = "//div[@id='content']/p[2]") //TODO: fix xpath
    WebElement searchErrorMessage;

    @FindBy(how = How.XPATH, using = "//*[@id='content']//*[contains(text(),'There is no product')]")
    WebElement searchResultEmptyMessage;

    public void enterSearchValue(String value)
    {
        searchField.clear();
        searchField.sendKeys(value);
    }

    public void clickSearchButton()
    {
        searchButton.click();
    }

    public void disableSearchInDescription()
    {
        if (searchInDescriptionCheckbox.isSelected())
        {
            searchInDescriptionCheckbox.click();
        }
    }

    public void enableSearchInDescription()
    {
        if (!searchInDescriptionCheckbox.isSelected())
        {
            searchInDescriptionCheckbox.click();
        }
    }

    public String getSearchErrorMessage()
    {
        return searchErrorMessage.getText();
    }

    public boolean isSearchResultIsEmpty() {
        boolean resultEmpty = true;
        try {
            searchResultEmptyMessage.getText();
        } catch (Exception e) {
            resultEmpty = false;
        }
        return resultEmpty;
    }
}
