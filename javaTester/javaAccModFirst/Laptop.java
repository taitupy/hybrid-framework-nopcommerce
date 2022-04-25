package javaAccModFirst;

public class Laptop extends Computer {

	public static void main(String[] args) {
		Computer comp = new Computer();
		
		// Property
		comp.vgaSize = 6;
		System.out.println(comp.vgaSize);
		
		// Method
		comp.setVgaSize(4);
		System.out.println(comp.vgaSize);
	
	}
}
