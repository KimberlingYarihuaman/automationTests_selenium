package Functions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;


public class WebDriverFactory {

    private static Properties prop = new Properties();
    private static FileReader in;

    static {
        try {
            in = new FileReader("src/test/config.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static String resourceFolder;
    private static Logger log = Logger.getLogger(WebDriverFactory.class.getName());
    private static WebDriverFactory instance = null;


    public static WebDriverFactory getInstance() {
        if (instance == null) {
            instance = new WebDriverFactory();
        }
        return instance;
    }


    public static WebDriver createNewWebDriver(String browser, String os) throws IOException {
        WebDriver driver;
        prop.load(in);
        resourceFolder = prop.getProperty("resourceFolder");

        if ("FIREFOX".equalsIgnoreCase(browser)) {
            if("WINDOWS".equalsIgnoreCase(os)){
                System.setProperty("webdriver.gecko.driver", resourceFolder + os + "/geckodriver.exe");
            }
            else{
                System.setProperty("webdriver.gecko.driver", resourceFolder + os + "/geckodriver");
            }
            driver = new FirefoxDriver();
        }

        /** The driver selected is Chrome **/

        else if ("CHROME".equalsIgnoreCase(browser)) {
            if("WINDOWS".equalsIgnoreCase(os)){
                System.setProperty("webdriver.chrome.driver", resourceFolder+os+"/chromedriver.exe");
            }
            else{
                System.setProperty("webdriver.chrome.driver", resourceFolder+os+"/chromedriver");
            }
            driver = new ChromeDriver();

        }

        /**The driver is not selected **/
        else {
            log.log(Level.SEVERE, "The Driver is not selected properly, invalid name: " + browser + ", " + os);
            return null;
        }
        driver.manage().window().maximize();
        return driver;
    }
}
