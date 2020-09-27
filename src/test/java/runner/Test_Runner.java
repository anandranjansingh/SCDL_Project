package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features= {"src/test/resources/sdet.assign.testCases.features/Assignment_1.feature"},
		glue= {"StepDef"},
		dryRun=false,
		plugin= {"html:target/assignment_op.html","junit:target/assignment_op.xml","json:target/assignment_op.json"},
		tags="@All")
public class Test_Runner {

}
