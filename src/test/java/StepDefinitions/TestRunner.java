package StepDefinitions;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/Features/GuiaInfantil.feature",
        glue = "src/test/java/StepDefinitions",
        tags = ("@test"),
        //{"com.cucumber.listener.ExtentCucumberFormatter:target/html/ExtentReport.html"}
        plugin = ("com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" )
)

public class TestRunner {
}
