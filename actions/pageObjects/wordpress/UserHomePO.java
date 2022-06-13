package pageObjects.wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.UserHomePageUI;

public class UserHomePO extends BasePage{
	WebDriver driver;

	public UserHomePO(WebDriver driver) {
		this.driver = driver;
	}

	public UserPostDetailPO clickToPostTitle(String postTitle) {
		waitForElementClickabe(driver, UserHomePageUI.POST_TITLE_TEXT, postTitle);
		clickToElement(driver, UserHomePageUI.POST_TITLE_TEXT, postTitle);
		return PageGeneratorManager.getUserPostDetailPage(driver);
	}

	public boolean isPostInforDisplayedWithPostTitle(String postTitle) {
		waitForElementInvisible(driver, UserHomePageUI.POST_TITLE_TEXT, postTitle);
		return isElementDisplayed(driver, UserHomePageUI.POST_TITLE_TEXT, postTitle);
	}

	public boolean isPostInforDisplayedWithPostBody(String postTitle, String postBody) {
		waitForElementInvisible(driver, UserHomePageUI.POST_BODY_TEXT, postTitle, postBody);
		return isElementDisplayed(driver, UserHomePageUI.POST_BODY_TEXT, postTitle, postBody);
	}

	public boolean isPostInforDisplayedWithPostAuthor(String postTitle, String authorName) {
		waitForElementInvisible(driver, UserHomePageUI.POST_AUTHOR_TEXT, postTitle, authorName);
		return isElementDisplayed(driver, UserHomePageUI.POST_AUTHOR_TEXT, postTitle, authorName);
	}

	public boolean isPostInforDisplayedWithPostCurrentDay(String postTitle, String currentDay) {
		waitForElementInvisible(driver, UserHomePageUI.POST_CURRENT_DATE_TEXT_BY_POST_TITLE, postTitle, currentDay);
		return isElementDisplayed(driver, UserHomePageUI.POST_CURRENT_DATE_TEXT_BY_POST_TITLE, postTitle, currentDay);
	}

}
