package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class MultiplePages {

    @FindBy(how = How.ID, using = "search")
    public WebElement searchBox;
    @FindBy(how = How.PARTIAL_LINK_TEXT, using = "Components")
    public WebElement componentsDropdown;
    @FindBy(how = How.XPATH, using = "(//ul[@class='list-unstyled']/li/a)")
    public List<WebElement> subCategories;
    @FindBy(how = How.ID, using = "input-name")
    private WebElement nameAtContactUsForm;
    @FindBy(how = How.ID, using = "input-email")
    private WebElement emailAtContactUsForm;
    @FindBy(how = How.ID, using = "input-enquiry")
    private WebElement enquiryAtContactUsForm;
    @FindBy(how = How.CLASS_NAME, using = "btn-primary")
    private WebElement submitBtnAtContactUsForm;
    @FindBy(how = How.CLASS_NAME, using = "btn")
    private WebElement continueBtnAtContactUsForm;
    @FindBy(how = How.CLASS_NAME, using = "see-all")
    private WebElement showAll;
    @FindBy(how = How.ID, using = "input-firstname")
    private WebElement firstNameAtReturnsForm;
    @FindBy(how = How.ID, using = "input-lastname")
    private WebElement lastNameAtReturnsForm;
    @FindBy(how = How.ID, using = "input-email")
    private WebElement emailAtReturnsForm;
    @FindBy(how = How.ID, using = "input-telephone")
    private WebElement telephoneAtReturnsForm;
    @FindBy(how = How.ID, using = "input-order-id")
    private WebElement orderIdAtReturnsForm;
    @FindBy(how = How.ID, using = "input-product")
    private WebElement productAtReturnsForm;
    @FindBy(how = How.ID, using = "input-model")
    private WebElement productCodeAtReturnsForm;
    @FindBy(how = How.NAME, using = "return_reason_id")
    private WebElement returnReasonAtReturnsForm;
    @FindBy(how = How.NAME, using = "agree")
    private WebElement checkbox;
    @FindBy(how = How.ID, using = "input-email")
    private WebElement emailInputLogin;
    @FindBy(how = How.ID, using = "input-password")
    private WebElement passwordInputLogin;
    @FindBy(how = How.XPATH, using = "//input[@value='Login']")
    private WebElement loginButton;
    @FindBy(how = How.CSS, using = ".list-unstyled [href*='route=account/edit']")
    private WebElement editAccountLink;


    public String getPageUrl() {
        return "http://www.demoshop24.com/";
    }

    public void enterNameAtContactForm(String name) {
        nameAtContactUsForm.clear();
        nameAtContactUsForm.sendKeys(name);
    }

    public void enterEmailAtContactForm(String email) {
        emailAtContactUsForm.clear();
        emailAtContactUsForm.sendKeys(email);
    }

    public void enterEnquiryAtContactForm(String enquiry) {
        enquiryAtContactUsForm.clear();
        enquiryAtContactUsForm.sendKeys(enquiry);
    }

    public void clickSubmitAtContactUsForm() {
        submitBtnAtContactUsForm.click();
    }

    public void clickContinueAtContactUsForm() {
        continueBtnAtContactUsForm.click();
    }

    public void clickShowAll() {
        showAll.click();
    }

    public void enterFirstNameAtReturnsForm(String firstName) {
        firstNameAtReturnsForm.clear();
        firstNameAtReturnsForm.sendKeys(firstName);
    }

    public void enterLastNameAtReturnsForm(String lastName) {
        lastNameAtReturnsForm.clear();
        lastNameAtReturnsForm.sendKeys(lastName);
    }

    public void enterEmailAtReturnsForm(String email) {
        emailAtReturnsForm.clear();
        emailAtReturnsForm.sendKeys(email);
    }

    public void enterPhoneAtReturnsForm(String phone) {
        telephoneAtReturnsForm.clear();
        telephoneAtReturnsForm.sendKeys(phone);
    }

    public void enterOrderIdAtReturnsForm(String orderId) {
        orderIdAtReturnsForm.clear();
        orderIdAtReturnsForm.sendKeys(orderId);
    }

    public void enterProductAtReturnsForm(String product) {
        productAtReturnsForm.clear();
        productAtReturnsForm.sendKeys(product);
    }

    public void enterModelAtReturnsForm(String code) {
        productCodeAtReturnsForm.clear();
        productCodeAtReturnsForm.sendKeys(code);
    }

    public void enterReasonAtReturnsForm(String reason) {
        returnReasonAtReturnsForm.clear();
        returnReasonAtReturnsForm.sendKeys(reason);
    }

    public void selectRadioBtnAtReturnsForm() {
        returnReasonAtReturnsForm.click();
    }

    public void clickCheckboxAgree(){
        checkbox.click();
    }

    public void enterEmail(String myemail) {
        emailInputLogin.clear();
        emailInputLogin.sendKeys(myemail);
    }

    public void enterPassword(String mypassword) {
        passwordInputLogin.clear();
        passwordInputLogin.sendKeys(mypassword);
    }
    public void clickLogin() {
        loginButton.click();
    }

    public void editAccount() {
        editAccountLink.click();
    }



}
