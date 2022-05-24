package javaOOP.overriding;

public class Student extends Person implements IWork{
	@Override
	public void eat() {
		System.out.println("Suất cơm 15.000 VNĐ");
	}

	@Override
	public void sleep() {
		System.out.println("ngủ : 12h");
	}

	@Override
	public void workingTime() {
		System.out.println("học : 6h/ ngày");
	}

}
