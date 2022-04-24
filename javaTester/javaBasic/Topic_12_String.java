package javaBasic;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Topic_12_String {

	public static void main(String[] args) {
//		System.setProperty("webdriver.gecko.driver", ".\\browserDrivers\\geckodriver.exe");
//		WebDriver driver = new FirefoxDriver();
		
		String schoolName = "Automation Testing";
		String courseName = "AUTOMATION TESTING";
		String schoolAddress = "Ho Chi Minh City";
		
		System.out.println("Độ dài = " + schoolName.length());
		System.out.println("Lấy ra 1 ký tự = " + schoolName.charAt(0));
		System.out.println("Nối 2 chuỗi = " + schoolName + schoolAddress);
		
		// Tuyệt đối
		System.out.println("Kiểm tra 2 chuỗi bằng nhau tuyệt đối = " + schoolName.equals("Automation Testing"));
		
		// Multi browser
		System.out.println("Kiểm tra 2 chuỗi bằng nhau tuyệt đối = " + schoolName.equalsIgnoreCase(courseName));

		// StartsWith/ endsWith/ contains
		System.out.println("Có bắt đầu bằng 1 kí tự/ chuỗi kí tự = " + schoolName.startsWith("A"));
		System.out.println("Có bắt đầu bằng 1 kí tự/ chuỗi kí tự = " + schoolName.startsWith("Automation"));
		System.out.println("Có bắt đầu bằng 1 kí tự/ chuỗi kí tự = " + schoolName.startsWith("T"));
		
		System.out.println("Có chứa 1 kí tự/ chuỗi kí tự = " + schoolName.contains("Testing"));
		System.out.println("Có chứa 1 kí tự/ chuỗi kí tự = " + schoolName.contains	("Automation"));
		
		System.out.println("Có kết thúc bằng 1 kí tự/ chuỗi kí tự = " + schoolName.contains("Testing"));
		System.out.println("Có kết thúc bằng 1 kí tự/ chuỗi kí tự = " + schoolName.contains	("g"));
		System.out.println("Có kết thúc bằng 1 kí tự/ chuỗi kí tự = " + schoolName.contains	("h"));
		
		System.out.println("Vị trí của 1 kí tự/ chuỗi kí tự = " + schoolName.indexOf("utomation"));
		System.out.println("Vị trí của 1 kí tự/ chuỗi kí tự = " + schoolName.indexOf("A"));
		System.out.println("Vị trí của 1 kí tự/ chuỗi kí tự = " + schoolName.indexOf("Testing"));
		
		System.out.println("Tách 1 kí tự/ chuỗi kí tự trong chuỗi= " + schoolName.substring(11,15));
		
		// Split : Tách chuỗi thành 1 mảng dựa vào kí tự/ chuỗi kí tự
		String result = "Viewing 48 of 132 results";
		String results[] = result.split(" ");
		
		System.out.println(results[3]);
		
		// Replace
		String productPrice = "$100.00";
		productPrice = productPrice.replace("$", "");
		System.out.println(productPrice);
		
		// từ 1 chuỗi convert sang 1 số (float)
		// Sắp xếp nó: Sort Data (Asc/ Desc)
		float productPriceF = Float.parseFloat(productPrice);
		System.out.println(productPriceF);
		
		// từ 1 chuỗi conver sang 1 số (float)
		productPrice = String.valueOf(productPriceF);
		System.out.println(productPrice);
		
		String osName = System.getProperty("os.name");
		System.out.println(osName);
		// Windows 10 = windows 10
		// Handle multiple OS: MAC/ Windows (Actions - keys - Ctrl/ Command)
		if(osName.toLowerCase().contains("windows")) {
			Keys key = Keys.CONTROL;
		}else {
			Keys key = Keys.COMMAND;
		}
		
		// Multiple browser: toUpperCase
		// firefox = FIREFOX (Enum)
		
		// String driverInstanceName = driver.toString();
		// System.out.println(driverInstanceName);
		// FirefoxDriver: firefox on WINDOWS (5ff2251e-f899-4ed5-81c5-7bdb39050778)
		// Close browser/ driver
		// if(driverInstanceName.contains("internetexplore")) {
			// Sleep cứng thêm 5s sau mỗi sự kiện chuyển page
		// }
		
		// Trim(): Cắt khoảng trắng/ xuống dòng/ tab
		String helloWorld = " \n \t    Hello World!           ";
		System.out.println(helloWorld);
		System.out.println(helloWorld.trim());
		
		helloWorld = " ";
		System.out.println("Empty = " + helloWorld.isEmpty());
		System.out.println("Blank = " + helloWorld.isBlank());
		
		// Dynamic locator
		// Đại diện cho 1 chuỗi : %s
		// %b %t %d
		String dynamicButtonXpath = "button[@id='%s']";
		System.out.println("Click to Login button = " + dynamicButtonXpath.format(dynamicButtonXpath, "login"));
		System.out.println("Click to Search button = " + dynamicButtonXpath.format(dynamicButtonXpath, "search"));
		System.out.println("Click to Register button = " + dynamicButtonXpath.format(dynamicButtonXpath, "register"));
		
	}

}
