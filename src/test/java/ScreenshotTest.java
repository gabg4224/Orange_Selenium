import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class ScreenshotTest {

    private WebDriver driver;

    @Test
    public void testThatFailsWithScreenshot() {
        driver = new ChromeDriver();
        driver.get("https://example.com");
        // Forzar fallo
        assert driver.getTitle().contains("OrangeHRM");
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            saveScreenshot(driver);  // 👈 Esto debe ejecutarse SÍ o SÍ
        }
        if (driver != null) {
            driver.quit();
        }
    }

    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] saveScreenshot(WebDriver driver) {
        System.out.println(">>> Taking screenshot for Allure <<<");
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}