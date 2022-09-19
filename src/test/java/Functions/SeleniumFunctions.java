package Functions;

import StepDefinitions.StepDefinitions;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.logging.Logger;
import StepDefinitions.Hooks;
import org.openqa.selenium.support.ui.Select;


public class SeleniumFunctions {

    static WebDriver driver;
    public static Properties prop=new Properties();
    static Logger log = Logger.getLogger(StepDefinitions.class.getName());
    public static Map<String, String> HandleMyWindows = new HashMap<>();
    public static String FileName = "";
    public static String GetFieldBy = "";
    public static String ValueToFind = "";



    public SeleniumFunctions(){
        driver =Hooks.driver;
    }


    public void page_has_loaded () {
        String GetActual = driver.getCurrentUrl();
        System.out.println(String.format("Checking if %s page is loaded.", GetActual));
        log.info(String.format("Checking if %s page is loaded.", GetActual));
        log.info("The following are the tabs are opened now: ");
        System.out.println();

        for(String key: HandleMyWindows.keySet()){
              String value= HandleMyWindows.get(key);
              System.out.println("Key: "+key+" , value: "+value);
        }
    }


    public static Object readJson() throws Exception {

        prop.load(new FileReader("src/test/config.properties"));
        FileReader reader = new FileReader( prop.getProperty("PagesFilePath")+ FileName);

        try {

            if (reader != null) {
                JSONParser jsonParser = new JSONParser();
                return jsonParser.parse(reader);
            } else {
                return null;
            }
        } catch (FileNotFoundException | NullPointerException e) {
            log.info("ReadEntity: No existe el archivo " + FileName);
            throw new IllegalStateException("ReadEntity: No existe el archivo " + FileName, e);
        }
    }


    public static By getCompleteElement(String element) throws Exception {
        By result = null;
        JSONObject Entity = ReadEntity(element);

        GetFieldBy = (String) Entity.get("GetFieldBy");
        ValueToFind = (String) Entity.get("ValueToFind");

        if ("className".equalsIgnoreCase(GetFieldBy)) {
            result = By.className(ValueToFind);
        } else if ("cssSelector".equalsIgnoreCase(GetFieldBy)) {
            result = By.cssSelector(ValueToFind);
        } else if ("id".equalsIgnoreCase(GetFieldBy)) {
            result = By.id(ValueToFind);
        } else if ("linkText".equalsIgnoreCase(GetFieldBy)) {
            result = By.linkText(ValueToFind);
        } else if ("name".equalsIgnoreCase(GetFieldBy)) {
            result = By.name(ValueToFind);
        } else if ("link".equalsIgnoreCase(GetFieldBy)) {
            result = By.partialLinkText(ValueToFind);
        } else if ("tagName".equalsIgnoreCase(GetFieldBy)) {
            result = By.tagName(ValueToFind);
        } else if ("xpath".equalsIgnoreCase(GetFieldBy)) {
            result = By.xpath(ValueToFind);
        }
        return result;
    }


    public static JSONObject ReadEntity(String element) throws Exception {
        JSONObject Entity = null;

        JSONObject jsonObject = (JSONObject) readJson();
        Entity = (JSONObject) jsonObject.get(element);
        log.info(Entity.toJSONString());
        return Entity;
    }

    public void clickElement(String element) throws Exception {
        By SeleniumElement = SeleniumFunctions.getCompleteElement(element);
        driver.findElement(SeleniumElement).click();
        log.info("Click on element by " + element);
    }

    public void setElementText(String element, String text) throws Exception {
        By SeleniumElement = SeleniumFunctions.getCompleteElement(element);
        driver.findElement(SeleniumElement).sendKeys(text);
        log.info(String.format("Put on element %s with text %s", element, text));
    }

    public void selectOptionDropdownByText(String element, String option) throws Exception
    {
        By SeleniumElement = SeleniumFunctions.getCompleteElement(element);
        log.info(String.format("Waiting Element: %s", element));

        Select opt = new Select(driver.findElement(SeleniumElement));
        log.info("Select option: " + option + "by text");
        opt.selectByVisibleText(option);
    }

    public void checkCheckbox(String element) throws Exception
    {
        By SeleniumElement = SeleniumFunctions.getCompleteElement(element);
        boolean isChecked = driver.findElement(SeleniumElement).isSelected();
        if(!isChecked){
            log.info("Clicking on the checkbox to select: " + element);
            driver.findElement(SeleniumElement).click();
        }
    }

    public String getTextDisplayed(String element) throws Exception
    {
        Thread.sleep(2000);
        By SeleniumElement=SeleniumFunctions.getCompleteElement(element);
        String text=null;
        boolean isDisplayed=driver.findElement(SeleniumElement).isDisplayed();

        if(isDisplayed==true){
            text=driver.findElement(SeleniumElement).getText();
        }else{
            System.out.printf("The element %s isn't displayed so it doesn't display any text", element);
        }

        return text;
    }

    public void scrollToElement(String element) throws Exception
    {
        By SeleniumElement = SeleniumFunctions.getCompleteElement(element);
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        log.info("Scrolling to element: " + element);
        jse.executeScript("arguments[0].scrollIntoView();", driver.findElement(SeleniumElement));
    }

    public void clearField(String element) throws Exception
    {
        By SeleniumElement = SeleniumFunctions.getCompleteElement(element);
        driver.findElement(SeleniumElement).clear();
    }

    public void pressENTERkey(String element) throws Exception
    {
        By SeleniumElement =SeleniumFunctions.getCompleteElement(element);
        driver.findElement(SeleniumElement).sendKeys(Keys.ENTER);
    }

    public void switchTab(int tabNumber)
    {
        Set<String> handles=driver.getWindowHandles();
        int i=0;

        for(String key: handles){
            i++;

                if(i==tabNumber){
                   driver.switchTo().window(key);
                   log.info("Switching to the "+key+" tab");
                   break;
                }
            }
    }

    public void pressButtonAlert(String typeButton)
    {
        Alert alert=driver.switchTo().alert();

        if(typeButton.equalsIgnoreCase("Accept")){
            alert.accept();
            log.info("Pressing the "+typeButton+" button on the alert...");

        }else if(typeButton.equalsIgnoreCase("Cancel")){
            alert.dismiss();
            log.info("Pressing the "+typeButton+" button on the alert...");

        }else{
            log.info("The "+ typeButton+ " button doesn't exist");
        }

    }

    public  void sendTextAlert(String text)
    {
        Alert alert=driver.switchTo().alert();
        alert.sendKeys(text);
        log.info("Sending the text to the alert: "+text);
    }

    public String getTextAlert()
    {
        Alert alert=driver.switchTo().alert();
        String messageAlert=alert.getText();
        log.info("Getting the text on the alert, this is: "+messageAlert);

        return messageAlert;
    }

    public void clickElementModal(String typeElement) throws Exception {

        By SeleniumElement = SeleniumFunctions.getCompleteElement(typeElement);
        WebElement modal=driver.switchTo().activeElement();
        modal.findElement(SeleniumElement).click();
        log.info("Clicking the "+typeElement+" element in the modal...");

    }

    public String getTextModal()
    {
        WebElement modal=driver.switchTo().activeElement();
        String messageModal=modal.getText();
        log.info("Getting the text of the modal, this is: "+messageModal);

        return messageModal;
    }

    public void uploadFile(String element, String path) throws Exception
    {
        File file=new File(path);
        String finalPath=file.getAbsolutePath();
        By SeleniumElement=SeleniumFunctions.getCompleteElement(element);
        driver.findElement(SeleniumElement).sendKeys(finalPath);
        log.info("Attaching the file of the path: "+path);
    }



}
