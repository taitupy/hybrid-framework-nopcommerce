package javaBasic;

public class Topic_01_Variable {
	static int studentNumber;
	static boolean statusValue;
	static final String BROWSER_NAME = "Chrome";// constant

	static int studentPrice;

	protected String studentName = "Automation FC";

	public static void main(String[] args) {

		System.out.println(studentNumber);
		System.out.println(statusValue);

		System.out.println(studentPrice);

		// từ class prefer tới biến
		System.out.println(Topic_01_Variable.BROWSER_NAME);

		// Khai báo đối tượng
		Topic_01_Variable topic_1 = new Topic_01_Variable();
		Topic_01_Variable topic_2 = new Topic_01_Variable();
		Topic_01_Variable topic_3 = new Topic_01_Variable();

		// từ đối tượng prefer tới biến
		
		 System.out.println(topic_1.studentName);
		 System.out.println(topic_2.studentName);
		 System.out.println(topic_3.studentName);
		 
	}

	// Getter: getCurrentUrl/
	// getTitle/getText/getAttribute/getCssValue/getSize/getLocation/getPosition/...
	public String getStudentName() {
		return this.studentName;
	}

	// Setter: click/sendkey/clear/select/back/forward/refresh/get/...
	public void setStudentName(String stdName) {
		this.studentName = stdName;
	}
}
