package commons;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

import exception.BrowserNotSupport;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	private WebDriver driver;
	
	protected WebDriver getBrowserDriver(String browserName) throws BrowserNotSupport {
		BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());
		if(browserList == BrowserList.FIREFOX) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}else if(browserList == BrowserList.H_FIREFOX) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--headless");
			options.addArguments("window-size=1920x1080");
			driver = new FirefoxDriver(options);
		}
		else if (browserList == BrowserList.CHROME) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if (browserList == BrowserList.H_CHROME) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
			options.addArguments("window-size=1920x1080");
			driver = new ChromeDriver(options);
		}
		else if (browserList == BrowserList.EDGE){
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		else if (browserList == BrowserList.IE){
			WebDriverManager.iedriver().arch32().setup();
			driver = new InternetExplorerDriver();
		}
		else if (browserList == BrowserList.OPERA){
			WebDriverManager.operadriver().setup();
			driver = new OperaDriver();
		}
		else if (browserList == BrowserList.COCCOC){
			// Cốc cốc browser trừ đi 5-6 version ra chromedriver
			WebDriverManager.chromedriver().driverVersion("100.0.4896.60").setup();
			ChromeOptions options = new ChromeOptions();
			
			if(GlobalConstants.OS_NAME.startsWith("Windows")) {
				options.setBinary("C:\\Users\\hp\\AppData\\Local\\CocCoc\\Browser\\Application\\browser.exe");
			}else {
				options.setBinary("....");	
			}
			
			driver = new ChromeDriver(options);
		}else if (browserList == BrowserList.BRAVE){
			// brave browser version nào thì dùng chromedriver version đó
			WebDriverManager.chromedriver().driverVersion("100.0.4896.60").setup();
			ChromeOptions options = new ChromeOptions();
			options.setBinary("C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe");
			driver = new ChromeDriver(options);
		}
		else {
			throw new BrowserNotSupport(browserName);
		}
		
		driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
		driver.get(GlobalConstants.PORTAL_DEV_URL);
		return driver;
	}
	
	protected WebDriver getBrowserDriver(String browserName, String appUrl) {
		BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());
		if(browserList == BrowserList.FIREFOX) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}else if(browserList == BrowserList.H_FIREFOX) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--headless");
			options.addArguments("window-size=1920x1080");
			driver = new FirefoxDriver(options);
		}
		else if (browserList == BrowserList.CHROME) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if (browserList == BrowserList.H_CHROME) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
			options.addArguments("window-size=1920x1080");
			driver = new ChromeDriver(options);
		}
		else if (browserList == BrowserList.EDGE){
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		else if (browserList == BrowserList.IE){
			WebDriverManager.iedriver().arch32().setup();
			driver = new InternetExplorerDriver();
		}
		else if (browserList == BrowserList.OPERA){
			WebDriverManager.operadriver().setup();
			driver = new OperaDriver();
		}
		else if (browserList == BrowserList.COCCOC){
			// Cốc cốc browser trừ đi 5-6 version ra chromedriver
			WebDriverManager.chromedriver().driverVersion("100.0.4896.60").setup();
			ChromeOptions options = new ChromeOptions();
			
			if(GlobalConstants.OS_NAME.startsWith("Windows")) {
				options.setBinary("C:\\Users\\hp\\AppData\\Local\\CocCoc\\Browser\\Application\\browser.exe");
			}else {
				options.setBinary("....");	
			}
			
			driver = new ChromeDriver(options);
		}
		else if (browserList == BrowserList.BRAVE){
			// brave browser version nào thì dùng chromedriver version đó
			WebDriverManager.chromedriver().driverVersion("100.0.4896.60").setup();
			ChromeOptions options = new ChromeOptions();
			options.setBinary("C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe");
			driver = new ChromeDriver(options);
		}
		else {
			throw new RuntimeException("Browser name invalid");
		}
		
		driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
		driver.get(appUrl);
		
		return driver;
	}
	
	protected String getEnviromenUrl(String serverName) {
		String envUrl = null;
		EnviromentList environment = EnviromentList.valueOf(serverName.toUpperCase());
		if(environment == EnviromentList.DEV) {
			envUrl = "https://demo.nopcommerce.com/";
		}else if(environment == EnviromentList.TESTING) {
			envUrl = "https://admin-demo.nopcommerce.com";
		}else if(environment == EnviromentList.STAGING) {
			envUrl = "https://staging.orangehrmlive.com";
		}else if(environment == EnviromentList.STAGING) {
			envUrl = "https://production.orangehrmlive.com";
		}
		return envUrl;
	}
	
	public int generateFakeNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}
}
