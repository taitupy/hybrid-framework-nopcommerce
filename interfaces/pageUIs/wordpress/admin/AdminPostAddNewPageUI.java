package pageUIs.wordpress.admin;

public class AdminPostAddNewPageUI {
	public static final String TITLE_TEXTBOX = "css=h1.wp-block-post-title";
	public static final String BODY_BUTTON = "xpath=//p[contains(@class,'block-editor-default')]";
	public static final String BODY_TEXTBOX = "xpath=//p[contains(@class,'block-editor-rich-text__editable')]";
	public static final String PUBLISH_BUTTON = "xpath=//div[@aria-label='Editor top bar']//button[contains(@class,'editor-post-publish-panel__toggle')]";
	public static final String PRE_PUBLISH_BUTTON = "xpath=//div[@aria-label='Editor publish']//button[contains(@class,'editor-post-publish-button')]";
	public static final String PUBLISHED_MESSAGE = "xpath=//div[@class='components-snackbar__content' and text()='%s']";
}
