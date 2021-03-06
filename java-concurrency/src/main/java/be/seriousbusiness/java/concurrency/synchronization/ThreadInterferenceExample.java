package be.seriousbusiness.java.concurrency.synchronization;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import be.seriousbusiness.java.concurrency.synchronization.counter.Counter;
import be.seriousbusiness.java.concurrency.synchronization.counter.SimpleCounter;

/**
 * Example implementation for Thread interference.</br>
 * Interference happens when two operations, running in different threads, but acting on the same data, interleave.</br>
 * This means that the two operations consist of multiple steps, and the sequences of steps overlap.</br<
 * </br>
 * source: <a href="http://docs.oracle.com/javase/tutorial/essential/concurrency/interfere.html"></a>
 * @author seriousbusiness
 *
 */
public class ThreadInterferenceExample {
	private static final Logger LOGGER=LoggerFactory.getLogger(ThreadInterferenceExample.class);
	
	/**
	 * Creates 3 CounterThread objects sharing one SimpleCounter and starts them.</br>
	 * When all finished the number should still be 0.
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(final String[] args) throws InterruptedException{
		final Counter counter=new SimpleCounter();
		final CounterThread counterThread1=new CounterThread(counter);
		final CounterThread counterThread2=new CounterThread(counter);
		final CounterThread counterThread3=new CounterThread(counter);
		LOGGER.info("The counter number is: {}",counter.getNumber());
		counterThread1.start();
		counterThread2.start();
		counterThread3.start();
		counterThread1.join();
		counterThread2.join();
		counterThread3.join();
		LOGGER.info("The counter number is: {}",counter.getNumber());
	}

}
