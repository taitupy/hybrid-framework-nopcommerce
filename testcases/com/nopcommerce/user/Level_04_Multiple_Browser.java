package com.nopcommerce.user;

import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_04_Multiple_Browser extends BaseTest{
	private WebDriver driver;
	private HomePageObject homePage;
	private LoginPageObject loginPage;
	private RegisterPageObject registerPage;
	private String firstName, lastName, invalidEmail, notFoundEmail,existingEmail, password;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		
		homePage = new HomePageObject(driver);
		
		firstName = "Automation";
		lastName  = "FC";
		invalidEmail  = "afc@ss@.&%";
		existingEmail = "afc" + generateFakeNumber() + "@mail.vn";
		notFoundEmail  = "afc" + generateFakeNumber() + "@mail.com";
		password  = "123456";
	}

	@Test
	public void Login_01_Empty_Data() {
		homePage.clickToLoginLink();
		
		// Từ trang Home- Click Login Link -> Qua trang Login
		loginPage = new LoginPageObject(driver);

		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Please enter your email");
	}

	@Test
	public void Login_02_Invalid_Email() {
		homePage.clickToLoginLink();
		
		// Từ trang Home- Click Login Link -> Qua trang Login
		loginPage = new LoginPageObject(driver);
		
		loginPage.inputToEmailTextbox(invalidEmail);
		
		loginPage.clickToLoginButton();
		
		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Wrong email");
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
