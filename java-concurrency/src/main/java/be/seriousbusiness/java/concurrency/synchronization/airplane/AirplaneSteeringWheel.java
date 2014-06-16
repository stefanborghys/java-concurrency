package be.seriousbusiness.java.concurrency.synchronization.airplane;


public interface AirplaneSteeringWheel {
	static final int MINIMUM_HEIGHT=0,MAXIMUM_HEIGHT=5000;
	
	/**
	 * Make the airplane go up.
	 * @param meters number of meters to lift
	 */
	void up(final int meters);
	
	/**
	 * Make the airplane go down.
	 * @param meters number of meters to drop
	 */
	void down(final int meters);
	
	/**
	 * Get the airplane's current height
	 * @return
	 */
	int getHeight();
	
	/**
	 * Makes the airplane steer left.
	 */
	void left();
	
	/**
	 * Makes the airplane steer right.
	 */
	void right();
	
	/**
	 * Returns the current left or right level.</br>
	 * 0 means the plane is flying straight, -5 to -1 means left,</br>
	 * 1 to 5 means right.
	 * @return
	 */
	int getLevel();
	
	
}
