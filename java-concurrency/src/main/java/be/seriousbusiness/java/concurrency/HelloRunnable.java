package be.seriousbusiness.java.concurrency;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Implements Runnable which only defines the run() method.</br>
 * </br>
 * The Runnable implementations only requires to implement the run() method.</br>
 * It gives the freedom to extend from other classes.
 * @author seriousbusiness
 *
 */
public class HelloRunnable implements Runnable {
	private static final Logger LOGGER=LoggerFactory.getLogger(HelloRunnable.class);

	/**
	 * Contains code executed by a thread.
	 */
	public void run() {
		LOGGER.info("HelloRunnable's run() method is executed");
	}
	
	/**
	 * Creates and starts a new Thread containing a new HelloRunnable object.
	 * @param args
	 */
	public static void main(String[] args){
		new Thread(new HelloRunnable()).start();
	}

}
