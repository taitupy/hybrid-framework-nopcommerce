package javaBasic;

import java.util.Scanner;

import org.testng.annotations.Test;

public class Topic_09_While_Do_While {

	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		TC_06_While();
	}
	
//	@Test
	public static void TC_01_For() {
		System.out.print("Number a: ");
		int number_a = scanner.nextInt();
		
		for (int i = number_a; i <= 100; i++) {
			if(i%2==0) System.out.println(i);
		}
	}
	
//	@Test
	public static void TC_02_While() {
		System.out.print("Number a: ");
		int number_a = scanner.nextInt();
		
		while(number_a<=100) {
			if(number_a%2==0) {
				System.out.println(number_a);
			}
			number_a++;
		}
	}
	
//	@Test
	public static void TC_03_Do_While() {
		System.out.print("Number a: ");
		int number_a = scanner.nextInt();
		
		do {
			if(number_a%2==0) {
				System.out.println(number_a);
			}
			
			number_a++;
		}while(number_a<=100);
	}
	
//	@Test
	public static void TC_04_While() {
		System.out.print("Number a: ");
		int number_a = scanner.nextInt();
		System.out.print("Number b: ");
		int number_b = scanner.nextInt();
		int i = number_a;
		
		while(i<number_b) {
			if(i%3==0 && i%5==0) {
				System.out.println(i);
			}
			i++;
		}
	}
	
//	@Test
	public static void TC_05_While() {
		System.out.print("Number a: ");
		int number_a = scanner.nextInt();
		int i = 1;
		int sum = 0;
		
		while(i <= number_a) {
			if(i%2 != 0) {
				sum+=i;
			}
			i++;
		}
		
		System.out.println("sum = " + sum);
	}

	@Test
	public static void TC_06_While() {
		System.out.print("Number a: ");
		int number_a = scanner.nextInt();
		int i = 1;
		int giaithua = 1;
		
		while(i <= number_a) {
			giaithua *= i;
			i++;
		}
		System.out.println("giai_thua = "+ giaithua);
	}
}










