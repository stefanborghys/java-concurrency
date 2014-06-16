package be.seriousbusiness.java.concurrency.synchronization.airplane;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SynchronizedStatementAirplaneSteeringWheel implements AirplaneSteeringWheel {
	private static final Logger LOGGER=LoggerFactory.getLogger(SynchronizedStatementAirplaneSteeringWheel.class);
	private int height,level;
	private Object synchronizedHeight,synchronizedLevel;
	
	public SynchronizedStatementAirplaneSteeringWheel(){
		height=0;
		level=0;
		synchronizedHeight=new Object();
		synchronizedLevel=new Object();
	}
	
	private final void upPerMeter(final int meters){
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
	public void up(final int meters) {
		synchronized(synchronizedHeight){
			if(meters>0){
				if(height+meters<MAXIMUM_HEIGHT){
					upPerMeter(meters);
				}else{
					upPerMeter(MAXIMUM_HEIGHT-height);
				}
			}
		}
	}
	
	private final void downPerMeter(final int meters){
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
	public void down(final int meters) {
		synchronized(synchronizedHeight){
			if(meters>0){
				if(height-meters>MINIMUM_HEIGHT){
					downPerMeter(meters);
				}else{
					downPerMeter(height);
				}
			}
		}
	}

	@Override
	public int getHeight() {
		return height;
	}

	@Override
	public void left() {
		synchronized(synchronizedLevel){
			if(level>-5){
				level--;
			}
		}
	}

	@Override
	public void right() {
		synchronized(synchronizedLevel){
			if(level<5){
				level++;
			}
		}
	}

	@Override
	public synchronized int getLevel() {
		return level;
	}
	
	/**
	 * Because the up/down and left/right steering of the SynchronizedStatementAirplaneSteeringWheel is divided</br>
	 * using synchronized statements both can be manipulated without a thread locking each other out.</br>  
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(final String[] args) throws InterruptedException{
		final AirplaneSteeringWheel airplaneSteeringWheel=new SynchronizedStatementAirplaneSteeringWheel();
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
