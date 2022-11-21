package aoetest.runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/cucumber.json",
                "html:target/default-html-reports.html",
                "rerun:target/rerun.txt"},
        features = "src/test/resources/features",  // from content root
        glue = "aoetest/step_definition",  //from source root
        dryRun = false,
        tags = "@wip"
)
public class CukesRunner {

}
