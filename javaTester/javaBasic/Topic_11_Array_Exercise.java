package javaBasic;

import org.testng.annotations.Test;

public class Topic_11_Array_Exercise {

	public static void main(String[] args) {
		TC_05_Array();
	}

//	@Test
	public static void TC_01_Array() {
		int array[] = { 2, 7, 12, 8, 9 };
		int max = array[0];

		for (int i = 1; i < array.length; i++) {
			if (array[i] > max) {
				max = array[i];
			}
		}

		System.out.println("max = " + max);
	}

//	@Test
	public static void TC_02_Array() {
		int array[] = { 2, 7, 12, 8, 12 };
		int sum = 0;

		for (int i = 0; i < array.length; i++) {
			if (i == 0 || i == (array.length - 1)) {
				sum += array[i];
			}
		}
		System.out.println("sum = " + sum);
	}

//	@Test
	public static void TC_03_Array() {
		int array[] = { 2, 7, 12, 8, 12 };

		for (int i = 0; i < array.length; i++) {
			if (array[i] % 2 == 0) {
				System.out.println(array[i]);
			}
		}
	}

//	@Test
	public static void TC_04_Array() {
		int array[] = { 2, 7, -5, -3, 12, 8, 12 };
		int sum = 0;
		
		for (int i = 0; i < array.length; i++) {
			if (array[i] % 2 != 0 && array[i] > 0) {
				sum +=array[i];
			}
		}
		
		System.out.println("sum = " + sum);
	}
	
	@Test
	public static void TC_05_Array() {
		int array[] = { 2, 7, -5, -3, 12, 8, 12 };
		
		for (int i = 0; i < array.length; i++) {
			if (array[i] > 0  && array[i] < 10) {
				System.out.println(array[i]);
			}
		}
		
	}
	

}
