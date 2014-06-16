package be.seriousbusiness.java.concurrency.thread.time;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A clock manages zero, one or more timers.</br>
 * A timer needs to be added before it can be started, stopped or it's time shown.
 * @author seriousbusiness
 *
 */
public class Clock {
	private static final Logger LOGGER=LoggerFactory.getLogger(Timer.class);
	private Map<String,Timer> timers;
	
	public Clock(){
		timers=new HashMap<String,Timer>();
	}
	
	/**
	 * Add a timer under a unique name.
	 * @param name
	 * @throws IllegalArgumentException when the name is already in use
	 */
	public void addTimer(final String name) throws IllegalArgumentException {
		if(timers.containsValue(name)){
			throw new IllegalArgumentException("The name is already in use");
		}else{
			timers.put(name.trim(),new Timer());
		}
	}
	
	/**
	 * Start all added timers.
	 */
	public void startAll(){
		for(Map.Entry<String,Timer> entry : timers.entrySet()){
			entry.getValue().start();
			LOGGER.info("Started timer: {}",entry.getKey());
		}
	}
	
	/**
	 * Start a timer by name.
	 * @param name
	 */
	public void start(final String name){
		timers.get(name.trim()).start();
		LOGGER.info("Started timer: {}",name);
	}
	
	/**
	 * Stop a timer by name.
	 * @param name
	 */
	public void stop(final String name){
		timers.get(name.trim()).interrupt();
		LOGGER.info("Stopped timer: {}",name);
	}
	
	/**
	 * Log a timer's time by name.
	 * @param name
	 */
	public void time(final String name){
		time(timers.get(name.trim()),name);
	}
	
	/**
	 * Log the time.
	 * @param timer
	 * @param name
	 */
	public void time(final Timer timer,final String name){
		final SimpleDateFormat simpleDateFormat=new SimpleDateFormat("mm:ss SS");
		final String time=simpleDateFormat.format(timer.getMilliseconds());
		LOGGER.info("{} :\t\t{}",name,time);
	}
	
	/**
	 * Log all timers time.
	 */
	public void time(){
		for(Map.Entry<String,Timer> entry : timers.entrySet()){
			time(entry.getValue(),entry.getKey());
		}
	}

}
