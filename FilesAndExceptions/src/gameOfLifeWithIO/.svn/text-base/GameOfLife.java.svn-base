package gameOfLifeWithIO;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.Timer;

/**
 * This class represents the game board. It can draw a graphical rendering of
 * its current state and can calculate its next state.
 * 
 * @author Curt Clifton.
 */
class GameOfLife extends JComponent {
	private static final int MAX_ROWS = 90;
	private static final int MAX_COLUMNS = 90;
	private static final double DOT_SIZE = 7;
	private static final int AUTO_CLICK_INTERVAL = 50;

	private boolean[][] occupiedCell;
	private Timer updateTimer;

	/**
	 * Constructs a new game board from the list of initially occupied
	 * coordinates.
	 * 
	 * @param initialCells
	 */
	GameOfLife(ArrayList<Coordinates> initialCells) {
		this.setFilledSquares(initialCells);

		/*
		 * This code creates a Timer object that periodically "clicks" the
		 * update button. See Big Java, ch. 9.9 for discussion.
		 */
		final GameOfLife game = this;
		ActionListener updater = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.nextGeneration();
				game.repaint();
			}
		};
		this.updateTimer = new Timer(AUTO_CLICK_INTERVAL, updater);

		MouseListener mouseHandler = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = (int) (e.getY() / DOT_SIZE);
				int col = (int) (e.getX() / DOT_SIZE);
				game.toggleCell(row, col);
			}
		};
		this.addMouseListener(mouseHandler);
	}

	/**
	 * Returns whether the given cell is occupied. Treats out-of-bounds accesses
	 * as "wrapping" around to the other side of the board. Method is
	 * synchronized so that the test must complete before the board state is
	 * changed by other threads.
	 * 
	 * @param row
	 *            can be negative but must be > -MAX_ROWS
	 * @param column
	 *            can be negative but must be > -MAX_COLUMNS
	 * @return whether or not the square in the given row and column is occupied
	 */
	synchronized boolean isOccupied(int row, int column) {
		int actualRow = (row + MAX_ROWS) % MAX_ROWS;
		int actualColumn = (column + MAX_COLUMNS) % MAX_COLUMNS;
		return this.occupiedCell[actualRow][actualColumn];
	}

	/**
	 * Counts the number of occupied cells around the given square. Method is
	 * synchronized so that the count must complete before the board state is
	 * changed by other threads.
	 * 
	 * @param row
	 * @param column
	 * @return the number of occupied cells
	 */
	synchronized int getNeighborCount(int row, int column) {
		int minR = row - 1;
		int maxR = row + 1;
		int minC = column - 1;
		int maxC = column + 1;

		// Counts all the cells in the neighborhood
		int count = 0;
		for (int r = minR; r <= maxR; r++) {
			for (int c = minC; c <= maxC; c++) {
				count += isOccupied(r, c) ? 1 : 0;
			}
		}
		// Removes the central cell since it doesn't count
		count -= isOccupied(row, column) ? 1 : 0;

		return count;
	}

	/**
	 * Updates the state of this game board for the next generation. Method is
	 * synchronized so that updates to the game board must complete before the
	 * board state is changed by other threads.
	 */
	synchronized void nextGeneration() {
		boolean[][] next = new boolean[MAX_ROWS][MAX_COLUMNS];
		for (int r = 0; r < MAX_ROWS; r++) {
			for (int c = 0; c < MAX_COLUMNS; c++) {
				int count = this.getNeighborCount(r, c);
				if (isOccupied(r, c) && count > 1 && count < 4) {
					// lives on
					next[r][c] = true;
				}
				if (!isOccupied(r, c) && count == 3) {
					// it's a girl!
					next[r][c] = true;
				}
				// otherwise leave the next generation square unoccupied
			}
		}
		this.occupiedCell = next;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;
		Ellipse2D.Double cell = new Ellipse2D.Double(0, 0, DOT_SIZE, DOT_SIZE);
		for (int r = 0; r < MAX_ROWS; r++) {
			for (int c = 0; c < MAX_COLUMNS; c++) {
				if (isOccupied(r, c)) {
					cell.y = DOT_SIZE * r;
					cell.x = DOT_SIZE * c;
					g2.fill(cell);
				}
			}
		}

	}

	/**
	 * Toggles the occupied state of the cell at the given row and column
	 * coordinates. Synchronized so calls from GUI thread don't collide with
	 * calls from animation thread.
	 * 
	 * @param row
	 * @param col
	 */
	private synchronized void toggleCell(int row, int col) {
		this.occupiedCell[row][col] = !this.occupiedCell[row][col];
		this.repaint();
	}

	/**
	 * Returns a list of the occupied coordinates. Method is synchronized so
	 * animation thread cannot mutate the game state while this method is
	 * constructing the list.
	 * 
	 * @return a list of the occupied coordinates
	 */
	synchronized ArrayList<Coordinates> getFilledSquares() {
		ArrayList<Coordinates> result = new ArrayList<Coordinates>();
		for (int r = 0; r < MAX_ROWS; r++) {
			for (int c = 0; c < MAX_COLUMNS; c++) {
				if (isOccupied(r, c)) {
					result.add(new Coordinates(r, c));
				}
			}
		}
		return result;
	}

	/**
	 * Sets the occupied coordinates of this game. Method is synchronized so
	 * animation thread cannot mutate the game state while this method is
	 * filling the board.
	 * 
	 * @param coordinates
	 */
	synchronized void setFilledSquares(ArrayList<Coordinates> coordinates) {
		this.occupiedCell = new boolean[MAX_ROWS][MAX_COLUMNS];
		for (Coordinates coord : coordinates) {
			this.occupiedCell[coord.getRow()][coord.getColumn()] = true;
		}
		this.repaint();
	}

	/**
	 * Begins or resumes animation of this game.
	 */
	void animate() {
		this.updateTimer.start();
	}

	/**
	 * Pauses animation of this game.
	 * 
	 */
	void pause() {
		this.updateTimer.stop();
	}
}
