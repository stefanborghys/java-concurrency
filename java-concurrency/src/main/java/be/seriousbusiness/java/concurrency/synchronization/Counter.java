package be.seriousbusiness.java.concurrency.synchronization;

/**
 * Manages a number by allowing to increment or decrement it.
 * @author seriousbusiness
 *
 */
public class Counter {
	private int number;
	
	/**
	 * Create a new counter with it's number set to 0.
	 */
	public Counter(){
		number=0;
	}
	
	/**
	 * Increment the number by 1.
	 */
	public void increment(){
		number++;
	}
	
	/**
	 * Decrement the number by 1.
	 */
	public void decrement(){
		number--;
	}
	
	/**
	 * Retrieve the current number value.
	 * @return
	 */
	public int getNumber(){
		return number;
	}

}
