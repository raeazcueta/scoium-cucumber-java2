import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "C:/Users/Rae/IdeaProjects/Scoium2/src/test/resources/SearchFeature.feature",
        glue = "WebTableSteps"
)
public class TestRunner {
    public static void main(String[] args) {
        // Run your Cucumber tests

        // Generate the report
        ReportGenerator.generateReport();
    }
}
