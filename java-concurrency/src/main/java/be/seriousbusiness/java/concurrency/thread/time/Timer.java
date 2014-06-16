package be.seriousbusiness.java.concurrency.thread.time;

/**
 * A timer measures the number of milliseconds passed by since started.
 * @author seriousbusiness
 *
 */
public class Timer extends Thread {
	private long milliseconds;
	
	public Timer(){
		milliseconds=0;
	}

	/**
	 * Sets the start and frequently updates the number of milliseconds passed by.
	 */
	@Override
	public void run(){
		final long start=System.currentTimeMillis();
		while(true){
			if(isInterrupted()){
				setMilliseconds(start);
				break;
			}
			setMilliseconds(start);
		}
	}
	
	private void setMilliseconds(final long start){
		milliseconds=System.currentTimeMillis()-start;
	}
	
	/**
	 * Returns the number of milliseconds passed by since the timer was started.
	 * @return
	 */
	public long getMilliseconds(){
		return milliseconds;
	}
}
