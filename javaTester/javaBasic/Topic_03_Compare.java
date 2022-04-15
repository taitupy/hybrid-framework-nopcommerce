package javaBasic;

public class Topic_03_Compare {
	int number = 15;
	public static void main(String[] args) {
		// Biến nguyên thủy sẽ tạo 1 vùng nhớ mới khi khai báo
		int x = 10;
		int y = x;
		
		System.out.println("Before assign = "+x);
		System.out.println("Before assign = "+y);
		
		y = 8;
		
		System.out.println("Before assign = "+x);
		System.out.println("Before assign = "+y);
		
		// Biến tham chiếu sẽ lưu trữ 1 giá trị là địa chỉ đến vùng nhớ mà nó có thể tham chiếu tới
		Topic_03_Compare firstTopic = new Topic_03_Compare(); // tạo ra 1 địa chỉ mới
		Topic_03_Compare secondTopic = firstTopic;
		
		System.out.println("Before assign = "+ firstTopic.number);
		System.out.println("Before assign = "+ secondTopic.number);
		
		firstTopic.number = 76;
		System.out.println("Before assign = "+ firstTopic.number);
		System.out.println("Before assign = "+ secondTopic.number);
	}

}
