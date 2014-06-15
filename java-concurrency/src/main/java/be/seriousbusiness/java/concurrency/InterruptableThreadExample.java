package be.seriousbusiness.java.concurrency;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Implements an interruptible Thread example.</br>
 * Interrupt: indication for a thread to stop what it's doing.</br>
 * A thread can be interrupted by calling it's interrupt() method.</br>
 * </br>
 * source: http://docs.oracle.com/javase/tutorial/essential/concurrency/interrupt.html
 * @author seriousbusiness
 *
 */
public class InterruptableThreadExample extends Thread {
	private static final Logger LOGGER=LoggerFactory.getLogger(InterruptableThreadExample.class);
	
	/**
	 * Logs the date continuously every second.</br>
	 * When interrupted the logging is stopped.
	 */
	public void run(){
		final SimpleDateFormat simpleDateFormat=new SimpleDateFormat("kk:mm:ss");
		while(true){
			if(interrupted()){
				LOGGER.info("I'm interrupted, goodbye!");
			}
			LOGGER.info("[{}] - Is interrupted? {}",simpleDateFormat.format(new Date()),isInterrupted());
			try {
				sleep(1000); // Sleep for 1 second
			} catch (final InterruptedException e) {
				LOGGER.info("I'm interrupted while sleeping, goodbye!");
				break;
			}
		}
	}
	
	/**
	 * Starts the InterruptableThreadExample Thread and interrupts it after 10 seconds.
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(final String[] args) throws InterruptedException{
		final InterruptableThreadExample interruptableThreadExample=new InterruptableThreadExample();
		LOGGER.info("STARTED thread InterruptableThreadExample");
		interruptableThreadExample.start();
		Thread.sleep(10000); // Sleep for 10 seconds
		LOGGER.info("INTERRUPT thread InterruptableThreadExample");
		interruptableThreadExample.interrupt(); // Interrupt the InterruptableThreadExample
	}

}
