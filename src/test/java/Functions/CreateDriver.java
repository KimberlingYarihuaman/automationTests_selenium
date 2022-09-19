package Functions;

import org.openqa.selenium.WebDriver;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CreateDriver {

    private static String browser, os, logLevel;
    private static Properties prop = new Properties();
    private static FileReader in;

    static {
        try {
            in = new FileReader("src/test/config.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static Logger log = Logger.getLogger(CreateDriver.class.getName());

    /** Initialized driver in the constructor method **/

    private CreateDriver() throws IOException {
        CreateDriver.initConfig();
    }


    public static WebDriver initConfig() throws IOException {
        WebDriver driver;

        try {
            log.info("________________________________________________________________________________");
            log.info("Read the basic properties configuration from: ../AutomationProject/src/test/config.properties");
            prop.load(in);
            browser = prop.getProperty("browser");
            os = prop.getProperty("os");
            logLevel = prop.getProperty("logLevel");

        } catch (IOException e) {
            log.log(Level.SEVERE, "initConfig Error", e);
        }

        /** Information **/
        log.info("OS: " + os + ", Browser: " + browser + ", ");
        log.info("Logger Level: " + logLevel);

        /** Load the driver, specificing your data**/
        driver = WebDriverFactory.createNewWebDriver(browser, os);

        return driver;
    }

}