package com.nopcommerce.user;

import org.testng.annotations.Test;

import commons.BasePage;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;

import org.testng.annotations.BeforeClass;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_03_Page_Object_Login {
	private WebDriver driver;
	private HomePageObject homePage;
	private LoginPageObject loginPage;
	private RegisterPageObject registerPage;
	private String projectPath = System.getProperty("user.dir");
	private String firstName, lastName, emailAddress, password;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
		
		homePage = new HomePageObject(driver);
		loginPage = new LoginPageObject(driver);
		registerPage = new RegisterPageObject(driver);
		
		firstName = "Automation";
		lastName  = "FC";
		emailAddress = "afc" + generateFakeNumber() + "@mail.vn";
		password  = "123456";
	}

	@Test
	public void TC_01_Login_Empty_Data() {
		System.out.println("Home Page - Step 01: Click to Login link");
		homePage.clickToLoginLink();

		System.out.println("Login Page - Step 02: Click to Login button");
		loginPage.clickToLoginButton();

		System.out.println("Register Page - Step 03: Verify error message displayed");
		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Please enter your email");
	}

	@Test
	public void TC_02_Login_Invalid_Email() {
		System.out.println("Home Page - Step 01: Click to Login link");
		homePage.clickToLoginLink();
		
		System.out.println("Login Page - Step 02: Input to required fields");
		loginPage.inputToEmailTextbox("afc@ss@.&%");
		
		System.out.println("Login Page - Step 03: Click to Login button");
		loginPage.clickToLoginButton();
		
		System.out.println("Register Page - Step 04: Verify error message displayed");
		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Wrong email");
	}

	@Test
	public void TC_03_Login_Email_Not_Register_Yet() {
		System.out.println("Home Page - Step 01: Click to Login link");
		homePage.clickToLoginLink();
		
		System.out.println("Login Page - Step 02: Input to required fields");
		loginPage.inputToEmailTextbox(emailAddress);
		loginPage.inputToPasswordTextbox(password);
		
		System.out.println("Login Page - Step 03: Click to Login button");
		loginPage.clickToLoginButton();
		
		System.out.println("Register Page - Step 04: Verify error message displayed");
		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextboxIsNotRegisterYet(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
	}
	
	@Test
	public void TC_04_Login_Success() {
		System.out.println("Home Page - Step 01: Click to Register link");
		homePage.clickToRegisterLink();

		System.out.println("Register Page - Step 02: Input to required fields");
		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);

		System.out.println("Register Page - Step 03: Click to Register button");
		registerPage.clickToRegisterButton();
		
		System.out.println("Register Page - Step 04: Click to Logout button");
		registerPage.clickToLogoutLink();
		
		System.out.println("Home Page - Step 05: Click to Login link");
		homePage.clickToLoginLink();
		
		System.out.println("Login Page - Step 06: Input to required fields");
		loginPage.inputToEmailTextbox(emailAddress);
		loginPage.inputToPasswordTextbox(password);
		
		System.out.println("Login Page - Step 07: Click to Login button");
		loginPage.clickToLoginButton();
		
		System.out.println("Register Page - Step 08: Verify error message displayed");
		Assert.assertEquals(homePage.getSuccessHomePage(), "Copyright © 2022 nopCommerce demo store. All rights reserved.");
		
		System.out.println("Register Page - Step 09: Click to Logout button");
		registerPage.clickToLogoutLink();
	}

	@Test
	public void TC_05_Login_Email_Existed_But_Not_Input_Password() {
		System.out.println("Home Page - Step 01: Click to Login link");
		homePage.clickToLoginLink();
		
		System.out.println("Login Page - Step 02: Input to required fields");
		loginPage.inputToEmailTextbox(emailAddress);
		loginPage.inputToPasswordTextbox("");
		
		System.out.println("Login Page - Step 03: Click to Login button");
		loginPage.clickToLoginButton();
		
		System.out.println("Register Page - Step 04: Verify error message displayed");
		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextboxIsNotRegisterYet(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}

	@Test
	public void TC_06_Login_Email_Existed_But_Invalid_Password() {
		System.out.println("Home Page - Step 01: Click to Login link");
		homePage.clickToLoginLink();
		
		System.out.println("Login Page - Step 02: Input to required fields");
		loginPage.inputToEmailTextbox(emailAddress);
		loginPage.inputToPasswordTextbox("333333");
		
		System.out.println("Login Page - Step 03: Click to Login button");
		loginPage.clickToLoginButton();
		
		System.out.println("Register Page - Step 04: Verify error message displayed");
		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextboxIsNotRegisterYet(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	public int generateFakeNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}
}
