package gameOfLifeWithIO;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * A panel containing buttons for running the game.
 * 
 * @author Curt Clifton.
 */
class ButtonPanel extends JPanel {
	/**
	 * Constructs a button panel.
	 * 
	 * @param frame
	 *            the main frame containing the game, used for cleanup at exit
	 * @param game
	 *            the game, started and stopped by buttons
	 * @param lsHandler
	 *            the class that handles load and save operations
	 */
	public ButtonPanel(final JFrame frame, final GameOfLife game,
			final LoadSaveHandler lsHandler) {

		final JButton startButton = new JButton("Start");
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.animate();
			}
		});
		this.add(startButton);

		final JButton stopButton = new JButton("Stop");
		stopButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.pause();
			}
		});
		this.add(stopButton);

		final JButton quitButton = new JButton("Quit");
		quitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lsHandler.saveGameState();
				frame.dispose();
				System.exit(0);
			}
		});
		this.add(quitButton);
	}
}
