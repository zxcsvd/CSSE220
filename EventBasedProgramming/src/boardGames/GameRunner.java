package boardGames;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 * Runs a two-player board game.
 * 
 * @author Curt Clifton. Created Oct 7, 2008.
 */
public class GameRunner extends JComponent {

	private Game game;
	private JLabel promptLabel;

	/**
	 * Constructs a game runner for the given game with the given prompt label.
	 * 
	 * @param theGame
	 * @param promptLabel
	 */
	public GameRunner(Game theGame, JLabel promptLabel) {
		this.game = theGame;
		this.promptLabel = promptLabel;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.game.drawGameOn((Graphics2D) g, this.getSize());
		this.promptLabel.setText(this.game.getPlayerPrompt());
	}

	/**
	 * Tells this game runner that a player has clicked at the given
	 * coordinates.
	 * 
	 * @param x
	 * @param y
	 */
	public void clickedAt(int x, int y) {
		final Dimension size = this.getSize();
		if (this.game.isValidMove(x, y, size)) {
			this.game.executeMove(x, y, size);
			this.repaint();
			
			if (this.game.isGameOver()) {
				String msg;
				switch (this.game.getWinner()) {
				case ONE:
					msg = "Player One Wins!";
					break;
				case TWO:
					msg = "Player Two Wins!";
					break;
				default:
					msg = "Tied game";
				}
				JOptionPane.showMessageDialog(this, msg);
			}
		} else {
			Toolkit.getDefaultToolkit().beep();
		}
	}

}
