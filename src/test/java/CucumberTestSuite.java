import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty","rerun:rerun.txt"},
        features = "classpath:features",
        glue = {"com.employeemanagement.stepdefinitions"}
)
public class CucumberTestSuite {}
