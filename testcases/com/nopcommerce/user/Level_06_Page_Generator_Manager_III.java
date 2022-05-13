package com.nopcommerce.user;

import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.MyAccountPageObject;
import pageObjects.PageGeneratorManager;
import pageObjects.RegisterPageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_06_Page_Generator_Manager_III extends BaseTest{
	private WebDriver driver;
	private HomePageObject homePage;
	private LoginPageObject loginPage;
	private RegisterPageObject registerPage;
	private String projectPath = System.getProperty("user.dir");
	private String firstName, lastName, invalidEmail, notFoundEmail,existingEmail, password;
	private MyAccountPageObject myAccountPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		
		homePage = PageGeneratorManager.getHomePage(driver);
		
		firstName = "Automation";
		lastName  = "FC";
		invalidEmail  = "afc@ss@.&%";
		existingEmail = "afc" + generateFakeNumber() + "@mail.vn";
		notFoundEmail  = "afc" + generateFakeNumber() + "@mail.com";
		password  = "123456";
		
		System.out.println("Pre-condition - Step 01: Click to Register link");
		registerPage = homePage.clickToRegisterLink();

		System.out.println("Pre-condition - Step 02: Input to required fields");
		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailTextbox(existingEmail);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);

		System.out.println("Pre-condition - Step 03: Click to Register button");
		registerPage.clickToRegisterButton();

		System.out.println("Pre-condition - Step 04: Verify success message displayed");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		System.out.println("Pre-condition - Step 05: Click to Logout link");
		homePage = registerPage.clickToLogoutLink();
	}

	@Test
	public void Login_01_Empty_Data() {
		loginPage = homePage.clickToLoginLink();

		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Please enter your email");
	}

	@Test
	public void Login_02_Invalid_Email() {
		loginPage = homePage.clickToLoginLink();
		
		loginPage.inputToEmailTextbox(invalidEmail);
		loginPage.clickToLoginButton();
		
		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Wrong email");
	}

	@Test
	public void Login_03_Email_Not_Found() {
		loginPage = homePage.clickToLoginLink();
		
		loginPage.inputToEmailTextbox(notFoundEmail);
		loginPage.clickToLoginButton();
		
		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextboxIsNotRegisterYet(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
	}
	
	@Test
	public void Login_04_Existing_Email_Empty_Password() {
		loginPage = homePage.clickToLoginLink();
		
		loginPage.inputToEmailTextbox(existingEmail);
		loginPage.inputToPasswordTextbox("");
		loginPage.clickToLoginButton();
		
		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextboxIsNotRegisterYet(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}
	
	@Test
	public void Login_05_Existing_Email_Incorrect_Password() {
		loginPage = homePage.clickToLoginLink();
		
		loginPage.inputToEmailTextbox(existingEmail);
		loginPage.inputToPasswordTextbox("222333");
		loginPage.clickToLoginButton();
		
		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextboxIsNotRegisterYet(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}

	@Test
	public void Login_06_Valid_Email_Password() {
		loginPage = homePage.clickToLoginLink();
		
		loginPage.inputToEmailTextbox(existingEmail);
		loginPage.inputToPasswordTextbox(password);
		
		homePage = loginPage.clickToLoginButton();
		Assert.assertTrue(homePage.isMyAccountDisplayed());
		
		myAccountPage = homePage.clickToMyAccountLink();
	}


	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
