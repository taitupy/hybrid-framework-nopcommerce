package javaBasic;

import java.util.Scanner;

import org.testng.annotations.Test;

public class Topic_08_For_ForEach_Exercise {
	Scanner scanner = new Scanner(System.in);
	
	//@Test
	public void TC_01() {
		System.out.print("Nhập n: ");
		int number = scanner.nextInt();
		
		for (int i = 0; i < number; i++) {
			System.out.print((i+1) +" ");
		}
	}
	
	//@Test
	public void TC_02() {
		System.out.print("Nhập a: ");
		int number_a = scanner.nextInt();
		System.out.print("Nhập b: ");
		int number_b = scanner.nextInt();
		
		for (int i = number_a; i <=number_b; i++) {
			System.out.print(i + " ");
		}
	}
	
	//@Test
	public void TC_03() {
		int sum = 0;
		for (int i = 1; i <=10; i++) {
			if(i%2==0) {
				sum +=i;
			}
		}
		System.out.println("sum = " + sum);
	}
	
	//@Test
	public void TC_04() {
		System.out.print("Nhập a: ");
		int number_a = scanner.nextInt();
		System.out.print("Nhập b: ");
		int number_b = scanner.nextInt();
		int sum = 0;
		
		for (int i = number_a; i <= number_b; i++) {
			sum +=i;
		}
		System.out.println("sum = "+ sum);
	}
	
	//@Test
	public void TC_05() {
		System.out.print("Nhập n: ");
		int number = scanner.nextInt();
		int sum=0;
		
		for (int i = 1; i <= number; i++) {
			if(i%2==1) {
				sum +=i;
			}
		}
		System.out.println("sum = " + sum);
	}
	
	//@Test
	public void TC_06() {
		System.out.print("Nhập a: ");
		int number_a = scanner.nextInt();
		System.out.print("Nhập b: ");
		int number_b = scanner.nextInt();
		
		for (int i = number_a; i <=number_b; i++) {
			if(i%3==0) {
				System.out.print(i + " ");
			}
		}
	}
	
	@Test
	public void TC_07() {
		System.out.print("Nhập n: ");
		int number = scanner.nextInt();
		int giaithua = 1;
		
		for (int i = 2; i <= number; i++) {
			giaithua *=i;
		}
		System.out.println("giai thua = " + giaithua);
	}
}
