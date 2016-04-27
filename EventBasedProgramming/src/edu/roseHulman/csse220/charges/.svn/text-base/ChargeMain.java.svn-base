package edu.roseHulman.csse220.charges;

import javax.swing.JFrame;

/**
 * Starts the Charges application.
 * 
 * @author Curt Clifton. Created Oct 3, 2008.
 */
public class ChargeMain {

	private static final int HEIGHT = 600;
	private static final int WIDTH = 900;

	/**
	 * Starts the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(WIDTH, HEIGHT);
		frame.setTitle("Charge!");

		// TODO: space probably needs to be final, why?
		Space space = new Space();
		addCharges(space);

		frame.add(space);

		// TODO: add Zoom In and Zoom Out buttons to the GUI.

		// TODO: set up action listeners for zoom in and zoom out buttons

		/* TODO: Add mouse listener to allow drawing on the space.  Use 
		 * the SpaceClickHandler class to implement the MouseListener. 
		 */

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	// TODO: create and use an external class to handle mouse events

	/**
	 * Adds charges to the given space for simulation purposes.
	 * 
	 * @param space
	 *            the charge space to simulate (mutated)
	 */
	private static void addCharges(Space space) {
		space.addCharge(new PointCharge(10, 10, 3.0));
		space.addCharge(new PointCharge(20, 10, -3.0));

		space.addCharge(new LinearCharge(0, 5, 30, 5, 10.0));
		space.addCharge(new LinearCharge(0, 15, 30, 15, -10.0));
	}

}
