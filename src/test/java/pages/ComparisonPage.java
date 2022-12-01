package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Victor
 */
public class ComparisonPage
{
    @FindBy(xpath = "//tr[./td[text()='Product']]/td[./a]")
    List<WebElement> productNameElements;

    @FindBy(className = "btn-danger")
    List<WebElement> deleteButtons;

    public void clearComparison()
    {
        deleteButtons.forEach(WebElement::click);
    }

    public List<String> getComparedProductNames()
    {
        List<String> productNames = new ArrayList<>();
        for (WebElement productElement : productNameElements)
        {
            productNames.add(productElement.getText());
        }
        return productNames;
    }
}
