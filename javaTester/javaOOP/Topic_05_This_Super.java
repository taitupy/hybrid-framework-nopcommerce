package javaOOP;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public class Topic_05_This_Super extends BaseOOP{
	private int firstNumber;
	private int secondNumber;
	private WebDriver driver;
	public long shortTimeout = 15;
	protected long longTimeout = 45;

	public Topic_05_This_Super() {
		// Luôn luôn gọi qua Constructor của class cha
		super(123);
		System.out.println("Constructor of child");
	}

	public Topic_05_This_Super(int firstNumber, int secondNumber) {
		this.firstNumber = firstNumber;
		this.secondNumber = secondNumber;
	}

	public void sumNumber() {
		System.out.println(firstNumber + secondNumber);
	}

	public static void main(String[] args) {
		Topic_05_This_Super topic = new Topic_05_This_Super();
	}
	
	public void setImplicitWait() {
		driver.manage().timeouts().implicitlyWait(super.longTimeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(super.shortTimeout, TimeUnit.SECONDS);
	}
	
	public void clickToElement() {
		// Ko dùng super thì nó sẽ gọi qua hàm ở Clas con ( hiện tại)
		setImplicitWait();
		
		// Gọi qua hàm ở lớp Cha
		super.setImplicitWait();
	}

}
