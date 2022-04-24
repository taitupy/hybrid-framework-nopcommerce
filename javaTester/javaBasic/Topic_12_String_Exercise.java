package javaBasic;

import org.testng.annotations.Test;

public class Topic_12_String_Exercise {
	String courseName = "Automation Testing Advanced Online";
	String title = "Automation Testing 345 Tutorials Online 789";

//	@Test
	public void TC_01() {
		// xử lý chuỗi thành mảng ký tự
		char courseNameArr[] = courseName.toCharArray();
		
		int count_uper = 0;
		int count_lower = 0;

		for (char character : courseNameArr) {
			if (character <= 'Z' && character >= 'A') {
				count_uper++;
			}
		}
		System.out.println("Upercase = " + count_uper);

		for (char character : courseNameArr) {
			if (character <= 'z' && character >= 'a') {
				count_lower++;
			}
		}
		System.out.println("Lowercase = " + count_lower);
	}

//	@Test
	public void TC_02() {
		// xử lý chuỗi thành mảng ký tự
		char courseNameArr[] = title.toCharArray();
		int count_a = 0;
		int count_b = 0;

		for (char c : courseNameArr) {
			if (c == 'A' || c == 'a') {
				count_a++;
			}
			
			if (c <= '9' && c >= '0') {
				count_b++;
			}
		}
		
		System.out.println("number a = " + count_a);
		System.out.println("Có chứa 1 kí tự/ chuỗi kí tự = " + title.contains("Testing"));
		System.out.println("Có bắt đầu bằng 1 kí tự/ chuỗi kí tự = " + title.startsWith("Automation"));
		System.out.println("Có kết thúc bằng 1 kí tự/ chuỗi kí tự = " + title.endsWith("Online"));
		System.out.println("Vị trí của Tutorials trong chuỗi = " + title.indexOf("Tutorials"));
		System.out.println("Thay Online bằng Offline = " + title.replace("Online", "Offline"));
		System.out.println("Ký tự number trong chuỗi = " + count_b);
	}
	
	@Test
	public void TC_03() {
		char courseNameArr[] = courseName.toCharArray();
		
		for (int i = courseNameArr.length - 1; i >= 0; i--) {
			System.out.print(courseNameArr[i]);
		}
	}
}
