package step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.ContactUsPage;
import pages.LoginPage;
import pages.MainPage;
import utils.Driver;

/**
 * Created by tairovich_jr on 2022-02-13.
 */
public class ContactUsStepDefs {


    private WebDriver driver;
    private LoginPage loginPage;
    private MainPage mainPage;
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
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("user clicks on contact us link")
    public void user_clicks_on_contact_us_link() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("user selects {string}")
    public void user_selects(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("user enters {string}")
    public void user_enters(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("user enters order reference as {string}")
    public void user_enters_order_reference_as(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("user attaches file {string}")
    public void user_attaches_file(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("user types message {string}")
    public void user_types_message(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("user clicks on send button")
    public void user_clicks_on_send_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("user should see the success alert message")
    public void user_should_see_the_success_alert_message() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}
