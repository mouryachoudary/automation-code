package Testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features",glue= {"stepsdefinaions"},
//monochrome=true,//it remove un neccssary charcters from console
plugin={"pretty","html:test-output"})
//dryRun=true)//with really execution  cross check every feature files corresponding
//step defination are not
public class Testrunner {
	
 
}
