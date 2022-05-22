package javaOOP;

public class Topic_01_Class_Object_Student {
	// Thuộc tính
	private int studentID;
	private String studentName;
	private Float scoreTheorepy;
	private Float scorePractice;

	protected int getIdNumber() {
		return studentID;
	}

	protected void setIdNumber(int idNumber) {
		this.studentID = idNumber;
	}

	protected String getNameStudent() {
		return studentName;
	}

	protected void setNameStudent(String nameStudent) {
		this.studentName = nameStudent;
	}

	protected Float getScoreTheorepy() {
		return scoreTheorepy;
	}

	protected void setScoreTheorepy(Float scoreTheorepy) {
		this.scoreTheorepy = scoreTheorepy;
	}

	protected Float getScorePractice() {
		return scorePractice;
	}

	protected void setScorePractice(Float scorePractice) {
		this.scorePractice = scorePractice;
	}

	protected float getAveragePoint() {
		return ((this.scoreTheorepy + this.scorePractice * 2) / 3);
	}

	protected void showInforStudent() {
		System.out.println("=========================");
		System.out.println("Student ID = " + getIdNumber());
		System.out.println("Student Name = " + getNameStudent());
		System.out.println("Score Theorepy = " + getScoreTheorepy());
		System.out.println("Score Paractice = " + getScorePractice());
		System.out.println("Student average Point = " + getAveragePoint());
	}

	public static void main(String[] args) {
		Topic_01_Class_Object_Student student1 = new Topic_01_Class_Object_Student();
		
		// Instance variable
		student1.studentID = 12345;
		
		student1.setIdNumber(12345);
		student1.setNameStudent("Any Robertson");
		student1.setScoreTheorepy(7.5f);
		student1.setScorePractice(8f);
		student1.showInforStudent();
		
		Topic_01_Class_Object_Student student2 = new Topic_01_Class_Object_Student();
		
		student2.setIdNumber(45621);
		student2.setNameStudent("Daniel James");
		student2.setScoreTheorepy(9f);
		student2.setScorePractice(8.8f);
		student2.showInforStudent();
		
	}

}
