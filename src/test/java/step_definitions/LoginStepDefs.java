package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.CustomerPage;
import pages.LoginPage;
import utils.Driver;

/**
 * Created by tairovich_jr on 2022-02-12.
 */
public class LoginStepDefs {

    private WebDriver driver;
    private LoginPage loginPage;
    private CustomerPage customerPage;

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        driver = Driver.getDriver(); //may return chrome,firefox,ie,safari
        loginPage = new LoginPage(driver);
        loginPage.visitMainPage();
        loginPage.verifyMainPageTitle();
        loginPage.visitSignInPage();
        loginPage.verifyLoginPageTitle();
    }

    @When("user enters {string} and {string}")
    public void user_enters_and(String username, String password) {
        loginPage.enterCredentials(username,password);
    }

    @And("user clicks on login")
    public void user_clicks_on_login() {
       loginPage.clickSignIn();
    }

    @Then("user should be navigated to homepage")
    public void user_should_be_navigated_to_homepage() {

        customerPage = new CustomerPage(driver);
        customerPage.verifyPageHeading();
        customerPage.verifyWelcomeMsg();

        if (driver != null){
            driver.quit();
        }
    }

}
