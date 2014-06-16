package be.seriousbusiness.java.concurrency.thread.time;

import org.junit.Test;

import be.seriousbusiness.java.concurrency.thread.time.Clock;

public class ClockTest {
	
	/**
	 * Test a Clock by setting up a simple test scenario</br>
	 * of three timers, stopped independently from each other.</br>
	 * Afterwards the result is logged.</br>
	 * No errors should occur during this test.
	 * @throws InterruptedException
	 */
	@Test
	public void test() throws InterruptedException{
		final Clock clock=new Clock();
		clock.addTimer("Jef");
		clock.addTimer("An");
		clock.addTimer("Eva");
		clock.startAll();
		Thread.sleep(5000); // Sleep 5 seconds
		clock.stop("An");
		Thread.sleep(2000); // Sleep 2 seconds
		clock.stop("Jef");
		Thread.sleep(3000); // Sleep 3 seconds
		clock.stop("Eva");
		clock.time();
	}

}
