package be.seriousbusiness.java.concurrency.synchronization;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Example implementation for Thread interference.</br>
 * Interference happens when two operations, running in different threads, but acting on the same data, interleave.</br>
 * This means that the two operations consist of multiple steps, and the sequences of steps overlap.</br<
 * </br>
 * source: <a href="http://docs.oracle.com/javase/tutorial/essential/concurrency/interfere.html"></a>
 * @author seriousbusiness
 *
 */
public class ThreadInterferenceExample extends Thread {
	private static final Logger LOGGER=LoggerFactory.getLogger(ThreadInterferenceExample.class);
	private Counter counter;
	
	public ThreadInterferenceExample(final Counter counter){
		this.counter=counter;
	}
	
	/**
	 * Increments and decrements the counter 10 000 times.
	 */
	@Override
	public void run(){
		for(int i=0; i<100000; i++){
			counter.increment();
			counter.decrement();
		}
	}
	
	/**
	 * Creates 3 ThreadInterferenceExample objects and starts them.</br>
	 * When all finished the number should still be 0.
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(final String[] args) throws InterruptedException{
		final Counter counter=new Counter();
		final ThreadInterferenceExample threadInterferenceExample1=new ThreadInterferenceExample(counter);
		final ThreadInterferenceExample threadInterferenceExample2=new ThreadInterferenceExample(counter);
		final ThreadInterferenceExample threadInterferenceExample3=new ThreadInterferenceExample(counter);
		LOGGER.info("The counter number is: {}",counter.getNumber());
		threadInterferenceExample1.start();
		threadInterferenceExample2.start();
		threadInterferenceExample3.start();
		threadInterferenceExample1.join();
		threadInterferenceExample2.join();
		threadInterferenceExample3.join();
		LOGGER.info("The counter number is: {}",counter.getNumber());
	}

}
