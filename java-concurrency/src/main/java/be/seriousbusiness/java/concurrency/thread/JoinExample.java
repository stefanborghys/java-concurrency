package be.seriousbusiness.java.concurrency.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Example for a Threads join() method.</br>
 * This allows a Thread to wait for another Thread before performing another action.</br>
 * </br>
 * source: http://docs.oracle.com/javase/tutorial/essential/concurrency/join.html
 * @author seriousbusiness
 *
 */
public class JoinExample extends Thread {
	private static final Logger LOGGER=LoggerFactory.getLogger(JoinExample.class);
	
	/**
	 * Counts from 20 to 1,</br>
	 * and waits 1 second between every log.
	 */
	@Override
	public void run(){
		for(int i=20; i>0; i--){
			LOGGER.info("{}",i);
			try {
				sleep(1000); // Sleep for 1 second
			} catch (final InterruptedException e) {
				break;
			} 
		}
		LOGGER.info("I'm done!");
	}
	
	/**
	 * Creates a new JoinExample and starts this thread.</br>
	 * After starting it will wait for it before stopping itself.
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(final String[] args) throws InterruptedException{
		LOGGER.info("START");
		JoinExample joinExample=new JoinExample();
		joinExample.start();
		LOGGER.info("Let's wait for JoinExample, so i can stop.");
		joinExample.join(); // Commenting this, makes the main thread stop before JoinExample is finished
		LOGGER.info("STOP");
	}
}
