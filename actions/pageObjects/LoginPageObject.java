package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.LoginPageUI;

public class LoginPageObject extends BasePage{
	private WebDriver driver;
	
	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToLoginButton() {
		waitForElementClickabe(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		
	}

	public String getErrorMessageAtEmailTextbox() {
		waitForElementVisible(driver, LoginPageUI.LOGIN_ERROR_MESSAGE_TEXTBOX);
		return getElementText(driver, LoginPageUI.LOGIN_ERROR_MESSAGE_TEXTBOX);
	}

	public void inputToEmailTextbox(String email) {
		waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, email);
	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
	}

	public String getErrorMessageAtEmailTextboxIsNotRegisterYet() {
		waitForElementVisible(driver, LoginPageUI.LOGIN_ERROR_MESSAGE_NOT_EXIST_TEXTBOX);
		return getElementText(driver, LoginPageUI.LOGIN_ERROR_MESSAGE_NOT_EXIST_TEXTBOX);
	}

}