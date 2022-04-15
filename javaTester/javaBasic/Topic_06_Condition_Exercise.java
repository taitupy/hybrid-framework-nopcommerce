package javaBasic;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Topic_06_Condition_Exercise {
	WebDriver driver;
	Scanner scanner = new Scanner(System.in);
	

	public void TC_01_If() {
		int number = scanner.nextInt();
		
		if(number % 2 == 0) {
			System.out.println("So: " + number + " là số chẵn");
		}else {
			System.out.println("So: " + number + "là số lẻ");
		}
	}
	

	public void TC_02_If() {
		System.out.print("Number a: ");
		int number_a = scanner.nextInt();
		System.out.print("Number b: ");
		int number_b = scanner.nextInt();
		
		if(number_a > number_b) {
			System.out.println(number_a + " is greater than " + number_b );
		}else if(number_a < number_b) {
			System.out.println(number_a + " is less than " + number_b );
		}else {
			System.out.println(number_a + " is equal " + number_b );
		}
	}
	

	public void TC_03_If() {
		System.out.print("Name a: ");
		String name_a = scanner.nextLine();
		System.out.print("Name b: ");
		String name_b = scanner.nextLine();
		
		// Reference : String
		if(name_a.equals(name_b)) {
			System.out.println("SAME NAME");
		}else {
			System.out.println("DIFFERENCE NAME");
		}
		
		// Kiểu primitive Type
		if(name_a == name_b) {
			System.out.println("SAME NAME");
		}else {
			System.out.println("DIFFERENCE NAME");
		}
	}
	

	public void TC_04_If() {
		System.out.print("Number a: ");
		int number_a = scanner.nextInt();
		System.out.print("Number b: ");
		int number_b = scanner.nextInt();
		System.out.print("Number c: ");
		int number_c = scanner.nextInt();
		
		if(number_a >= number_b && number_a >= number_c) {
			System.out.println("max = " + number_a);
		}else if(number_b >= number_a && number_b >= number_c){
			System.out.println("max = " + number_b);
		}else {
			System.out.println("max = " + number_c);
		}
	}
	

	public void TC_05_If() {
		System.out.print("Number a: ");
		int number_a = scanner.nextInt();
		
		if(number_a <10 || number_a >100) {
			System.out.println(number_a + " is not belong to [10-100]");
		}else {
			System.out.println(number_a + " is belong to [10-100]");
		}
	}
	
	@Test
	public void TC_06_If() {
		System.out.print("Nhập điểm: ");
		float number_a = scanner.nextFloat();
		
		if(number_a > 0 && number_a < 5) {
			System.out.println("Điểm - D");
		}else if(number_a >= 5 && number_a <= 7.5) {
			System.out.println("Điểm - C");
		}else if(number_a >= 7.5 && number_a <= 8.5) {
			System.out.println("Điểm - B");
		}else {
			System.out.println("Điểm - A");
		}
	}

}
