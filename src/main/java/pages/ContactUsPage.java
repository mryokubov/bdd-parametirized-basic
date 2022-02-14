package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import utils.ConfigReader;

/**
 * Created by tairovich_jr on 2022-02-13.
 */
public class ContactUsPage extends MainPage{


    public ContactUsPage(WebDriver driver) {
        super(driver);
    }


    /* Web Elements of Contact Us Page */

    @FindBy(className = "navigation_page")
    private WebElement contactTab;

    @FindBy(xpath = "//h1[starts-with(@class,'page-heading')]")
    private WebElement pageHeading;

    @FindBy(className = "page-subheading")
    private WebElement pageSubHeading;

    @FindBy(xpath = "//label[@for='id_contact']")
    private WebElement subHeadingLabel;

    private Select subjectOptionsDropDown;

    @FindBy(id = "desc_contact1")
    private WebElement webMasterTechnicalServiceTxt;

    @FindBy(id = "desc_contact2")
    private WebElement customerTechnicalServiceTxt;

    @FindBy(xpath = "//label[@for='email']")
    private WebElement emailLabel;

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(xpath = "//label[text()='Order reference']")
    private WebElement orderReferenceLabel;

    @FindBy(id = "id_order")
    private WebElement getOrderReferenceInput;

    @FindBy(xpath = "//label[@for='fileUpload']")
    private WebElement fileUploadLabel;

    @FindBy(id = "fileUpload")
    private WebElement attachFileInput;

    @FindBy(xpath = "//span[@class='action']")
    private WebElement chooseFileBtn;

    @FindBy(xpath = "//label[@for='message']")
    private WebElement messageLabel;

    @FindBy(id = "message")
    private WebElement messageTextArea;

    @FindBy(id = "submitMessage")
    private WebElement sendBtn;

    @FindBy(xpath = "//p[contains(@class,'alert-success')]")
    private WebElement successAlert;

    @FindBy(xpath = "//div[contains(@class,'alert-danger')]/p")
    private WebElement failureToSendAlert;

    @FindBy(id = "id_contact")
    private WebElement selectId;

    @FindBy(linkText = "contact us")
    private WebElement contactUsLink;

    private boolean loggedIn = false;

    public void visitHomePage(){
        //           http:automationpractice.com
        driver.get( ConfigReader.getProperty("url") );
    }

    public void clickContactUsLink(){
        contactUsLink.click();
    }

    //primary actions on the contact us page
    public void selectSubHeading(String option){
        Assert.assertEquals(subHeadingLabel.getText(), "Subject Heading");
        subjectOptionsDropDown = new Select(selectId);
        subjectOptionsDropDown.selectByVisibleText(option);
        if (option.equals("Webmaster")){
            Assert.assertEquals(webMasterTechnicalServiceTxt.getText(),
                    "If a technical problem occurs on this website");
        }else if(option.equals("Customer service")){
            Assert.assertEquals(customerTechnicalServiceTxt.getText(),
                    "For any question about a product, an order");
        }
    }

    public void enterEmailAddress(String emailAddress){
        Assert.assertEquals(emailLabel.getText(), "Email address");
        String value = emailInput.getAttribute("value");
        if (value.isEmpty() || value == null){
            emailInput.sendKeys(emailAddress);
        }else{
            //if email input is not empty, we are signed in
            loggedIn = true;
        }

    }

    public void enterOrderReference(String orderRef){
        Assert.assertEquals(orderReferenceLabel.getText(), "Order reference");
        if (loggedIn){
            //we have to deal with the drop down
            WebElement id_order = driver.findElement(By.xpath("//select[@name='id_order']"));
            Select s = new Select(id_order);
            s.selectByIndex(0);
        }else{
            getOrderReferenceInput.sendKeys(orderRef);
        }

    }

    public void attachFile(String filePath){
        //    "/Users/jack/Downloads/hello.png"
        Assert.assertEquals(fileUploadLabel.getText(), "Attach File");
        attachFileInput.sendKeys(filePath);
    }

    public void typeMessage(String message){
        Assert.assertEquals(messageLabel.getText(), "Message");
        messageTextArea.sendKeys(message);
    }

    public void sendMessage() throws InterruptedException {
        Assert.assertTrue(sendBtn.isDisplayed());
        Assert.assertTrue(sendBtn.isEnabled());
        sendBtn.click();
        Thread.sleep(3000);

    }

    public void verifyAlertMessage(){
        WebElement successOrFailure = driver.findElement(By.xpath("//div[@id='center_column']"));
        if (successOrFailure.getText().contains("There is 1 error")){
            verifyFailureAlertBanner();
        }else if(successOrFailure.getText().contains("message has been successfully")){
            verifySuccessAlertBanner();
        }
    }

    private void verifySuccessAlertBanner(){
        Assert.assertTrue(successAlert.isDisplayed());
    }

    private void verifyFailureAlertBanner(){
        Assert.assertTrue(failureToSendAlert.isDisplayed());
    }
}
