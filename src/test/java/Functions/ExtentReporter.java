package Functions;

import StepDefinitions.StepDefinitions;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import java.util.logging.Logger;


public class ExtentReporter {

    public static WebDriver driver;
    ExtentSparkReporter spark;
    public static ExtentReports extent;
    public static ExtentTest test;
    static Properties prop = new Properties();
    static public Exception e;
    static Logger log = Logger.getLogger(ExtentReporter.class.getName());



   public ExtentReporter() throws IOException {

       prop.load(new FileReader("src/test/config.properties"));
       String dateCurrent= new SimpleDateFormat("dd-MM-yyyy HH.mm.ss").format(Calendar.getInstance().getTime());
       spark = new ExtentSparkReporter(prop.getProperty("TestReport")+"TestReport-" +dateCurrent+".html");
       extent = new ExtentReports();
       extent.attachReporter(spark);
   }


   public void createScenario(Scenario scenario){

       String scenarioName=getScenarioTitle(scenario);
       test= extent.createTest(scenarioName);
   }

    public static void createStep(String stepName, String status) throws IOException {

       String dest;

       if(status.equalsIgnoreCase("PASSED")){
           test.log(Status.PASS, stepName);
           //dest=createScreenshot(status);
           //test.log(Status.INFO, "Passed Evidence:", MediaEntityBuilder.createScreenCaptureFromPath(dest).build());

       }else if(status.equalsIgnoreCase("FAILED")){
           test.log(Status.FAIL, stepName);
           test.log(Status.INFO, e);
           dest=createScreenshot(status);
           test.log(Status.INFO, "Failed Evidence:", MediaEntityBuilder.createScreenCaptureFromPath(dest).build());

       }else if(status.equalsIgnoreCase("SKIPPED")){
           test.log(Status.SKIP, stepName);

       }else{
           test.log(Status.WARNING, "The scenario doesn't exist. It's UNDEFINED");

       }
    }

    public static String createScreenshot(String status) throws IOException {

        String dateCurrent, dest = null;
        File source, destination;
        TakesScreenshot ts;
        dateCurrent= new SimpleDateFormat("dd-MM-yyyy HH.mm.ss").format(Calendar.getInstance().getTime());
        prop.load(new FileReader("src/test/config.properties"));
        driver=StepDefinitions.driver;

        try {

            ts= (TakesScreenshot) driver;
            if(status.equalsIgnoreCase("Passed")) {

                log.info("The scenario passed.");
                log.info("\"Current Page URL is: \" + driver.getCurrentUrl()");
                dest = prop.getProperty("PassedTestEvidences") +"img_"+ dateCurrent + ".png";

            }else if (status.equalsIgnoreCase("Failed")) {

                log.info("The scenario failed.");
                log.info("\"Current Page URL is: \" + driver.getCurrentUrl()");
                dest = prop.getProperty("FailedTestEvidences") +"img_"+ dateCurrent + ".png";
            }

            //Make an image into the path (dest) of the folder
            source = ts.getScreenshotAs(OutputType.FILE);
            destination = new File(dest);
            Thread.sleep(1000);     //A second of the difference for that doesn't overwrite the images
            FileUtils.copyFile(source, destination);

        } catch (Exception e) {
            System.out.println(e);
        }

        return dest;
    }


   public String getScenarioTitle(Scenario scenario){

       return scenario.getName().replaceAll(" ", "");
   }

   public void tearDown(){
       extent.flush();
   }

}
