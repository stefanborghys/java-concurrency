package be.seriousbusiness.java.concurrency.thread;

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
public class ThreadExample extends Thread {
	private static final Logger LOGGER=LoggerFactory.getLogger(ThreadExample.class);
	
	/**
	 * Override's and implements Thread's run() method.
	 */
	@Override
	public void run(){
		LOGGER.info("ThreadExample's run() method is executed");
	}
	
	/**
	 * Creates a new ThreadExample and starts it.
	 * @param args
	 */
	public static void main(String[] args){
		new ThreadExample().start();
	}
}
