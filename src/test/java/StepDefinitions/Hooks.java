package StepDefinitions;

import Functions.CreateDriver;
import Functions.ExtentReporter;
import io.cucumber.java.*;
import org.openqa.selenium.WebDriver;
import java.io.IOException;
import java.util.logging.Logger;


public class Hooks{

    public static WebDriver driver;
    static Logger log = Logger.getLogger(Hooks.class.getName());
    Scenario scenario = null;
    static ExtentReporter customExtentReporter;

    static {
        try {
            customExtentReporter = new ExtentReporter();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public Hooks() throws IOException {

    }


    @Before
    public void initDriver(Scenario scenario) throws IOException {
        log.info("__________________________________________________________________");
        log.info("Initializing driver configuration");
        log.info("__________________________________________________________________");
        driver = CreateDriver.initConfig();
        this.scenario = scenario;
        log.info("__________________________________________________________________");
        log.info("[ Scenario ] - "+ scenario.getName());
        log.info("__________________________________________________________________");
        customExtentReporter.createScenario(scenario);
    }





    @After
    public void quit(){
        log.info("__________________________________________________________________");
        log.info("Clean and close the intance of the driver");
        log.info("__________________________________________________________________");
        driver.quit();

    }

    @AfterAll
    public static void clearReport(){
        customExtentReporter.tearDown();
    }

}
