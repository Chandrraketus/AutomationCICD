package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/cucumber",glue ="rahulshettyacasemy.stepDefinations",monochrome=true,tags = "@Regression",plugin= {"html:target/cucumber.html"})                                                                //Here we have to give path of our feature file.
public class TestNGTestRunner extends AbstractTestNGCucumberTests {
	
	
	
	
}


