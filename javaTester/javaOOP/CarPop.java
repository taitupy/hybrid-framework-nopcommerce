package javaOOP;

public class CarPop {
	static String carCompany;
	static String carType;
	static String fuelType;
	static Float mileAge;
	static Double carPrice;
	
	public static void main(String[] args) {
		carCompany = "Honda";
		carType = "City";
		fuelType = "Petrol";
		mileAge = 200f;
		carPrice = 50000d;
		System.out.println("Car company = " + carCompany);
		System.out.println("Car type = " + carType);
		System.out.println("Car fuel Type = " + fuelType);
		System.out.println("Car mile Age = " + mileAge);
		System.out.println("Car price = " + carPrice);
		
		carCompany = "Huyndai";
		carType = "Acent";
		fuelType = "Diazel";
		mileAge = 500f;
		carPrice = 30000d;
		System.out.println("Car company = " + carCompany);
		System.out.println("Car type = " + carType);
		System.out.println("Car fuel Type = " + fuelType);
		System.out.println("Car mile Age = " + mileAge);
		System.out.println("Car price = " + carPrice);
		
	}
}
