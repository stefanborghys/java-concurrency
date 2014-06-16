package be.seriousbusiness.java.concurrency.synchronization.timeout;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DashBoard extends Thread {
	private static final Logger LOGGER=LoggerFactory.getLogger(DashBoard.class);
	private AirplaneSteeringWheel airplaneSteeringWheel;
	
	public DashBoard(final AirplaneSteeringWheel airplaneSteeringWheel){
		this.airplaneSteeringWheel=airplaneSteeringWheel;
	}
	
	@Override
	public void run(){
		while(true){
			if(interrupted()){
				break;
			}else{
				LOGGER.info("Height: {} - Steering: {}",airplaneSteeringWheel.getHeight(),airplaneSteeringWheel.getLevel());
			}
		}
	}
}
