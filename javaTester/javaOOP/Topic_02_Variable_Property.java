package javaOOP;

public class Topic_02_Variable_Property {
	// Access Modifier
	// Data Type
	// Variable name
	// Variable value
	private String studentName = "Automation FC"; // Biến toàn cục (Global variable)
	
	// Static variable: dùng và gán lại được cho các class khác nhau
	public static String studentAddress = "Ho Chi Minh";
	
	// Dùng trong phạm vi Class này ( cho tất cả instance/ object dùng)
	private static String studentPhone = "0987654321";
	
	// Final variable : Ko cho phép gán lại/ ko override lại
	// Cố định dữ liệu ko được phép thay đổi trong quá trình chạy
	final String country = "Viet Nam";
	
	// Static final variable: hằng số (Constant)
	// Nó ko được ghi đè
	// Có thể truy cập rộng rãi cho tất cả các instance/ thread
	static final float PI_NUMBER = 3.142323332f;
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
