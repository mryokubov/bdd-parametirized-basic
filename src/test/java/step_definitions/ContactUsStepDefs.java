package step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.ContactUsPage;
import pages.LoginPage;
import utils.Driver;

/**
 * Created by tairovich_jr on 2022-02-13.
 */
public class ContactUsStepDefs {


    private WebDriver driver;
    private LoginPage loginPage;
    private ContactUsPage contactUsPage;


    //before cucumber scenario
    @Before
    public void setUp(){
        driver = Driver.getDriver();
    }

    //after cucumber scenario
    @After
    public void cleanUp(){
        if (driver != null){
            driver.quit();
        }
    }

    @Given("user is on the main page")
    public void user_is_on_the_main_page() {
        loginPage = new LoginPage(driver);
        contactUsPage = new ContactUsPage(driver);
        loginPage.visitMainPage();
    }

    @When("user clicks on contact us link")
    public void user_clicks_on_contact_us_link() {
       loginPage.visitContactUsPage();
    }

    @Then("user logs in with valid credentials {string} and {string}")
    public void user_logs_in_with_valid_credentials_and(String email, String passwd) {
        loginPage.visitSignInPage();
        loginPage.enterCredentials(email, passwd);
        loginPage.clickSignIn();
    }

    @When("user selects {string}")
    public void user_selects(String subheading) {
        loginPage.visitContactUsPage();
        contactUsPage.selectSubHeading(subheading);
    }

    @Then("user enters {string}")
    public void user_enters(String email) {
        contactUsPage.enterEmailAddress(email);
    }

    @Then("user enters order reference as {string}")
    public void user_enters_order_reference_as(String orderRef) {
        contactUsPage.enterOrderReference(orderRef);
    }

    @Then("user types message {string}")
    public void user_types_message(String message) {
        contactUsPage.typeMessage(message);
    }

    @Then("user clicks on send button")
    public void user_clicks_on_send_button() throws InterruptedException {
        contactUsPage.sendMessage();
    }

    @Then("user should see the success alert message")
    public void user_should_see_the_success_alert_message() {
        contactUsPage.verifyAlertMessage();
    }

    @Then("user attaches file {string}")
    public void user_attaches_file(String path) {
        contactUsPage.attachFile(path);
    }

    @Then("user should see error alert message")
    public void user_should_see_error_alert_message() {
        contactUsPage.verifyAlertMessage();
    }


}
