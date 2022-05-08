package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.HomePageUI;

public class HomePageObject extends BasePage {
	private WebDriver driver;
	
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickToRegisterLink() {
		waitForElementClickabe(driver, HomePageUI.REGISTER_LINK);
		clickToElement(driver, HomePageUI.REGISTER_LINK);
	}

	public void clickToLoginLink() {
		waitForElementClickabe(driver, HomePageUI.LOGIN_LINK);
		clickToElement(driver, HomePageUI.LOGIN_LINK);
	}

	public String getSuccessHomePage() {
		waitForElementVisible(driver, HomePageUI.SUCCESS_HOMEPAGE_TEXTBOX);
		return getElementText(driver, HomePageUI.SUCCESS_HOMEPAGE_TEXTBOX);
	}
}
