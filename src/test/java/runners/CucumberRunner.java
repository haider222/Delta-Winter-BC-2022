package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features/Aivars.feature",
                "src/test/resources/features/Inga.feature",
                "src/test/resources/features/Vlads.feature",
                "src/test/resources/features/Victor.feature"},
        plugin = {"pretty", "html:cucumber-report/html-report",
                "junit:cucumber-report/junit-report.xml",
                "json:cucumber-report/json-report.json"},
        tags = "@test and not @bug",
        glue = {"stepDefinitions"}
)
public class CucumberRunner {

}
