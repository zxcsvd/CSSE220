package boardGames;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

/**
 * This class implements TicTacToe
 * 
 * @author Curt Clifton. Created Oct 7, 2008.
 */
public class TicTacToe implements Game {
	private static final int SIZE = 3;
	private Player[][] tokens;
	private Player turn;
	private Player winner;

	/**
	 * Constructs a new game of tic-tac-toe.
	 */
	public TicTacToe() {
		this.tokens = new Player[SIZE][SIZE];
		for (int r = 0; r < SIZE; r++) {
			for (int c = 0; c < SIZE; c++) {
				this.tokens[r][c] = Player.NEITHER;
			}
		}
		this.turn = Player.ONE;
		this.winner = Player.NEITHER;
	}

	@Override
	public void drawGameOn(Graphics2D g, Dimension d) {
		double width = d.getWidth();
		double height = d.getHeight();
		double cellWidth = width / SIZE;
		double cellHeight = height / SIZE;

		Line2D line;

		// Draws background
		for (int i = 0; i < SIZE - 1; i++) {
			double x = (i + 1) * cellWidth;
			line = new Line2D.Double(x, 0, x, height);
			g.draw(line);

			double y = (i + 1) * cellHeight;
			line = new Line2D.Double(0, y, width, y);
			g.draw(line);
		}

		// Draws pieces
		for (int r = 0; r < SIZE; r++) {
			for (int c = 0; c < SIZE; c++) {
				double x = c * cellWidth;
				double y = r * cellHeight;
				switch (this.tokens[r][c]) {
				case ONE:
					// Draws X
					line = new Line2D.Double(x, y, x + cellWidth, y
							+ cellHeight);
					g.draw(line);
					line = new Line2D.Double(x, y + cellHeight, x + cellWidth,
							y);
					g.draw(line);
					break;
				case TWO:
					// Draws O
					Ellipse2D o = new Ellipse2D.Double(x, y, cellWidth,
							cellHeight);
					g.draw(o);
					break;
				default:
					break;
				}
			}
		}
	}

	@Override
	public void executeMove(int x, int y, Dimension d) {
		// Converts x and y into row and column
		double cellWidth = d.getWidth() / SIZE;
		double cellHeight = d.getHeight() / SIZE;
		int row = (int) Math.floor(y / cellHeight);
		int col = (int) Math.floor(x / cellWidth);

		this.tokens[row][col] = this.turn;
		switch (this.turn) {
		case ONE:
			this.turn = Player.TWO;
			break;
		case TWO:
			this.turn = Player.ONE;
			break;
		default:
			break;
		}
	}

	@Override
	public Player getWinner() {
		return this.winner;
	}

	@Override
	public boolean isGameOver() {
		return isRowWin() || isColumnWin() || isDiagonalWin() || isDraw();
	}

	private boolean isDraw() {
		for (int r = 0; r < SIZE; r++) {
			for (int c=0; c<SIZE; c++) {
				if (this.tokens[r][c] == Player.NEITHER) {
					return false;
				}
			}
		}

		return true;
	}

	private boolean isDiagonalWin() {
		int sum = 0;
		int sum2 = 0;
		for (int i=0; i<SIZE; i++) {
			sum += tokenAsInt(i,i);
			sum2 += tokenAsInt(i,SIZE-1-i);
		}
		if (sum == SIZE || sum2 == SIZE) {
			this.winner = Player.ONE;
			return true;
		} else if (sum == -SIZE || sum2 == -SIZE) {
			this.winner = Player.TWO;
			return true;
		}
		return false;
	}

	private boolean isColumnWin() {
		for (int c = 0; c < SIZE; c++) {
			int sum = 0;
			for (int r = 0; r < SIZE; r++) {
				sum += tokenAsInt(r, c);
			}
			if (sum == SIZE) {
				this.winner = Player.ONE;
				return true;
			} else if (sum == -SIZE) {
				this.winner = Player.TWO;
				return true;
			}
		}
		return false;
	}

	private boolean isRowWin() {
		for (int r = 0; r < SIZE; r++) {
			int sum = 0;
			for (int c = 0; c < SIZE; c++) {
				sum += tokenAsInt(r, c);
			}
			if (sum == SIZE) {
				this.winner = Player.ONE;
				return true;
			} else if (sum == -SIZE) {
				this.winner = Player.TWO;
				return true;
			}
		}
		return false;
	}

	/**
	 * Returns 1 if player X holds the given row and column, -1 for player O, 0
	 * otherwise.
	 * 
	 * @param row
	 * @param column
	 * @return an integer representation of who holds the cell
	 */
	private int tokenAsInt(int row, int column) {
		switch (this.tokens[row][column]) {
		case ONE:
			return 1;
		case TWO:
			return -1;
		default:
			return 0;
		}
	}

	@Override
	public boolean isValidMove(int x, int y, Dimension d) {
		// Converts x and y into row and column
		double cellWidth = d.getWidth() / SIZE;
		double cellHeight = d.getHeight() / SIZE;
		int row = (int) Math.floor(y / cellHeight);
		int col = (int) Math.floor(x / cellWidth);

		return !isGameOver() && this.tokens[row][col] == Player.NEITHER;
	}

	@Override
	public String getPlayerPrompt() {
		if (this.isGameOver()) {
			return "Game over, dude";
		}
		switch (this.turn) {
		case ONE:
			return "X's turn";
		case TWO:
			return "O's turn";
		default:
			return "I'm so confused";
		}
	}

	@Override
	public String getTitle() {
		return "Tic Tac Toe";
	}

}
