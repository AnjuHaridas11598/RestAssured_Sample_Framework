package com.Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/com/com.API_Features/C2TA_GetAPI.feature",
glue={"com/Stepdefinition","com/Hooks"},plugin = {"pretty", "html:target/cucumber-reports"},
publish = true
)


public class GetAPI_Runnerfile {

}
