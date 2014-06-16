package be.seriousbusiness.java.concurrency.synchronization;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ThreadInterferenceExampleTest {
	private static final Logger LOGGER=LoggerFactory.getLogger(ThreadInterferenceExample.class);
	
	@Test
	public void testInterference(){
		final Counter counter=new Counter();
		final ThreadInterferenceExample threadInterferenceExample1=new ThreadInterferenceExample(counter);
		final ThreadInterferenceExample threadInterferenceExample2=new ThreadInterferenceExample(counter);
		LOGGER.info("The counter number is: {}",counter.getNumber());
		Assert.assertEquals("The default number should be 0",0,counter.getNumber());
		threadInterferenceExample1.start();
		threadInterferenceExample2.start();
		for(int i=0; i<10000; i++){
			LOGGER.info("Increment threadInterferenceExample1");
			threadInterferenceExample1.increment();
			LOGGER.info("The counter number is: {}",counter.getNumber());
			Assert.assertEquals("The number should be 1",1,counter.getNumber());
			LOGGER.info("Decrement threadInterferenceExample2");
			threadInterferenceExample2.decrement();
			LOGGER.info("The counter number is: {}",counter.getNumber());
			Assert.assertEquals("The number should be 0",0,counter.getNumber());
		}
	}

}
