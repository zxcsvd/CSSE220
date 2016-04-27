package boardGames;

import java.awt.Dimension;
import java.awt.Graphics2D;

/**
 * This is the type of two player board games with alternating moves.
 * 
 * @author Curt Clifton
 */
public interface Game {
	/**
	 * This inner enumeration specifies the two players.
	 */
	public enum Player {
		/**
		 * Player one.
		 */
		ONE,
		/**
		 * Player two.
		 */
		TWO,
		/**
		 * Neither player.
		 */
		NEITHER;
	}

	/**
	 * @return the name of this game
	 */
	String getTitle();
	
	/**
	 * Returns a prompt that can be used to remind the players of what to do
	 * next.  For example, the result might be "X's turn".
	 *
	 * @return a prompt for the players
	 */
	String getPlayerPrompt();
	
	/**
	 * Checks whether the move specified by a click at the given position is
	 * currently valid in this game.
	 * 
	 * @param x
	 * @param y
	 * @param d the size of the game board
	 * @return whether the move is valid
	 */
	boolean isValidMove(int x, int y, Dimension d);

	/**
	 * Updates the game state based on a click at the given position. Requires
	 * that the move is currently valid in this game.
	 * 
	 * @param x
	 * @param y
	 * @param d the size of the game board
	 */
	void executeMove(int x, int y, Dimension d);

	/**
	 * @return whether the game is over
	 */
	boolean isGameOver();

	/**
	 * Draws the current game state on the given graphics object.
	 *
	 * @param g
	 * @param d the size of the game board
	 */
	void drawGameOn(Graphics2D g, Dimension d);

	/**
	 * Returns the winner of the game. Requires isGameOver();
	 * 
	 * @return the winner
	 */
	Player getWinner();
}
