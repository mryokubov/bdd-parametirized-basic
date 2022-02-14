package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ConfigReader;

import java.lang.reflect.Method;

/**
 * Created by tairovich_jr on 2022-02-12.
 */
public class MainPage {

    protected WebDriver driver;

    public MainPage (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(partialLinkText = "Sign in")
    private WebElement signInLink;

    @FindBy(partialLinkText = "Contact us")
    private WebElement contactUsLink;

    public void verifyMainPageTitle(){
        Assert.assertTrue(driver.getTitle().equals("My Store"));
    }

    public void visitMainPage(){
        driver.get(ConfigReader.getProperty("url")); //visit main page
    }

    public void visitSignInPage(){
        signInLink.click(); //click on sign in link
    }

    public void visitContactUsPage(){
        contactUsLink.click();
    }
}


