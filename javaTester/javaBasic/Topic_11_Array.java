package javaBasic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Topic_11_Array {

	public static void main(String[] args) {
		int number[] = {12, 7, 5, 61, 15};
		int []student = {12, 7, 5, 61, 15};

		int b[] = new int[15];
		b[0] = 10;
		
		// Cố định
		// Được define cố định bao nhiêu phần tử khi mình viết code (Compile)
		String studentName[]= {"Long", "An","Nam"};
//		studentName[0] = "Hoa";
		
//		System.out.println(student[0]);
		
		String stdNewName[] = studentName.clone();
		
		// for...iterate
		// Kết hợp vs điều kiện khi xử lí
		for (int i = 0; i < studentName.length; i++) {
			if(studentName[i].equals("Long")) {
				System.out.println("Click vào Long");
			}
			
		}
		
		// for...each
		// Ko kết hợp vs điều kiện
		for (String std : studentName) {
			System.out.println(std);
		}
		
		// Động
		ArrayList<String> stdName = new ArrayList<String>();
		
		// Khi chạy code mới add (Runtime)
		for (String std : studentName) {
			stdName.add(std);
		}
		
		List<String> names = Arrays.asList("Tom", "Jerry", "Donald");
		for (String name : names) {
			System.out.println("Name: " + name);
		}
		
		String std_Name = Arrays.toString(studentName);
		System.out.println(std_Name);
		
//		"[Long, An, Nam]"
	}
	
}
