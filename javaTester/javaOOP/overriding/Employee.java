package javaOOP.overriding;

public class Employee extends Person implements IWork{
	@Override
	public void eat() {
		System.out.println("Suất cơm 25.000 VNĐ");
	}

	@Override
	public void sleep() {
		System.out.println("ngủ : 8h");
	}

	@Override
	public void workingTime() {
		System.out.println("học : 8h/ ngày");
	}
}
