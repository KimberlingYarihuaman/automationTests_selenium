package StepDefinitions;

import Functions.ExtentReporter;
import Functions.SeleniumFunctions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import java.io.IOException;
import java.time.Duration;
import java.util.logging.Logger;



public class StepDefinitions {

    public static WebDriver driver;
    SeleniumFunctions functions = new SeleniumFunctions();
    Logger log = Logger.getLogger(StepDefinitions.class.getName());


    public StepDefinitions() {
        driver = Hooks.driver;
}


    @Given("^I enter to the main web: (.*)$")
    public void iEnterToTheMainWebURL(String url) throws Throwable {

        try{

           log.info("Navigate to: " + url);
           driver.get(url);
           driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
           functions.HandleMyWindows.put("Principal", driver.getWindowHandle());
           functions.page_has_loaded();
           ExtentReporter.createStep("Given I enter to the main web: " + url, "PASSED");

        }catch (Exception e){
            ExtentReporter.e=e;
            ExtentReporter.createStep("Given I enter to the main web: " + url, "FAILED");
        }

    }

    @Then("^I load the DOM information (.*)$")
    public void iloadTheDOMInformation(String file) throws Exception {

        try{
           SeleniumFunctions.FileName=file;
           SeleniumFunctions.readJson();
           log.info("Initialize file: " + file);
           ExtentReporter.createStep("Then I load the DOM information " + file, "PASSED");

        }catch (Exception e){
            ExtentReporter.e=e;
            ExtentReporter.createStep("Then I load the DOM information " + file, "FAILED");
        }
    }


    @And("^I click on the (.*) element")
    public void iClickOnElement(String element) throws Exception {

        try{
            functions.clickElement(element);
            ExtentReporter.createStep("And I click on the "+element+" element", "PASSED");

        }catch (Exception e){
            ExtentReporter.e=e;
            ExtentReporter.createStep("And I click on the "+element+" element", "FAILED");
        }
    }

    @And("^I put in the (.*) field with text (.*)")
    public void iPutInTheFieldText(String element, String text) throws Exception {

        try{
            functions.setElementText(element,text);
            ExtentReporter.createStep("And I put in the "+element+" field with text "+text, "PASSED");

        }catch (Exception e){
            ExtentReporter.e=e;
            ExtentReporter.createStep("And I put in the "+element+" field with text "+text, "FAILED");
        }
    }

    @And("^I select on (.*) list the text (.*)")
    public void iSelectOnListTheOption(String element, String text) throws Exception {

        try{
            functions.selectOptionDropdownByText(element,text);
            ExtentReporter.createStep("And I select on "+element+" list the text "+text, "PASSED");

        }catch (Exception e){
            ExtentReporter.e=e;
            ExtentReporter.createStep("And I select on "+element+" list the text "+text, "FAILED");
        }
    }

    @And("^I check on the (.*) check")
    public void iCheckOnCheck(String element) throws Exception {

        try{
            functions.checkCheckbox(element);
            ExtentReporter.createStep("And I check on the "+element+" check", "PASSED");

        }catch (Exception e){
            ExtentReporter.e=e;
            ExtentReporter.createStep("And I check on the "+element+" check", "FAILED");
        }
    }

    @And("^I scroll to element (.*)")
    public void iScrollElement(String element) throws Exception {

        try{
            functions.scrollToElement(element);
            ExtentReporter.createStep("And I scroll to element "+element, "PASSED");
        }catch (Exception e){
            ExtentReporter.e=e;
            ExtentReporter.createStep("And I scroll to element "+element, "FAILED");
        }
    }

    @Then("^The expected result for (.*) element must have been: (.*)")
    public void theExpectedResultMustHaveBeenResult(String element,String expectedResult) throws Exception {

        try{
            String currentResult=functions.getTextDisplayed(element);
            Assert.assertEquals(currentResult,expectedResult,"ERROR in the assertion");
            ExtentReporter.createStep("Then The expected result must have been: "+expectedResult, "PASSED");
            log.info("The current result is: "+currentResult +" and the expected result is: "+expectedResult);

        }catch (Exception e){
            ExtentReporter.e=e;
            ExtentReporter.createStep("Then The expected result must have been: "+expectedResult, "FAILED");
        }
    }


    @And("^I clear the (.*) field")
    public void iClearField(String element) throws Exception {

        try{
            functions.clearField(element);
            ExtentReporter.createStep("And I clear the "+element+" field", "PASSED");
            log.info("The element " + element+" was cleaned.");

        }catch (Exception e){
            ExtentReporter.e=e;
            ExtentReporter.createStep("And I clear the "+element+" field", "FAILED");
        }
    }

    @And("^I open another website through the URL: (.*)")
    public void iOpenAnotherWesiteThroughURL(String URL) throws Exception {


        try{

            //((JavascriptExecutor)driver).executeScript("window.open('"+url+"')");
            driver.navigate().to(URL);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            functions.HandleMyWindows.put(driver.getTitle(), driver.getWindowHandle());
            functions.page_has_loaded();
            ExtentReporter.createStep("And I open another website through the URL: "+URL, "PASSED");

        }catch (Exception e){
            ExtentReporter.e=e;
            ExtentReporter.createStep("And I open another website through the URL: "+URL, "FAILED");
        }
    }

    @And("^I see the result for (.*) seconds")
    public void iSeeTheResultForXSeconds(int seconds) throws InterruptedException, IOException {

        int miliseconds=(seconds*1000);

        try{
            Thread.sleep(miliseconds);
            ExtentReporter.createStep("And I see the result for "+seconds+" seconds", "PASSED");

        }catch (Exception e){
            ExtentReporter.e=e;
            ExtentReporter.createStep("And I see the result for "+seconds+" seconds", "FAILED");
        }
    }

    @And("^I press the ENTER key on the (.*) element")
    public void iPressTheENTERKey(String element) throws InterruptedException, IOException {

        try{
            functions.pressENTERkey(element);
            ExtentReporter.createStep("And I press the ENTER key on the "+element+" element", "PASSED");

        }catch (Exception e){
            ExtentReporter.e=e;
            ExtentReporter.createStep("And I press the ENTER key on the "+element+" element", "FAILED");
        }
    }

    @And("^I switch to the (.*) tab")
    public void iSwitchTab(int tabnumber) throws InterruptedException, IOException {

        try{
            functions.switchTab(tabnumber);
            ExtentReporter.createStep("And I switch to the "+tabnumber+" tab", "PASSED");

        }catch (Exception e){
            ExtentReporter.e=e;
            ExtentReporter.createStep("And I switch to the "+tabnumber+" tab", "FAILED");
        }
    }

    @And("^I press the (.*) button of the alert")
    public void iPressAButtonOfTheAlert(String typeButton) throws IOException {

        try{
            functions.pressButtonAlert(typeButton);
            ExtentReporter.createStep("And I press the "+typeButton+ " button of the alert", "PASSED");

        }catch (Exception e){
            ExtentReporter.e=e;
            ExtentReporter.createStep("And I press the "+typeButton+ " button of the alert", "FAILED");
        }
    }

    @And("^I put on the alert with text (.*)")
    public void iPutOnTheAlertTheText(String text) throws IOException {

        try{
            functions.sendTextAlert(text);
            ExtentReporter.createStep("And I put on the alert with text "+text, "PASSED");

        }catch (Exception e){
            ExtentReporter.e=e;
            ExtentReporter.createStep("And I put on the alert with text "+text, "FAILED");
        }
    }

    @And("^I get the message on the alert")
    public void iGetTheMessageOnTheAlert() throws IOException {

        String messageAlert=null;

        try{
            messageAlert=functions.getTextAlert();
            ExtentReporter.createStep("And I get the message on the alert, this is: "+messageAlert, "PASSED");

        }catch (Exception e){
            ExtentReporter.e=e;
            ExtentReporter.createStep("And I get the message on the alert, this is: "+messageAlert, "FAILED");
        }
    }

    @And("^I click on the (.*) element in the modal")
    public void iClickOnTheElementModal(String typeElement) throws IOException {


        try{
            functions.clickElementModal(typeElement);
            ExtentReporter.createStep("And I click on the "+typeElement+ " element in the modal", "PASSED");

        }catch (Exception e){
            ExtentReporter.e=e;
            ExtentReporter.createStep("And I click on the "+typeElement+" element in the modal", "FAILED");
        }
    }

    @And("^I get the message of the modal")
    public void iGetTheMessageOfTheModal() throws IOException {

        String messageModal=null;

        try{
            messageModal= functions.getTextModal();
            ExtentReporter.createStep("And I get the message of the modal, this is: "+messageModal, "PASSED");

        }catch (Exception e){
            ExtentReporter.e=e;
            ExtentReporter.createStep("And I get the message of the modal, this is: "+messageModal, "FAILED");
        }
    }

    @And("^I click the (.*) element and attach the ubicated file in the path: (.*)")
    public void iClickTheElementAttachUbicatedFile(String element, String path) throws IOException {


        try{
            functions.uploadFile(element,path);
            ExtentReporter.createStep("And I click the "+element+" element and attach the ubicated file in the path: "+path, "PASSED");

        }catch (Exception e){
            ExtentReporter.e=e;
            ExtentReporter.createStep("And I click the "+element+" element and attach the ubicated file in the path: "+path, "FAILED");
        }
    }



}
