package be.seriousbusiness.java.concurrency.synchronization.counter;


public class SimpleCounter implements Counter {
	private int number;
	
	/**
	 * Create a new counter with it's number set to 0.
	 */
	public SimpleCounter(){
		number=0;
	}
	
	@Override
	public void increment(){
		number++;
	}
	
	@Override
	public void decrement(){
		number--;
	}
	
	@Override
	public int getNumber(){
		return number;
	}

}
