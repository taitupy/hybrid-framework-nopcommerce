package javaBasic;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Topic_08_For_Foreach {
		WebDriver driver;
		
		public void TC_01_For_Iterate() {
//			for (int i = 1; i < 11; i++) {
//				System.out.println(i);
//			}
		
		// Array/ List/ Set/ Queue (index)
		
		// For kết hợp if : Thỏa mãn điều kiện mới action
		// Biến đếm - dùng để điều kiện filter
		String[] cityName = {"Ha Noi", "Ho Chi Minh", "Can Tho"};
		for (int i = 0; i < cityName.length; i++) {
			if(cityName[i].equals("Can Tho")) {
				// Action
				System.out.println("Do action!!!");
				break;
			}
		}
		
		for (int i = 0; i < cityName.length; i++) {
			if(cityName[i].equals("Can Tho")) {
				// Action
				System.out.println("Do action!!!");
				// break;
			}
			// Trường hợp ko có break
			// Tất cả các giá trị (element) đều được chạy qua dù đã thỏa mãn điều kiện rồi
		}
		
		// Dùng để chạy qua hết tất cả giá trị
		for (String city : cityName) {
			
		}
		
		
	}

		@Test
		public void TC_02_For_Each() {
			String[] cityName = {"Ha Noi", "Ho Chi Minh", "Da Nang", "Can Tho"};
			
//			for (String city : cityName) {
//				System.out.println(city);
//			}
			
			// Java Collection
			// Class: ArrayList/ LinkedList/ Vector/ ...
			// Interface: List/Set/ Queue
			List<String> cityAdress = new ArrayList<String>();
			System.out.println(cityAdress.size());
			
			// Compile (Coding)
			cityAdress.add("Bac Giang");
			cityAdress.add("Ha Giang");
			cityAdress.add("Sa Pa");
			
			System.out.println(cityAdress.size());
			
			// Runtin (Running)
			for (String city : cityName) {
				cityAdress.add(city);
			}
			System.out.println(cityAdress.size());
			
			for (String cityAdd : cityAdress) {
				System.out.println(cityAdd);
			}
			
			// Java Generic
			List<WebElement> links = driver.findElements(By.xpath(""));
			
			// Xử lí dữ liệu/ get text/ value/ css/ attribute
			for (WebElement link : links) {
				// chuyển page
				// refresh DOM/ HTML
				// ko còn tồn tại
				// Fail -> StaleElementException
				
			}
			
		}	
}
