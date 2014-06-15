package be.seriousbusiness.java.concurrency;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Extends Thread which on his turn implements Runnable.</br>
 * The Thread's run() method contains not logic, so needs to be overridden.</br>
 * </br>
 * Thread defines a number of useful methods for thread management.</br>
 * But limits by the fact that your class must be a descendant of Thread.
 * @author seriousbusiness
 *
 */
public class HelloThread extends Thread {
	private static final Logger LOGGER=LoggerFactory.getLogger(HelloThread.class);
	
	/**
	 * Override's and implements Thread's run() method.
	 */
	@Override
	public void run(){
		LOGGER.info("HelloThread's run() method is executed");
	}
	
	/**
	 * Creates a new HelloThread and starts it.
	 * @param args
	 */
	public static void main(String[] args){
		new HelloThread().start();
	}
}
