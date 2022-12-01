package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import stepDefinitions.Hooks;

import java.time.Duration;
import java.util.List;

/**
 * @author Victor
 */
public class ProductPage {
    private WebDriver driver;
    private WebDriverWait wait;
    public ProductPage() {
        this.driver = Hooks.driver;
        wait = (WebDriverWait) new WebDriverWait(driver, Duration.ofSeconds(10)).ignoring(StaleElementReferenceException.class);
    }

    @FindBy(css = "[data-original-title='Compare this Product']")
    WebElement compareButton;

    @FindBy(xpath = "//a[text()='product comparison']")
    WebElement compareLink;

    @FindBy(css = "#content [href='#tab-review']")
    WebElement reviewTab;

    @FindBy(css = "#form-review #input-name")
    WebElement nameReview;

    @FindBy(css = "#form-review #input-review")
    WebElement textReview;

    @FindBy(css = "#form-review input[name='rating']")
    List<WebElement> ratingRadioButtons;

    @FindBy(css = "#form-review #button-review")
    WebElement continueReviewButton;

    @FindBy(css = "#form-review .alert")
    WebElement reviewAlert;

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

    public void clickReviewTab() {
        reviewTab.click();
    }

    public void enterNameForReview(String name) {
        nameReview.clear();
        nameReview.sendKeys(name);
    }

    public void enterTextForReview(String text) {
        textReview.clear();
        textReview.sendKeys(text);
    }

    public void selectReviewRating(int index) {
        WebElement radioButton = ratingRadioButtons.get(index - 1);
        radioButton.click();
    }

    public void clickContinueReview() {
        continueReviewButton.click();
    }

    public boolean isReviewAlertContainsMessage(String message) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#form-review .alert")));
        System.out.println("reviewAlert.getText() = " + reviewAlert.getText());
        System.out.println("message = " + message);
        return reviewAlert.getText().contains(message);
    }
}
