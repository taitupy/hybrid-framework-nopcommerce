package javaAccModFirst;

public class Computer {
	// Property
	private int ssdSize;
	
	// default
	String ramProductName;
	
	protected String cpuProductName;
	
	public int vgaSize;
	
	// Method
	private void setSsdSize(int ssd_size) {
		ssdSize = ssd_size;
	}
	
	void setRamProductName(String ramProduct) {
		ramProductName = ramProduct;
	}
	
	protected void setCpuProductName(String cpuProduct) {
		cpuProductName = cpuProduct;
	}
	
	public void setVgaSize(int vgaSize) {
		this.vgaSize = vgaSize;
	}
	
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
