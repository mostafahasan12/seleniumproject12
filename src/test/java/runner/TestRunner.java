package runner;

import io.cucumber.testng.CucumberOptions;
import tests.TestBase;

@CucumberOptions(features="src/test/java/features/UserRegisterion.feature"

,glue= {"steps"}
,plugin= {"pretty","html:target/cucumber-html-report2"})
public class TestRunner extends TestBase
{
	

}

