package be.seriousbusiness.java.concurrency.synchronization.counter;


import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import be.seriousbusiness.java.concurrency.synchronization.CounterThread;
import be.seriousbusiness.java.concurrency.synchronization.counter.Counter;
import be.seriousbusiness.java.concurrency.synchronization.counter.SynchronizedMethodCounter;

public class SynchronizedMethodCounterTest {
	private static final Logger LOGGER=LoggerFactory.getLogger(SynchronizedMethodCounterTest.class);
	
	/**
	 * Tests the creates of 3 CounterThread objects sharing one SynchronizedMethodCounter and starts them.</br>
	 * When all finished the number should still be 0.
	 * @throws InterruptedException
	 */
	@Test
	public void test() throws InterruptedException{
		final Counter counter=new SynchronizedMethodCounter();
		final CounterThread counterThread1=new CounterThread(counter);
		final CounterThread counterThread2=new CounterThread(counter);
		final CounterThread counterThread3=new CounterThread(counter);
		LOGGER.info("The counter number is: {}",counter.getNumber());
		Assert.assertEquals("The number should be 0",0,counter.getNumber());
		counterThread1.start();
		counterThread2.start();
		counterThread3.start();
		counterThread1.join();
		counterThread2.join();
		counterThread3.join();
		LOGGER.info("The counter number is: {}",counter.getNumber());
		Assert.assertEquals("The number should still be 0",0,counter.getNumber());
	}

}
