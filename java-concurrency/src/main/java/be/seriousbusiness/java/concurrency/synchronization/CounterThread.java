package be.seriousbusiness.java.concurrency.synchronization;

import be.seriousbusiness.java.concurrency.synchronization.counter.Counter;


/**
 * Increments and decrements a counter.
 * @author seriousbusiness
 *
 */
public class CounterThread extends Thread {
	private Counter counter;
	
	public CounterThread(final Counter counter){
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
}
