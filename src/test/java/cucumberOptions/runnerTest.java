package cucumberOptions;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions
(features="src\\test\\java\\features",
glue = "com.MHS.testCases",strict =true, monochrome =true,
plugin= {"pretty","json:target/cucumber-report/cucumber.json","junit:target/cucumber.xml","html:target/cucumber-report/cucumber.html"
		 , "rerun:rerun/failed_scenarios.txt"}

		)

public class runnerTest {	

}
