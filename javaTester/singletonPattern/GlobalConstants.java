package singletonPattern;

public class GlobalConstants {
	// Private static variable
	private static GlobalConstants globalInstance;
	
	private GlobalConstants() {
		
	}
	
	public static GlobalConstants getGlobalConstants() {
		if (globalInstance == null) {
			globalInstance = new GlobalConstants();
			System.out.println("New Instance");
		}else {
			System.out.println("Existing instance");
		}
		return globalInstance;
	}
}
