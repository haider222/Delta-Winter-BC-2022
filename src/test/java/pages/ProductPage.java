package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * @author Victor
 */
public class ProductPage
{
    @FindBy(css = "[data-original-title='Compare this Product']")
    WebElement compareButton;

    @FindBy(xpath = "//a[text()='product comparison']")
    WebElement compareLink;

    @FindBy(css = ".thumbnails li:not(.image-additional)")
    WebElement productImage;

    @FindBy(xpath = "//h2[text()[contains(.,'€')]]")
    WebElement productPriceEur;

    @FindBy(xpath = "//a[text()='Specification']")
    WebElement specification;


    public boolean isCompareButtonPresent()
    {
        return compareButton.isDisplayed() && compareButton.isEnabled();
    }

    public void clickCompareButton()
    {
        compareButton.click();
    }

    public void compareProducts(WebDriver driver)
    {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(2));
        wait.until(ExpectedConditions.elementToBeClickable(compareLink));
        compareLink.click();
    }

    public boolean isProductImageVisible()
    {
        return productImage.isDisplayed();
    }

    public String getPriceText()
    {
       return productPriceEur.getText();
    }

    public boolean isSpecificationTabPresent()
    {
        return specification.isDisplayed();
    }
    public void clickSpecificationTab()
    {
        specification.click();
    }

    public boolean isSpecificationTabActive()
    {
        return "true".equals(specification.getAttribute("aria-expanded"));
    }
}
