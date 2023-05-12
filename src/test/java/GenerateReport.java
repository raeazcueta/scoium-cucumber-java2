import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

class ReportGenerator {

    public static void generateReport() {
        // Specify the output directory for the report
        File reportOutputDirectory = new File("C:/Users/Rae/IdeaProjects/Scoium2/results/cucumber-reports");

        // Define the list of JSON report files
        List<String> jsonFiles = new ArrayList<>();
        jsonFiles.add("C:/Users/Rae/IdeaProjects/Scoium2/results/cucumber-report.json"); // Replace with the actual path to your JSON report file(s)

        // Configure the report settings
        Configuration configuration = new Configuration(reportOutputDirectory, "your-project-name");
        configuration.setBuildNumber("1.0");

        // Generate the report
        ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
        reportBuilder.generateReports();
    }
}
