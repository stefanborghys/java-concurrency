package be.seriousbusiness.java.concurrency.synchronization.airplane;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SynchronizedMethodAirplaneSteeringWheel implements AirplaneSteeringWheel {
	private static final Logger LOGGER=LoggerFactory.getLogger(SynchronizedMethodAirplaneSteeringWheel.class);
	private int height,level;
	
	public SynchronizedMethodAirplaneSteeringWheel(){
		height=0;
		level=0;
	}
	
	private synchronized final void upPerMeter(final int meters){
		for(int i=0; i<meters; i++){
			try {
				Thread.sleep(100); // 1/10 of a second
				height++;
			} catch (final InterruptedException e) {
				LOGGER.error("Going up was interrupted!",e);
			} 
		}
	}

	@Override
	public synchronized void up(final int meters) {
		if(meters>0){
			if(height+meters<MAXIMUM_HEIGHT){
				upPerMeter(meters);
			}else{
				upPerMeter(MAXIMUM_HEIGHT-height);
			}
		}
	}
	
	private synchronized final void downPerMeter(final int meters){
		for(int i=0; i<meters; i++){
			try {
				Thread.sleep(100); // 1/10 of a second
				height--;
			} catch (final InterruptedException e) {
				LOGGER.error("Going up was interrupted!",e);
			} 
		}
	}

	@Override
	public synchronized void down(final int meters) {
		if(meters>0){
			if(height-meters>MINIMUM_HEIGHT){
				downPerMeter(meters);
			}else{
				downPerMeter(height);
			}
		}
	}

	@Override
	public synchronized int getHeight() {
		return height;
	}

	@Override
	public synchronized void left() {
		if(level>-5){
			level--;
		}
	}

	@Override
	public synchronized void right() {
		if(level<5){
			level++;
		}
	}

	@Override
	public synchronized int getLevel() {
		return level;
	}
	
	/**
	 * Because multiple threads lock the SynchronizedMethodAirplaneSteeringWheel they lock each other out.</br>
	 * The result is that none of them can manipulate the steering wheel.
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(final String[] args) throws InterruptedException{
		final AirplaneSteeringWheel airplaneSteeringWheel=new SynchronizedMethodAirplaneSteeringWheel();
		final DashBoard dashBoard=new DashBoard(airplaneSteeringWheel);
		final HeightController heightController=new HeightController(airplaneSteeringWheel);
		final LeftRightController leftRightController=new LeftRightController(airplaneSteeringWheel);
		dashBoard.start();
		heightController.start();
		leftRightController.start();
		heightController.join();
		leftRightController.join();
		dashBoard.interrupt();
	}
}
