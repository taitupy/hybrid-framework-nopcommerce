package com.wordpress.admin;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.wordpress.admin.AdminDashboardPO;
import pageObjects.wordpress.admin.AdminLoginPO;
import pageObjects.wordpress.admin.AdminPostAddNewPO;
import pageObjects.wordpress.admin.AdminPostSearchPO;
import pageObjects.wordpress.admin.PageGeneratorManager;

public class Post_01_Create_Read_Update_Delete_Search extends BaseTest {
	private WebDriver driver;
	AdminLoginPO adminLoginPage;
	AdminDashboardPO adminDashboardPage;
	AdminPostSearchPO adminPostSearchPage;
	AdminPostAddNewPO adminPostAddNewPage;
	
	String adminUserName = "automationfc";
	String adminPassword = "automationfc";
	String searchPostUrl;
	int randomNumber = generateFakeNumber();
	String postTitleValue = "Live Coding Title " + randomNumber;
	String postBodyValue = "Live Coding Body " + randomNumber;

	@Parameters({ "browser", "urlAdmin" })
	@BeforeClass
	public void beforeClass(String browserName, String adminUrl) {
		log.info("Pre-Condition - Step 01: Open browser and admin Url");
		driver = getBrowserDriver(browserName, adminUrl);
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
		
		log.info("Pre-Condition - Step 02: Enter to Username textbox with value: " + adminUserName);
		adminLoginPage.enterToUsernameTextbox(adminUserName);
		
		log.info("Pre-Condition - Step 03: Enter to Password textbox: " + adminPassword);
		adminLoginPage.enterToPasswordTextbox(adminPassword);
		
		log.info("Pre-Condition - Step 04: Click to Login button");
		adminDashboardPage = adminLoginPage.clickToLoginButton();
	}

	@Test
	public void Post_01_Create_New_Post() {
		log.info("Create_Post - Step 01: Click to 'Posts' menu link");
		adminPostSearchPage = adminDashboardPage.clickToPostMenuLink();		
//		adminPostSearchPage = PageGeneratorManager.getAdminPostSearchPage(driver);
		
		log.info("Create_Post - Step 02: Get 'Search Posts' Page Url");
		searchPostUrl = adminPostSearchPage.getPageUrl(driver);
		
		log.info("Create_Post - Step 03: Click to 'Add New' button");
		adminPostAddNewPage = adminPostSearchPage.clickToAddNewButton();
//		adminPostAddNewPage = PageGeneratorManager.getAdminPostAddNewPage(driver);
		
		log.info("Create_Post - Step 04: Enter to post title");
		adminPostAddNewPage.enterToAddNewPostTitle(postTitleValue);
		
		log.info("Create_Post - Step 05: Enter to body");
		adminPostAddNewPage.enterToAddNewPostBody(postBodyValue);
		
		log.info("Create_Post - Step 06: Click to Publish button");
		adminPostAddNewPage.clickToPublishButton();
		
		log.info("Create_Post - Step 07: Click to Pre-Publish button");
		adminPostAddNewPage.clickToPrePublishButton();
		
		log.info("Create_Post - Step 08: Verify 'Post published' message is displayed");
		verifyTrue(adminPostAddNewPage.isPostPublishMessageDisplayed("Post published."));
	}

	@Test
	public void Post_02_Search_Post() {
		log.info("Search_Post - Step 01: Open 'Search Post' page");
		adminPostSearchPage = adminPostAddNewPage.OpenSearchPostPageUrl(searchPostUrl);
		
	}

	@Test
	public void Post_03_View_Post() {

	}

	@Test
	public void Post_04_Edit_Post() {

	}

	@Test
	public void Post_05_Delete_Post() {

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver();
	}
}
