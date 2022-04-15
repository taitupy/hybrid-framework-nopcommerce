package javaBasic;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Topic_02_Data_Type {

	// Primitive type value type: Nguyên thủy
	byte bNumber = 6;
	
	short sNumber = 15000;
	
	int iNumber = 65000;
	
	long lNumber = 65000;
	
	float fNumber = 15.98f;
	
	double dNumber = 15.98d;
	
	char cChar = '1';
	
	boolean bStatus = false;
	
	// Reference type: Tham chiếu
	
	// String
	String address = "Ho Chi Minh";
	
	// Array
	String[] studentAddress = {address, "Ha Noi", "Da Nang"};
	Integer[] studentNumber = {15, 20, 50};
	
	// Class
	Topic_02_Data_Type topic;
	
	// Interface
	WebDriver driver;
	
	// Object
	Object aObject;
	
	// Collection
	// List/ Set/ Queue/ Map
	List<WebElement> homePageLinks = driver.findElements(By.tagName("a"));
	Set<String> allWindows = driver.getWindowHandles();
	List<String> productName = new ArrayList<String>();
	
	public static void main(String[] args) {
		
	}

}
