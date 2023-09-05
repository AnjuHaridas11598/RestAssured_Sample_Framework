package com.Runner;


import org.junit.runner.RunWith;
import com.Config.ExtentReportConfig;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/C2TA_Features",
glue={"com/StepDefinitions","com/Hooks"},plugin = {"pretty", "html:target/cucumber-reports"},
publish = true, tags= "@PostRequest"
)

public class PostAPI_Runnerfile extends ExtentReportConfig{
	
	

	
	
}
