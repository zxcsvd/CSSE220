package chatter;

/**
 * This runnable class should print:
 * 
 * Message 1 of 3
 * 
 * wait 2 seconds
 * 
 * Message 2 of 3
 * 
 * wait 2 seconds
 * 
 * Message 3 of 3....I'm exiting forever
 * 
 * and then it should exit
 * 
 */
public class ShortTalker implements Runnable{
	private String a;
	private String b;
	private String c;
	boolean isFinished;
	public ShortTalker(String a, String b, String c){
		this.isFinished = true;
		this.a = a;
		this.b = b;
		this.c = c;
	}
	@Override
	public void run() {
		try {
			/*
			 * Main "brains" inside an infinite loop, so the thread keeps
			 * running:
			 */

				// Work of the thread can include calls to other methods:
			
	
				System.out.println(this.a);
				Thread.sleep(2000);
				System.out.println(this.b);
				Thread.sleep(2000);
				System.out.println(this.c);
			
		} catch (InterruptedException exception) {

		}
		
	}
	
	//Your awesome code goes here
}
