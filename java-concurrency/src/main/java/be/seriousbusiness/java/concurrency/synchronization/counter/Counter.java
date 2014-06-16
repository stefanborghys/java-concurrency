package be.seriousbusiness.java.concurrency.synchronization.counter;

/**
 * Allows to manage a number by providing increment and decrement functionality.
 * @author seriousbusiness
 *
 */
public interface Counter {
	
	/**
	 * Increment the number by 1.
	 */
	void increment();
	
	/**
	 * Decrement the number by 1.
	 */
	void decrement();
	
	/**
	 * Retrieve the current number value.
	 * @return
	 */
	int getNumber();
}
