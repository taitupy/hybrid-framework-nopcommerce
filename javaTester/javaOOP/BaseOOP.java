package javaOOP;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public class BaseOOP {
	public long shortTimeout = 15;
	protected long longTimeout = 45;
	private WebDriver driver;
	
	public BaseOOP() {
		System.out.println("Constructor of parent ");
	}
	
	public BaseOOP(String name) {
		System.out.println("Constructor of parent " + name);
	}
	
	public BaseOOP(int number) {
		System.out.println("Constructor of parent " + number);
	}
	
	public void setImplicitWait() {
		driver.manage().timeouts().implicitlyWait(longTimeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(shortTimeout, TimeUnit.SECONDS);
	}

}
