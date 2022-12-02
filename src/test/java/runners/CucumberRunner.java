package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features =
               {"src/test/resources/features/13SearchBoxVisibility.feature",
                "src/test/resources/features/14SearchByNameRegexp.feature",
                "src/test/resources/features/15SearchByDescription.feature",
                "src/test/resources/features/17SearchedProductsCanBeSorted.feature",
                "src/test/resources/features/19UserIsAbleToWriteReviewAfterPurchase.feature",
                "src/test/resources/features/20ProductPageCompare.feature",
                "src/test/resources/features/18AbleToOpenProductPage&AddProductToCart.feature"},

        plugin = {"pretty", "html:cucumber-report/html-report.html",
                "junit:cucumber-report/junit-report.xml",
                "json:cucumber-report/json-report.json"},
        tags = "not @test and not @bug",
        glue = {"stepDefinitions"}
)
public class CucumberRunner {

}
