package be.seriousbusiness.java.concurrency.synchronization.airplane;

public class LeftRightController extends Thread {
	private AirplaneSteeringWheel airplaneSteeringWheel;
	
	public LeftRightController(final AirplaneSteeringWheel airplaneSteeringWheel){
		this.airplaneSteeringWheel=airplaneSteeringWheel;
	}
	
	/**
	 * Makes the airplane steer in the correct direction.
	 */
	@Override
	public void run(){
		try {
			airplaneSteeringWheel.left();
			Thread.sleep(5000); // Sleep for 5 seconds
			airplaneSteeringWheel.left();
			Thread.sleep(8000); // Sleep for 8 seconds
			airplaneSteeringWheel.left();
			Thread.sleep(9000); // Sleep for 9 seconds
			airplaneSteeringWheel.right();
			Thread.sleep(7000); // Sleep for 7 seconds
			airplaneSteeringWheel.right();
			Thread.sleep(10000); // Sleep for 10 seconds
			airplaneSteeringWheel.right();
		} catch (final InterruptedException e) {
			return;
		} 
		
	}

}
