package commons;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.joda.time.DateTime;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeSuite;

import exception.BrowserNotSupport;
import factoryBrowser.BrowserList;
import factoryEnvironment.BrowserstackFactory;
import factoryEnvironment.EnviromentList;
import factoryEnvironment.GridFactory;
import factoryEnvironment.LambdaFactory;
import factoryEnvironment.LocalFactory;
import factoryEnvironment.SaucelabFactory;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	private WebDriver driver;
	protected final Log log;
	
	@BeforeSuite
	public void initBeforeSuite() {
		deleteAllureReport();
	}
	
	protected BaseTest() {
		log = LogFactory.getLog(getClass());
	}
	
	protected WebDriver getBrowserDriver(String browserName, String serverName, String envName, String ipAddress, String portNumber, String osName, String osVersion) {
		switch(envName) {
		case "local":
			driver = new LocalFactory(browserName).createDriver();
			break;
		case "grid":
			driver = new GridFactory(browserName, ipAddress, portNumber).createDriver();
			break;
		case "browserStack":
			driver = new BrowserstackFactory(browserName, osName, osVersion).createDriver();
			break;
		case "Saucelab":
			driver = new SaucelabFactory(browserName, osName).createDriver();
			break;
		case "Lambda":
			driver = new LambdaFactory(browserName, osName).createDriver();
			break;	
		default:
			driver = new LocalFactory(browserName).createDriver();
			break;
		}
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(getEnviromenUrl(serverName));
		return driver;
	}
	
	protected WebDriver getBrowserDriver(String browserName) throws BrowserNotSupport {
		BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());
		if(browserList == BrowserList.FIREFOX) {
			WebDriverManager.firefoxdriver().setup();
			
//			System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
//			System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, GlobalConstants.PROJECT_PATH + "\\browserLogs\\FirefoxLog.log");
			
			FirefoxOptions options = new FirefoxOptions();
			options.addPreference("intl.accept_languages", "vi-vn, vi, en-us, en");
			driver = new FirefoxDriver(options);
		}else if(browserList == BrowserList.H_FIREFOX) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--headless");
			options.addArguments("window-size=1920x1080");
			driver = new FirefoxDriver(options);
		}
		else if (browserList == BrowserList.CHROME) {
			WebDriverManager.chromedriver().setup();
			
//			System.setProperty("webdriver.chrome.args", "--disable-logging");
//			System.setProperty("webdriver.chrome.silentOutput", "true");
			
			ChromeOptions options = new ChromeOptions();
			
			Map<String, Object> prefs = new HashMap<String,  Object>();
			prefs.put("credentials_enable_service", false);
			prefs.put("profile.password_manager_enabled", false);
			options.setExperimentalOption("prefs", prefs);
			
			options.setExperimentalOption("useAutomationExtension", false);
			options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
			
			driver = new ChromeDriver(options);
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
	
	protected WebDriver getBrowserDriverLocal(String browserName, String appUrl) {
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
		
//		driver.get(appUrl);
		driver.get(getEnviromenUrl(appUrl));
		
		return driver;
	}
	
	protected WebDriver getBrowserDriverGrid(String browserName, String appUrl, String ipAddress, String portNumber) {
		BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());
		DesiredCapabilities capability = null;
		
		if(browserList == BrowserList.FIREFOX) {
			WebDriverManager.firefoxdriver().setup();
			capability = DesiredCapabilities.firefox();
			capability.setBrowserName("firefox");
			capability.setPlatform(Platform.WINDOWS);
			FirefoxOptions options = new FirefoxOptions();
			options.merge(capability);
		}else if(browserList == BrowserList.H_FIREFOX) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--headless");
			options.addArguments("window-size=1920x1080");
			driver = new FirefoxDriver(options);
		}
		else if (browserList == BrowserList.CHROME) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			capability = DesiredCapabilities.chrome();
			capability.setBrowserName("chrome");
			capability.setPlatform(Platform.WINDOWS);
			options.merge(capability);	
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
		
		try {
			driver = new RemoteWebDriver(new URL(String.format("http://%s:%s/wd/hub", ipAddress, portNumber)), capability);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
		
//		driver.get(appUrl);
		driver.get(getEnviromenUrl(appUrl));
		
		return driver;
	}
	
	protected WebDriver getBrowserDriverBrowserstack(String browserName, String appUrl, String osName, String osVersion) {
		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setCapability("os", osName);
		capability.setCapability("os_version", osVersion);
		capability.setCapability("browser", browserName);
		capability.setCapability("browser_version", "latest");
		capability.setCapability("browserstack.debug", "true");
		capability.setCapability("project", "NopCommerce");
		capability.setCapability("resolution", "1920x1080");
		capability.setCapability("os", "Run on " + osName + " | " + osVersion + " | " + browserName);
		
		try {
			driver = new RemoteWebDriver(new URL(GlobalConstants.BROWSER_STACK_URL), capability);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
		
//		driver.get(appUrl);
		driver.get(getEnviromenUrl(appUrl));
		
		return driver;
	}
	
	protected WebDriver getBrowserDriverSaucelab(String browserName, String appUrl, String osName) {
		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setCapability("platformName", osName);
		capability.setCapability("browserName", browserName);
		capability.setCapability("browserVersion", "latest");
		capability.setCapability("os", "Run on " + osName + " | " + browserName);
		
		Map<String, Object> sauceOptions = new HashMap<>();
		if(osName.contains("Windows")) {
			sauceOptions.put("screenResolution", "1920x1080");	
		}else {
			sauceOptions.put("screenResolution", "1920x1440");	
		}
		capability.setCapability("sauce:options", sauceOptions);
		
		try {
			driver = new RemoteWebDriver(new URL(GlobalConstants.SAUCELAB_URL), capability);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
//		driver.get(appUrl);
		driver.get(getEnviromenUrl(appUrl));
		
		return driver;
	}
	
	protected WebDriver getBrowserDriverLambda(String browserName, String appUrl, String osName) {
		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setCapability("browser", browserName);
		capability.setCapability("os", osName);
		capability.setCapability("version", "latest");
		capability.setCapability("video", true);
		capability.setCapability("visual", true);
		
		if(osName.contains("Windows")) {
			capability.setCapability("screenResolution", "1920x1080");
		}else {
			capability.setCapability("screenResolution", "2560x1600");
		}
		capability.setCapability("os", "Run on " + osName + "|" + browserName);
		
		try {
			driver = new RemoteWebDriver(new URL(GlobalConstants.LAMBDA_URL), capability);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
//		driver.get(appUrl);
		driver.get(getEnviromenUrl(appUrl));
		
		return driver;
	}
	
	public WebDriver getDriverInstance() {
		return this.driver;
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

	protected boolean verifyTrue(boolean condition) {
		boolean pass = true;
		try {
			Assert.assertTrue(condition);
			log.info(" -------------------------- PASSED -------------------------- ");
		} catch (Throwable e) {
			log.info(" -------------------------- FAILED -------------------------- ");
			pass = false;

			// Add lỗi vào ReportNG
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyFalse(boolean condition) {
		boolean pass = true;
		try {
			Assert.assertFalse(condition);
			log.info(" -------------------------- PASSED -------------------------- ");
		} catch (Throwable e) {
			log.info(" -------------------------- FAILED -------------------------- ");
			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyEquals(Object actual, Object expected) {
		boolean pass = true;
		try {
			Assert.assertEquals(actual, expected);
			log.info(" -------------------------- PASSED -------------------------- ");
		} catch (Throwable e) {
			pass = false;
			log.info(" -------------------------- FAILED -------------------------- ");
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	public void deleteAllureReport() {
		try {
			String pathFolderDownload = GlobalConstants.PROJECT_PATH + "/allure-json";
			File file = new File(pathFolderDownload);
			File[] listOfFiles = file.listFiles();
			for (int i = 0; i < listOfFiles.length; i++) {
				if (listOfFiles[i].isFile()) {
					new File(listOfFiles[i].toString()).delete();
				}
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}

	protected void closeBrowserAndDriver() {
		String cmd = "";
		try {
			String osName = System.getProperty("os.name").toLowerCase();
			log.info("OS name = " + osName);

			String driverInstanceName = driver.toString().toLowerCase();
			log.info("Driver instance name = " + driverInstanceName);

			if (driverInstanceName.contains("chrome")) {
				if (osName.contains("window")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq chromedriver*\"";
				} else {
					cmd = "pkill chromedriver";
				}
			} else if (driverInstanceName.contains("internetexplorer")) {
				if (osName.contains("window")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq IEDriverServer*\"";
				}
			} else if (driverInstanceName.contains("firefox")) {
				if (osName.contains("windows")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq geckodriver*\"";
				} else {
					cmd = "pkill geckodriver";
				}
			} else if (driverInstanceName.contains("edge")) {
				if (osName.contains("window")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq msedgedriver*\"";
				} else {
					cmd = "pkill msedgedriver";
				}
			} else if (driverInstanceName.contains("opera")) {
				if (osName.contains("window")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq operadriver*\"";
				} else {
					cmd = "pkill operadriver";
				}
			} else if (driverInstanceName.contains("safari")) {
				if (osName.contains("mac")) {
					cmd = "pkill safaridriver";
				}
			}

			if (driver != null) {
				driver.manage().deleteAllCookies();
				driver.quit();
			}
		} catch (Exception e) {
			log.info(e.getMessage());
		} finally {
			try {
				Process process = Runtime.getRuntime().exec(cmd);
				process.waitFor();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	protected String getCurrentDate() {
		DateTime nowUTC = new DateTime();
		int day = nowUTC.getDayOfMonth();
		if (day < 10) {
			String dayValue = "0" + day;
			return dayValue;
		}
		return String.valueOf(day);
	}

	protected String getCurrentMonth() {
		DateTime now = new DateTime();
		int month = now.getMonthOfYear();
//		if (month < 10) {
//			String monthValue = "0" + month;
//			return monthValue;
//		}
		
		String temp;
		switch(month) {
			case 1:
				temp = "Jan";
			case 2:
				temp = "Feb";
			case 3:
				temp = "Mar";
			case 4:
				temp = "Apr";
			case 5:
				temp = "May";
			case 6:
				temp = "June";
			case 7:
				temp = "July";
			case 8:
				temp = "August";
			case 9:
				temp = "Sep";
			case 10:
				temp = "Oct";
			case 11:
				temp = "Nov";
			case 12:
				temp = "Dec";
			default:
				temp = "";
		}
		return String.valueOf(temp);
	}

	protected String getCurrentYear() {
		DateTime now = new DateTime();
		return now.getYear() + "";
	}

	protected String getCurrentDay() {
		return getCurrentMonth() + " " + getCurrentDate() + ", " + getCurrentYear();
	}
}
