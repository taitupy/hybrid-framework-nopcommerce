package javaOOP;

public class Testing extends Topic_04_Non_Access_Modifier{

	public static void main(String[] args) {
		// Truy cập trực tiếp từ tên Class
		// Ko cần phải tạo instance/ object
		// ko nên lạm dụng tạo các biến là static
		
		// Khởi tạo các class
		Topic_04_Non_Access_Modifier.sendkeyToElement("Link");
		
		Topic_04_Non_Access_Modifier topic = new Topic_04_Non_Access_Modifier();
		System.out.println(topic.colorCar);
	}
	
	@Override
	public void clickToElement(String elementName) {
		
	}

}
