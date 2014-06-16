package be.seriousbusiness.java.concurrency.synchronization.timeout;

public class HeightController extends Thread {
	private AirplaneSteeringWheel airplaneSteeringWheel;
	
	public HeightController(final AirplaneSteeringWheel airplaneSteeringWheel){
		this.airplaneSteeringWheel=airplaneSteeringWheel;
	}
	
	/**
	 * Makes the airplane go up and down.
	 */
	@Override
	public void run(){
		try {
			airplaneSteeringWheel.up(500);
			Thread.sleep(2000); // Sleep for 2 seconds
			airplaneSteeringWheel.up(200);
			Thread.sleep(3000); // Sleep for  seconds
			airplaneSteeringWheel.up(100);
			Thread.sleep(5000); // Sleep for 5 seconds
			airplaneSteeringWheel.down(100);
			Thread.sleep(1000); // Sleep for 1 seconds
			airplaneSteeringWheel.down(100);
			Thread.sleep(1000); // Sleep for 1 seconds
			airplaneSteeringWheel.down(100);
			Thread.sleep(1000); // Sleep for 1 seconds
			airplaneSteeringWheel.down(100);
			Thread.sleep(1000); // Sleep for 1 seconds
			airplaneSteeringWheel.down(100);
			Thread.sleep(1000); // Sleep for 1 seconds
			airplaneSteeringWheel.down(100);
			Thread.sleep(1000); // Sleep for 1 seconds
			airplaneSteeringWheel.down(100);
			Thread.sleep(1000); // Sleep for 1 seconds
			airplaneSteeringWheel.down(100);
		} catch (final InterruptedException e) {
			return;
		} 
	}
	

}
