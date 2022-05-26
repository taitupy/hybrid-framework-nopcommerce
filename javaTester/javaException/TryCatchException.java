package javaException;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TryCatchException {

	public static void main(String[] args) throws IOException, InterruptedException {
		int number = 10;

		try {
			// Đúng : Chạy hết đoạn code trong try và ko qua catch
			// Sai : Gặp exception - nhảy qua catch
			number = number / 0;
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println(number);

		String[] browserName = { "Chrome", "Firefox", "Safari" };

		try {
			browserName[0] = "Edge Chromium";
			browserName[3] = "IE";
		} catch (Exception e) {
			e.printStackTrace();
		}

		for (String browser : browserName) {
			System.out.println(browser);
		}

		FileOutputStream outputStream = null;

		try {
			outputStream = new FileOutputStream("C://automationfc.jpg");
			outputStream.write(65);
			
		} catch (FileNotFoundException e) {
			System.out.println(e.toString());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			outputStream.close();
		}
		
		sleepInSecond(5);
	}

	public static void sleepInSecond(long timeout) throws InterruptedException {
		Thread.sleep(timeout * 1000);
	}

}
