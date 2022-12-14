package pages_sample;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class AgeSubmittedPage {
    @FindBy(how = How.CSS, using = "#message")
    private WebElement message;
    @FindBy(how = How.TAG_NAME, using = "button")
    private WebElement backButton;

    public void clickBackButton() {
        backButton.click();
    }

    public void checkMessageText(String messageText) {
        Assertions.assertEquals(message.getText(), messageText);
    }
}