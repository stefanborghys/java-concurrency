package be.seriousbusiness.java.concurrency.synchronization;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ThreadInterferenceExampleTest {
	private static final Logger LOGGER=LoggerFactory.getLogger(ThreadInterferenceExample.class);
	
	/**
	 * This test creates 3 ThreadInterferenceExample objects and starts them.</br>
	 * When all finished the number should still be 0</br>
	 * as in total the counter is 30 000 times incremented and decremented, which results in 0</br>
	 * but in reality it's not.
	 * @throws InterruptedException
	 */
	@Ignore
	@Test
	public void testInterference() throws InterruptedException{
		final Counter counter=new Counter();
		final ThreadInterferenceExample threadInterferenceExample1=new ThreadInterferenceExample(counter);
		final ThreadInterferenceExample threadInterferenceExample2=new ThreadInterferenceExample(counter);
		final ThreadInterferenceExample threadInterferenceExample3=new ThreadInterferenceExample(counter);
		LOGGER.info("The counter number is: {}",counter.getNumber());
		Assert.assertEquals("The default number should be 0",0,counter.getNumber());
		threadInterferenceExample1.start();
		threadInterferenceExample2.start();
		threadInterferenceExample3.start();
		threadInterferenceExample1.join();
		threadInterferenceExample2.join();
		threadInterferenceExample3.join();
		LOGGER.info("The counter number is: {}",counter.getNumber());
		Assert.assertEquals("The default number should still be 0",0,counter.getNumber());
	}

}
