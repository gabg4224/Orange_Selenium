package orange_pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.UiExtensions;

public class Login_page extends Base_page {


//constructor

	public Login_page(WebDriver driver) {
		super(driver);
	}

	// Locators

	@FindBy(name = "username")
	private WebElement userNameField;

	@FindBy(name = "password")
	private WebElement passwordField;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement btnLogin;

	@FindBy(xpath = "//p[text()='Invalid credentials']")
	private WebElement invalid_credentials_message;

	// methods

	public void introduce_user_name(String user) {
		perform_Introduce_Text(userNameField, user); 

	}

	public void introduce_password(String pass) {
		perform_Introduce_Text(passwordField, pass);

	}

	public Dashboard click_login() {

		perform_Click(btnLogin);
		try {
			new WebDriverWait(driver, Duration.ofSeconds(10))
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[text()='Dashboard']")));
		} catch (TimeoutException e) {
			// Login might have failed, so don't block test — let validation handle it
		}

		return new Dashboard(driver);

	}

	public boolean invalid_credentials_validation() {
		try {
			waitForElement(invalid_credentials_message);
			return invalid_credentials_message.isDisplayed();
		} catch (TimeoutException e) {
			e.printStackTrace();
			return false;
		}
	}

}
