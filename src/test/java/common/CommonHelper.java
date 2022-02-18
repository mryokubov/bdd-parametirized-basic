package common;

import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by tairovich_jr on 2022-02-17.
 */
public class CommonHelper {


    public void takeScreenshot(Scenario scenario, WebDriver driver){

        if (scenario.isFailed()){
            try {
                byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
                File screenshot_with_scenario_name = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(screenshot_with_scenario_name, new File("./target/screenshots/" +
                        scenario.getName().toLowerCase().replaceAll(" ","_") + getCurrentDateAndTime()  +".png"));
                scenario.embed(screenshot, "image/png");
            }catch (WebDriverException | IOException e){
                e.printStackTrace();
            }
        }
        if (driver != null){
            driver.quit();
        }
    }

    private String getCurrentDateAndTime() {
        String str = null;
        try {
            DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss:SSS");
            Date date = new Date();
            str = dateFormat.format(date);
            str = str.replace(" ","").replaceAll("/","").replaceAll(":","");
        }catch (Exception e){
            e.printStackTrace();
        }
        return str;
    }


}
