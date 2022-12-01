package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchPage
{
    @FindBy(how = How.ID, using = "input-search")
    private WebElement searchField;

    @FindBy(how = How.ID, using = "button-search")
    private WebElement searchButton;

    @FindBy(how = How.ID, using = "description")
    private WebElement searchInDescriptionCheckbox;

    @FindBy(how = How.CSS, using = "#content p:not(:has(label))")
    private WebElement searchErrorMessage;

    @FindBy(how = How.XPATH, using = "//*[@id='content']//*[contains(text(),'There is no " +
            "product')]")
    WebElement searchResultEmptyMessage;

    @FindBy(className = "product-thumb")
    private List<WebElement> searchResults;

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

    public boolean isSearchResultIsEmpty()
    {
        boolean resultEmpty = true;
        try
        {
            searchResultEmptyMessage.getText();
        }
        catch (Exception e)
        {
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
        for (WebElement element : searchResults)
        {
            List<WebElement> nameElements =
                    element.findElements(By.xpath("//a[text()='" + name + "']"));
            if (nameElements.size() > 0)
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
            WebElement name = product.findElement(By.cssSelector("h4 a"));
            String text = name.getText();
            names.add(text);
        }
        return names;
    }

    public Map<String, String> getProductPrices()
    {
        Map<String, String> prices = new HashMap<>();
        for (WebElement element : searchResults)
        {
            String name = element.findElement(By.cssSelector("h4 a")).getText();
            List<WebElement> prices1 = element.findElements(By.className("price-new"));
            if (prices1.size() > 0)
            {
                prices.put(name, prices1.get(0).getText());
            } else
            {
                String priceAll = element.findElement(By.className("price")).getText();
                String removable = element.findElement(By.cssSelector(".price span")).getText();
                String price = priceAll.replace(removable, "").replace("\n", "").replace("\r", "");
                prices.put(name, price);
            }
        }
        return prices;
    }
}
