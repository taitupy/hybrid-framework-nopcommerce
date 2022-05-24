package javaOOP;

import javaOOP.overriding.Employee;
import javaOOP.overriding.Person;
import javaOOP.overriding.Student;

public class Testing extends Topic_04_Non_Access_Modifier{

	public static void main(String[] args) {
		Student s = new Student();
		s.eat();
		s.sleep();
		
		Employee e = new Employee();
		e.eat();
		e.sleep();
	}

}
