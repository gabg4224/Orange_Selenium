package pages_courses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.UiExtensions;

public class Page_iframe {

	private WebDriver driver;

	public Page_iframe(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	// locators

	@FindBy(id = "iframe-1")
	private WebElement playwrite_iframe;

	@FindBy(id = "iframe-2")
	private WebElement selenium_iframe;

	@FindBy(linkText = "Community")
	private WebElement community_playwrite;

	@FindBy(tagName = "h1")
	private WebElement playwrite_h1_tittle;
	@FindBy(tagName = "h1")
	private WebElement default_h1_tittle;

	public void access_frame_playwrite() {
		driver.switchTo().frame(playwrite_iframe);

	}

	public void validate_community_tab() {
		UiExtensions.perform_Click_page_factory(community_playwrite);

	}

	public String validate_title_community_playwrite() {
		WebDriverWait wait = new WebDriverWait(driver, null);
		String value = playwrite_h1_tittle.getText();

		return value;
	}
	public String validate_title_default() {
		String value = default_h1_tittle.getText();

		return value;
	}
	

	public void access_frame_selenium() {
		driver.switchTo().frame(selenium_iframe);

	}
	
	public void back_to_normal() {
		
		driver.switchTo().defaultContent();
	}

}
