package be.seriousbusiness.java.concurrency;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Example of the Thread.sleep(milliseconds) method.</br>
 * The sleep time is not guaranteed to be precise.</br>
 * As they can be limited by the underlying OS or get interrupted.</br>
 * </br>
 * source: http://docs.oracle.com/javase/tutorial/essential/concurrency/sleep.html
 * @author seriousbusiness
 *
 */
public class SleepingThreadExample {
	private static final Logger LOGGER=LoggerFactory.getLogger(SleepingThreadExample.class);
	
	/**
	 * Says hello, sleeps for 3 seconds and notifies about it.</br>
	 * This is repeated for 10 times.
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(final String[] args) throws InterruptedException{
		final SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd/MM/yyyy kk:mm:ss SS");
		for(int i=0; i<10; i++){
			LOGGER.info("{} - Hello {}!",simpleDateFormat.format(new Date()),i+1);
			Thread.sleep(3000); // Sleep for 3 seconds
			LOGGER.info("{} - Just slept for 3 seconds",simpleDateFormat.format(new Date()));
		}
	}

}
