package pageUIs.nopCommerce.user;

public class BasePageNopCommerceUI {
	public static final String ADDRESS_LINK = "XPATH=//div[@class='block block-account-navigation']//a[text()='Addresses']";
	public static final String CUSTOMER_INFOR_LINK = "XPath=//div[@class='block block-account-navigation']//a[text()='Customer info']";
	public static final String MY_PRODUCT_REVIEW_LINK = "Xpath=//div[@class='block block-account-navigation']//a[text()='My product reviews']";
	public static final String REWARD_POINT_LINK = "xpath=//div[@class='block block-account-navigation']//a[text()='Reward points']";
	public static final String DYNAMIC_PAGE_AT_MY_ACCOUNT_AREA = "xpath=//div[@class='block block-account-navigation']//a[text()='%s']";
	
	public static final String LOGOUT_LINK_AT_USER = "css=a[class='ico-logout']";
	public static final String LOGOUT_LINK_AT_ADMIN = "xpath=//a[text()='Logout']";
	public static final String LOADING_PAGE_ADMIN = "xpath=//div[@id='ajaxBusy']/span";
}
