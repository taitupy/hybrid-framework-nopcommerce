package javaBasic;

import org.testng.annotations.Test;

public class Topic_02_Exercise {
	@Test
	public void TC_01() {
		int a = 6;
		int b = 2;
		
		System.out.println("Tong = " + (a + b));
		System.out.println("Hieu = " + (a - b));
		System.out.println("Tich = " + (a * b));
		System.out.println("Thuong = " + (a / b));
	}
	
	@Test
	public void TC_02() {
		float height = 7.5f;
		float width = 3.8f;
		
		System.out.println("S of rectangle = " + (height * width));
	}
	
	@Test
	public void TC_03() {
		String name = "Automation Testing";
		
		System.out.println("Hello " + name);
	}
}