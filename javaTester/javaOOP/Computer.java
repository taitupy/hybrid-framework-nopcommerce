package javaOOP;

public abstract class Computer {

	// Normal Method
	public void showComputerPerfomance() {
		System.out.println("Show Computer perfomance");
	}
	
	// Abstract Method
	// Khung để cho các Clas con kế thừa nó phải override lại (implement) lại
	public abstract void showComputerRam();

}
