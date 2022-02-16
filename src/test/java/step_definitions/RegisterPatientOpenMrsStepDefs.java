package step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.Driver;

import java.util.List;
import java.util.Map;

/**
 * Created by tairovich_jr on 2022-02-15.
 */
public class RegisterPatientOpenMrsStepDefs {

    private WebDriver driver;

    @Before
    public void setUp(){
        driver = Driver.getDriver();
    }

    @After
    public void cleanUp(){
        if (driver != null){
            driver.quit();
        }
    }

    @Given("user logins into open mrs application")
    public void user_logins_into_open_mrs_application() throws InterruptedException {
      driver.get("https://demo.openmrs.org/openmrs/login.htm");
      Thread.sleep(5000);
      driver.findElement(By.id("username")).sendKeys("Admin");
      driver.findElement(By.id("password")).sendKeys("Admin123");
      driver.findElement(By.id("Inpatient Ward")).click();
      driver.findElement(By.id("loginButton")).click();
    }

    @Then("user clicks on register patient tab")
    public void user_clicks_on_register_patient_tab() {
        driver.findElement(By.xpath("//a[contains(@id,'referenceapplication')][1]")).click();
    }

    @Then("user uses the below info to register new user")
    public void user_uses_the_below_info_to_register_new_user(List<Map<String,String>> data) throws InterruptedException {

        Map<String, String> map = data.get(0);

        //fill name
        driver.findElement(By.name("givenName")).sendKeys( map.get("given") );
        driver.findElement(By.name("middleName")).sendKeys( map.get("middle") );
        driver.findElement(By.name("familyName")).sendKeys( map.get("family") );

        driver.findElement(By.id("next-button")).click(); //click next button

       String gender = map.get("gender").substring(0,1).toUpperCase();
        driver.findElement(By.xpath("//option[@value='"+gender+"']")).click();

        driver.findElement(By.id("next-button")).click(); //click next button


        String[] dob = map.get("dob").split(" ");

        driver.findElement(By.id("birthdateDay-field")).sendKeys(dob[0]);

        Select select = new Select(driver.findElement(By.id("birthdateMonth-field")));
        select.selectByVisibleText( dob[1]);

        driver.findElement(By.id("birthdateYear-field")).sendKeys(dob[2]);

        driver.findElement(By.id("next-button")).click(); //click next button

        driver.findElement(By.id("address1")).sendKeys(map.get("address"));

        driver.findElement(By.id("next-button")).click(); //click next button

        driver.findElement(By.name("phoneNumber")).sendKeys(map.get("phone"));

        driver.findElement(By.id("next-button")).click(); //click next button

        Select select1 = new Select(driver.findElement(By.id("relationship_type")));
        select1.selectByVisibleText(map.get("relative"));

        driver.findElement(By.xpath("//input[@placeholder='Person Name']")).sendKeys(map.get("relName"));

        driver.findElement(By.id("next-button")).click(); //click next button

        Thread.sleep(2000);

    }

    @Then("user clicks on confirm button")
    public void user_clicks_on_confirm_button() {
        driver.findElement(By.xpath("//input[@value='Confirm']")).click();
    }

    @Then("user should be navigated to patient details page")
    public void user_should_be_navigated_to_patient_details_page() {
        WebElement patientId = driver.findElement(By.xpath("//em[text()='Patient ID']/following-sibling::span"));
        Assert.assertTrue(patientId.isDisplayed());
    }


}
