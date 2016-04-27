import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JFrame;

/**
 * This class is the starting point for the simulator for Conway's Game of Life.
 * 
 * @author TODO 0: [Logan Erexson and Bo Peng]. Created Sep 24, 2008.
 */
public class GameOfLifeMain {

	private static final int WIDTH = 630;
	private static final int HEIGHT = 750;

	/**
	 * Starts the program
	 * 
	 * @param args
	 *            ignored
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame();

		frame.setSize(WIDTH, HEIGHT);
		frame.setTitle("Conway's Game of Life");

		ArrayList<Coordinates> coordList = getGliderList();
		final GameOfLife game = new GameOfLife(coordList);
		frame.add(game);

		/*
		 * This adds an update button to the frame. We'll cover more on how to
		 * do this over the rest of the term.
		 */
		final UpdateButton updateButton = new UpdateButton(game);
		frame.add(updateButton, BorderLayout.SOUTH);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		// Optional: Add a Timer here to click the button every 50 milliseconds.
		// When importing the Timer, choose the javax.swing Timer.
		
	}

	/**
	 * @return a list of coordinates representing the glider configuration
	 */
	private static ArrayList<Coordinates> getGliderList() {
		ArrayList<Coordinates> coordList = new ArrayList<Coordinates>();
		coordList.add(new Coordinates(80, 1));
		coordList.add(new Coordinates(80, 2));
		coordList.add(new Coordinates(80, 3));
		coordList.add(new Coordinates(81, 3));
		coordList.add(new Coordinates(82, 2));
		return coordList;
	}

}
