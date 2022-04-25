package javaAccModSecond;

import javaAccModFirst.Computer;

public class PC extends Computer {

	public void showCPUProductName() {
		// Property
		vgaSize = 6;
		System.out.println(vgaSize);
		
		// Method
		setVgaSize(12);
		System.out.println(vgaSize);
		
	}

}
