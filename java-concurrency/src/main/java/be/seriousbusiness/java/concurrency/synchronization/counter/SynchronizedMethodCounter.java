package be.seriousbusiness.java.concurrency.synchronization.counter;


public class SynchronizedMethodCounter implements Counter {
	private int number;
	
	public SynchronizedMethodCounter(){
		number=0;
	}
	
	@Override
	public synchronized void increment(){
		number++;
	}
	
	@Override
	public synchronized void decrement(){
		number--;
	}
	
	@Override
	public synchronized int getNumber(){
		return number;
	}

}
