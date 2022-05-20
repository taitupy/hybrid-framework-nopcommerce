package javaOOP;

public class exerciseOOP {
	// Thuộc tính
	private int idNumber;
	private String nameStudent;
	private Float scoreTheorepy;
	private Float scorePractice;

	protected exerciseOOP(int idNumber, String nameStudent, Float scoreTheorepy, Float scorePractice) {
		super();
		this.idNumber = idNumber;
		this.nameStudent = nameStudent;
		this.scoreTheorepy = scoreTheorepy;
		this.scorePractice = scorePractice;
	}

	protected int getIdNumber() {
		return idNumber;
	}

	protected void setIdNumber(int idNumber) {
		this.idNumber = idNumber;
	}

	protected String getNameStudent() {
		return nameStudent;
	}

	protected void setNameStudent(String nameStudent) {
		this.nameStudent = nameStudent;
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

	protected float scoreTB() {
		return ((scoreTheorepy + scorePractice * 2) / 3);
	}

	protected void showInforStudent() {
		System.out.println("=========================");
		System.out.println("ID Number = " + getIdNumber());
		System.out.println("Student Name = " + getNameStudent());
		System.out.println("Score Theorepy = " + getScoreTheorepy());
		System.out.println("Score Paractice = " + getScorePractice());
		System.out.println("Score_TB = " + scoreTB());
	}

	public static void main(String[] args) {
		exerciseOOP student1 = new exerciseOOP(123, "Nguyen A", 7.5f, 8f);
		student1.showInforStudent();
		
		exerciseOOP student2 = new exerciseOOP(555, "Nguyen Tan Dat", 9f, 8f);
		student2.showInforStudent();
	}

}
