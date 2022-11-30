package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


import java.util.ArrayList;
import java.util.List;

public class SearchPage
{
    @FindBy(how = How.ID, using = "input-search")
    WebElement searchField;

    @FindBy(how = How.ID, using = "button-search")
    WebElement searchButton;

    @FindBy(how = How.ID, using = "description")
    WebElement searchInDescriptionCheckbox;

    @FindBy(how = How.CSS, using = "#content p:not(:has(label))")
    WebElement searchErrorMessage;

    @FindBy(how = How.XPATH, using = "//*[@id='content']//*[contains(text(),'There is no product')]")
    WebElement searchResultEmptyMessage;

    @FindBy(className = "product-thumb")
    List<WebElement> searchResults;

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

    public List<String> getProductDescpriptions()
    {
        List<String> descriptions = new ArrayList<>();
        for (WebElement product : searchResults)
        {
            WebElement description = product.findElement(By.cssSelector("p:not(:has(span))"));
            String text = description.getText();
            descriptions.add(text);
        }
        return descriptions;
    }
    public boolean clickSearchResultByName(String name)
    {
        for(WebElement element : searchResults)
        {
            List<WebElement> nameElements = element.findElements(By.xpath("//a[text()='"+name+"']"));
            if(nameElements.size() > 0)
            {
                element.click();
                return true;
            }
        }
        return false;
    }

    public List<String> getProductNames()
    {
        List<String> names = new ArrayList<>();
        for (WebElement product : searchResults)
        {
            WebElement name = product.findElement(By.cssSelector(".product-thumb h4 a"));
            String text = name.getText();
            names.add(text);
        }
        return names;
    }

    /**
     * NAME_ASC - sort by name ascending<br>
     * NAME_DESC - sort by name descending<br>
     * PRICE_ASC - sort by price ascending<br>
     * PRICE_DESC - sort by price descending<br>
     */
    public void selectSortBy(String option) {
        sortDropDown.click();
        switch (option) {
            case "NAME_ASC":
                sortDropDown.findElement(By.cssSelector("[value*='sort=pd.name&order=ASC']")).click();
                break;
            case "NAME_DESC":
                sortDropDown.findElement(By.cssSelector("[value*='sort=pd.name&order=DESC']")).click();
                break;
            case "PRICE_ASC":
                sortDropDown.findElement(By.cssSelector("[value*='sort=p.price&order=ASC']")).click();
                break;
            case "PRICE_DESC":
                sortDropDown.findElement(By.cssSelector("[value*='sort=p.price&order=DESC']")).click();
                break;
        }
    }
}
