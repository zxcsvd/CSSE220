package gameOfLifeWithIO;

import java.awt.BorderLayout;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * This class is the starting point for the simulator for Conway's Game of Life.
 * 
 * @author Curt Clifton.
 */
public class GameOfLifeMain {
	private static final int WIDTH = 630;
	private static final int HEIGHT = 750;

	/**
	 * Starts the program
	 * 
	 * @param args
	 *            ignored
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		JFrame frame = new JFrame();

		frame.setSize(WIDTH, HEIGHT);
		frame.setTitle("Conway's Game of Life");

		ArrayList<Coordinates> coordList = getGliderList();
		final GameOfLife game = new GameOfLife(coordList);
		frame.add(game);

		LoadSaveHandler lsHandler = new LoadSaveHandler(game);
		final JPanel buttonPanel = new ButtonPanel(frame, game, lsHandler);
		frame.add(buttonPanel, BorderLayout.SOUTH);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		lsHandler.loadGameState();
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
