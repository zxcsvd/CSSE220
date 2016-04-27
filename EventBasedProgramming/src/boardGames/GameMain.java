package boardGames;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * A two player board game.
 * 
 * @author Curt Clifton. Created Oct 7, 2008.
 */
public class GameMain {
	private static final Game THE_GAME = new TicTacToe();
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;

	/**
	 * Starts the game.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		final JFrame frame = new JFrame();
		frame.setSize(WIDTH, HEIGHT);
		frame.setTitle(THE_GAME.getTitle());

		JPanel controls = new JPanel();
		JLabel promptLabel = new JLabel("prompt");
		controls.add(promptLabel);
		JButton quitButton = new JButton("Quit");
		controls.add(quitButton);
		frame.add(controls, BorderLayout.SOUTH);
		/*
		 * TODO: Add listener for quit button that _disposes_ of the frame and
		 * then calls System.exit(). (Disposing of a frame is the right way to
		 * tell Java we're done with it. See API docs for more details.)
		 */

		final GameRunner gr = new GameRunner(THE_GAME, promptLabel);
		frame.add(gr, BorderLayout.CENTER);
		/*
		 * TODO: add mouse listener for game runner that calls GameRunner with
		 * coordinates.
		 */

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
