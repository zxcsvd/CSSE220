import java.awt.event.MouseEvent;

/**
 * 
 * This is where you should put the code to print out text like
 * "You pressed South".  You'll also need to modify CompassViewer.
 * 
 * 
 * @author Michael Hewner
 *
 */
public class MyEventHandler implements CompassEventListener{

	@Override
	public void northClicked(MouseEvent e) {
		System.out.println("North!");
		
	}

	@Override
	public void southClicked(MouseEvent e) {
		System.out.println("South!");
		
	}

	@Override
	public void eastClicked(MouseEvent e) {
		System.out.println("East!");
		
	}

	@Override
	public void westClicked(MouseEvent e) {
		System.out.println("West!");
		
	}

	// TODO: Your code here
	// Hint: you'll need to modify the declaration of class MyEventHandler slightly
}
