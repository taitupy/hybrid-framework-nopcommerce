package javaOOP.inheritance;

public class Annimal {

	public Annimal() {
		System.out.println("Parent's Constructor");
	}

	public Annimal(String name) {
		System.out.println("Parent's Constructor- " + name);
	}

	public Annimal(String name, int age) {
		System.out.println("Parent's Constructor- " + name);
		System.out.println("Parent's Constructor- " + age);
	}

}
