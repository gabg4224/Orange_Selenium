package pages_courses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.UiExtensions;

public class Handle_windows {
	private WebDriver driver;

	public Handle_windows(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(linkText = "New Tab")
	private WebElement new_tab_button;
	
	
	
	public void click_new_tab_button() {
		UiExtensions.perform_Click_page_factory(new_tab_button);
	}

}
