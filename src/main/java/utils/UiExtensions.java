package utils;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UiExtensions {

	public static void perform_Introduce_Text(WebDriver driver, By locator, String value) {

		driver.findElement(locator).click();
		driver.findElement(locator).sendKeys(Keys.CONTROL + "a");
		driver.findElement(locator).sendKeys(Keys.BACK_SPACE);
		driver.findElement(locator).clear();
		driver.findElement(locator).sendKeys(value);
		;

	}

	public static void waiter(WebDriver driver, WebElement locator) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(locator));
		;

	}

	public static void perform_Introduce_Text_page_factory(WebElement locator, String value) {

		locator.click();
		locator.sendKeys(Keys.CONTROL + "a");
		locator.sendKeys(Keys.BACK_SPACE);
		locator.clear();
		locator.sendKeys(value);
		;

	}

	public static void perform_Click(WebDriver driver, By locator) {
		driver.findElement(locator).click();

		;

	}

	public static void perform_Click_page_factory(WebElement locator) {
		locator.click();

		;

	}

	public static WebDriver navigate_Handler(String value) {

		ChromeOptions options = new ChromeOptions();

		// Desactiva alertas de notificaciones y seguridad
	    options.addArguments("--incognito");
	    options.addArguments("--disable-notifications");
	    options.addArguments("--disable-popup-blocking");
	    options.addArguments("--disable-blink-features=AutomationControlled");
	    options.addArguments("--disable-infobars");

	    options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
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

	/*
	 * public static void select_in_dropdown(WebDriver driver, WebElement
	 * first_locator, WebElement second_locator, By link, String value) {
	 * 
	 * UiExtensions.perform_Click_page_factory(first_locator); WebDriverWait wait =
	 * new WebDriverWait(driver, Duration.ofSeconds(5));
	 * 
	 * WebElement dropdown =
	 * wait.until(ExpectedConditions.elementToBeClickable(second_locator));
	 * 
	 * List<WebElement> list = dropdown.findElement(link);
	 * 
	 * for (WebElement option : list) {
	 * 
	 * if (option.getText().equals(value)) {
	 * 
	 * option.click(); break; }
	 * 
	 * }
	 * 
	 * }
	 */

}