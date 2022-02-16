package step_definitions;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Then;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.jar.JarOutputStream;
import java.util.stream.Collectors;

/**
 * Created by tairovich_jr on 2022-02-15.
 */
public class ExampleStepDefs {

    @Then("user logs in")
    public void user_logs_in() {
        System.out.println("user is on the login page");
    }

    @Then("users clicks on register link")
    public void users_clicks_on_register_link() {
        System.out.println("user clicks on register link");
    }

    @Then("user uses below data to register")
    public void user_uses_below_data_to_register(List<Map<String,String>> dataTable) {

        Map<String, String> row = dataTable.get(0); //first row

        String firstName = row.get("firstName");
        String lastName = row.get("lastName");

        System.out.println(firstName + " " + lastName);
    }



}
