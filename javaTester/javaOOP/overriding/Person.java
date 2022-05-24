package javaOOP.overriding;

public abstract class Person {
	// Option - annotation @Override
	public void eat() {
		System.out.println("Suất cơm 20.000 VNĐ");
	}
	
	// Must (Template)- annotation @Override
	public abstract void sleep();
	
	public final void walk() {
		System.out.println("Đi bộ");
	}
	
	public static void run() {
		System.out.println("Chạy bộ");
	}
	
	private void dating() {
		System.out.println("Hẹn hò");
	}
	
	
}
