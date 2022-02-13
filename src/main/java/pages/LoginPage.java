package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by tairovich_jr on 2022-02-12.
 */
public class LoginPage extends MainPage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "passwd")
    private WebElement passwdInput;

    @FindBy(id = "SubmitLogin")
    private WebElement signInBtn;

    public void enterCredentials(String username, String password){
        //you can put additional logic for labels verification
        //verify input boxes are enabled
        emailInput.sendKeys(username);
        passwdInput.sendKeys(password);
    }

    public void clickSignIn(){
        Assert.assertTrue(signInBtn.isEnabled());
        signInBtn.click();
    }

    public void verifyLoginPageTitle(){
        Assert.assertTrue(driver.getTitle().equals("Login - My Store"));
    }
}
