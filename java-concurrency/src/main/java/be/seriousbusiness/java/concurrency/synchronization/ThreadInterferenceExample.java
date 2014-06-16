package be.seriousbusiness.java.concurrency.synchronization;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ThreadInterferenceExample extends Thread {
	private static final Logger LOGGER=LoggerFactory.getLogger(ThreadInterferenceExample.class);
	private Counter counter;
	
	public ThreadInterferenceExample(final Counter counter){
		this.counter=counter;
	}
	
	public void increment(){
		counter.increment();
	}
	
	public void decrement(){
		counter.decrement();
	}
	
	public static void main(final String[] args){
		final Counter counter=new Counter();
		final ThreadInterferenceExample threadInterferenceExample1=new ThreadInterferenceExample(counter);
		final ThreadInterferenceExample threadInterferenceExample2=new ThreadInterferenceExample(counter);
		LOGGER.info("The counter number is: {}",counter.getNumber());
		threadInterferenceExample1.start();
		threadInterferenceExample2.start();
		LOGGER.info("Increment threadInterferenceExample1");
		threadInterferenceExample1.increment();
		LOGGER.info("The counter number is: {}",counter.getNumber());
		LOGGER.info("Decrement threadInterferenceExample2");
		threadInterferenceExample2.decrement();
		LOGGER.info("The counter number is: {}",counter.getNumber());
	}

}
