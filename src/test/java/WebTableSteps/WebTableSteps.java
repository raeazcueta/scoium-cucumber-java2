package WebTableSteps; // Update with your package name

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.After;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import static junit.framework.TestCase.fail;
import static org.junit.Assert.assertEquals;

public class WebTableSteps {

    private WebDriver driver;

    @Given("I am on the demo website")
    public void navigateToDemoWebsite() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/Rae/IdeaProjects/Scoium2/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://demo.aspnetawesome.com/");
        driver.manage().window().maximize();
    }

    @When("I select the language")
    public void selectLanguage() {
        WebElement dropdownCaret = driver.findElement(By.id("ddlFmw-awed"));
        dropdownCaret.click();
        WebElement languageModel = driver.findElement(By.xpath("//li[contains(text(),'aweui (Angular, React, Vue)')]"));
        languageModel.click();
    }

    @When("I input the person's name {string}")
    public void enterPersonName(String name) {
        // Wait for the table to load before interacting with the element
        try {
            Thread.sleep(2000); // Adjust the delay based on the page load time
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Actions actions = new Actions(driver);
        WebElement nameInput = driver.findElement(By.id("GridFrowfltPerson-awed"));
        actions.moveToElement(nameInput).perform();
        nameInput.sendKeys(name);
    }

    @Then("I should see the person's details")
    public void verifyPersonDetails(DataTable dataTable) {
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : rows) {
            String label = row.get("Field");
            String expectedValue = "785";  // Set the expected value to "785"

            try {
                WebElement element = driver.findElement(By.xpath("//td[contains(., '785')]"));
                String actualValue = element.getText().trim();
                assertEquals(expectedValue, actualValue);
            } catch (NoSuchElementException e) {
                fail("Element not found: " + expectedValue);
            } catch (AssertionError e) {
                String actualValue = "null";
                fail("Assertion failed - Expected: " + expectedValue + ", Actual: " + actualValue);
            }
        }
    }

    // Additional step definitions can be added here

    @After
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}