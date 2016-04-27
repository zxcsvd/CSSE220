package chatter;

import java.io.IOException;
import java.nio.CharBuffer;

/**
 * Shouts (to the console) at random intervals
 * 
 * @author Curt Clifton, modified by Buffalo
 */
public class Ranter implements Runnable {
	private static final int RANGE = 5000;
	private static final int MINIMUM = 250;

	private final String message;
	private long pauseInMS;

	/**
	 * Creates a ranter with the given message.
	 * 
	 * @param message
	 */
	public Ranter(String message) {
		this.message = message;
		
	}

	/**
	 * Prints the message and then sleeps.  
	 * You shouldn't need to modify this method.
	 * 
	 * @throws InterruptedException
	 */
	public void printMessageAndSleepRandomAmountofTime() throws InterruptedException {
		System.out.println(this.message);
		Thread.sleep(getRandomSleepTime());
	}

	private long getRandomSleepTime() {
		return (long) (Math.random() * RANGE + MINIMUM);
	}


	@Override
	public void run() {
		while (true) {
			// Work of the thread can include calls to other methods:
			long messagesPerMinute = getRandomSleepTime() ;
			this.pauseInMS = messagesPerMinute;
			try {
				this.printMessageAndSleepRandomAmountofTime();
			} catch (InterruptedException exception1) {
				// TODO Auto-generated catch-block stub.
				exception1.printStackTrace();
			}

			/*
			 * After the work is done, put the thread to sleep so other
			 * threads can work. (Or the CPU can rest if no other threads
			 * are active.)
			 */
			try {
				Thread.sleep(this.getRandomSleepTime());
			} catch (InterruptedException exception) {
				// TODO Auto-generated catch-block stub.
				exception.printStackTrace();
			}
		// TODO Auto-generated method stub.
		
	}
	}
}
