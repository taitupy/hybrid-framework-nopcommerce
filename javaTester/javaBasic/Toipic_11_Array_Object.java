package javaBasic;

import org.testng.annotations.Test;

import net.bytebuddy.dynamic.scaffold.MethodRegistry.Handler.ForAbstractMethod;

public class Toipic_11_Array_Object {
	// Thuộc tính/ biến
	int age;
	String name;

	// Contructor: hàm khoi tạo
	public Toipic_11_Array_Object(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public void display() {
		System.out.println("Name: " + name);
		System.out.println("Age: " + age);
	}

	public static void main(String[] args) {
		Toipic_11_Array_Object[] students = new Toipic_11_Array_Object[3];

		students[0] = new Toipic_11_Array_Object("Tuan", 24);
		students[1] = new Toipic_11_Array_Object("Cuong", 25);
		students[2] = new Toipic_11_Array_Object("Duc", 24);

		for (int i = 0; i < students.length; i++) {
			students[i].display();
		}
	}
	

}
