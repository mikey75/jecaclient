package net.wirelabs.jecaclient.core;

public class Utils {
	
	public static void sleep(int seconds) {
		try {
			Thread.sleep(1000 * seconds);
		} catch (InterruptedException e) {
			System.out.println("Error sleeping");
		}
	}
	
	public static void sleepmili(long miliseconds) {
		try {
			Thread.sleep(miliseconds);
		} catch (InterruptedException e) {
			System.out.println("Error sleeping");
		}
	}
}
