package pages;

import io.cucumber.java.it.Ma;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by tairovich_jr on 2022-02-12.
 */
public class CustomerPage extends MainPage {

    private String welcomeTxtMessage = "Welcome to your account. Here you can manage all of your personal information and orders.";
    private String pageHeadingTxt = "my account";

    public CustomerPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h1[@class='page-heading']")
    private WebElement pageHeading;


    @FindBy(xpath = "//p[@class='info-account']")
    private WebElement welcomeTxt;

    public void verifyPageHeading(){
        Assert.assertTrue(pageHeading.isDisplayed());
        Assert.assertEquals(pageHeadingTxt, pageHeading.getText().trim().toLowerCase());
    }

    public void verifyWelcomeMsg(){
        Assert.assertTrue(welcomeTxt.isDisplayed());
        Assert.assertEquals(welcomeTxtMessage, welcomeTxt.getText().trim());
    }
}
