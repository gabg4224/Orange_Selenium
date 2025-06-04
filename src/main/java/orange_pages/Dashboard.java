package orange_pages;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import orange_pages.components.Side_menu;

public class Dashboard extends Base_page {

	public Side_menu side_menu;

	public Dashboard(WebDriver driver) {
		super(driver);
		this.side_menu = new Side_menu(driver);
	}

	@FindBy(xpath = "//h6[text()='Dashboard']")
	private WebElement dashboard_title;

	public boolean is_dashboard_visible() {

		try {

			waitForElement(dashboard_title);
			return dashboard_title.isDisplayed();

		} catch (RuntimeException e) {
			return false;
		}

	}

}
