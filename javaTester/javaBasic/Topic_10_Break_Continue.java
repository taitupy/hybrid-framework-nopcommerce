package javaBasic;

import org.testng.annotations.Test;

public class Topic_10_Break_Continue {

	public static void main(String[] args) {
		TC_01_For();
	}

	@Test
	public static void TC_01_For() {

		// Nested for
		for (int i = 0; i <= 5; i++) {
			System.out.println("Lần chạy của i (for trên) = " + i);

			// i =1
			// Mỗi 1 lần chạy của for trên sẽ apply cho tất cả các lần chạy của for dưới
			for (int j = 0; i <= 5; j++) {
				if (j == 4) {
					continue;
				}
				System.out.println("j = " + j);
			}
		}
	}

}
