import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty"},
        features = "@rerun.txt",
        glue = {"com.employeemanagement.stepdefinitions"}
)
public class CucumberTestSuiteReRunner {}
