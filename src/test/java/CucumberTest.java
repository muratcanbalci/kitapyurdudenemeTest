import cucumber.api.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources",
        glue = "stepDefinitions",
        format = {"json:target/cucumber.json"}
)
public class CucumberTest {
}
