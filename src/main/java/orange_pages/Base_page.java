package orange_pages;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.Data_generator;

public class Base_page {
	protected WebDriver driver;
	protected WebDriverWait wait;
	protected Data_generator dataGen = new Data_generator();

	public Base_page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));

	}

	public void perform_Introduce_Text(WebElement locator, String value) {
		wait.until(ExpectedConditions.visibilityOf(locator));
		locator.click();
		locator.sendKeys(Keys.CONTROL + "a");
		locator.sendKeys(Keys.BACK_SPACE);
		locator.clear();
		locator.sendKeys(value);
		;
		System.out.println("bug fix");


		System.out.println("conflict resolution feature");

		System.out.println("conflict resolution fix");

		System.out.println("conflict resolution");



	}

	public void waitForElement(WebElement locator) {
		wait.until(ExpectedConditions.visibilityOf(locator));
	}

	public void perform_Click(WebElement locator) {
		wait.until(ExpectedConditions.visibilityOf(locator)).click();

	}

	public String getText(WebElement locator) {

		return wait.until(ExpectedConditions.visibilityOf(locator)).getText();
	}

	public boolean validate_fields(WebElement locator, String value) {

		if (locator.getText().equals(value)) {

			return true;
		} else {

			return false;
		}

	}

	public String generate_random_number(int number, int number2) {
		int value = ThreadLocalRandom.current().nextInt(number, number2 + 1);
		return Integer.toString(value);
	}

	// this is a toggle custom and theres no other way to validate it changes than
	// validating color
	public void turn_on_toggle(WebElement locator) {
		String toggle_off = "#e8eaef";
		String toggle_on = "##ff7b1d";
		if (locator.getCssValue("color") == toggle_off) {
			perform_Click(locator);
		}
	}

	public String no_select_dropdown(WebElement contenedor, String options, String value) {
		perform_Click(contenedor);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		List<WebElement> list = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(options)));

		for (WebElement option : list) {

			if (option.getText().equals(value)) {
				option.click();
				break;

			}
		}

		return value;

	}

	public static WebDriver navigate_Handler(String value) {

		ChromeOptions options = new ChromeOptions();

		// Desactiva alertas de notificaciones y seguridad
		options.addArguments("--incognito");
		options.addArguments("--disable-notifications");
		options.addArguments("--disable-popup-blocking");
		options.addArguments("--disable-blink-features=AutomationControlled");
		options.addArguments("--disable-infobars");

		options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
		options.setExperimentalOption("useAutomationExtension", false);

		Map<String, Object> prefs = new HashMap<>();
		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_enabled", false);
		options.setExperimentalOption("prefs", prefs);

		WebDriver driver = new ChromeDriver(options);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.navigate().to(value);
		driver.manage().window().maximize();

		return driver;

	}

}
