import java.awt.Graphics; 
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

import javax.swing.JComponent;

/**
 * This class represents the game board. It can draw a graphical rendering of
 * its current state and can calculate its next state.
 * 
 * @author Logan Erexson and Bo Peng. Created Sep 24, 2008.
 */
public class GameOfLife extends JComponent {
	private static final int MAX_ROWS = 90;
	private static final int MAX_COLUMNS = 90;
	private static final double DOT_SIZE = 7;
	private ArrayList<Coordinates> livingCells;
	/*
	 * TODO 1: Decide how you'll represent the state of the game board. That is, what field(s)
	 * do you need?
	 * livingCells is the only field that we need. It contains the list of living.
	 */

	/**
	 * Constructs a new game board from the list of initially occupied
	 * coordinates.
	 * 
	 * @param initialCells
	 */
	public GameOfLife(ArrayList<Coordinates> initialCells) {
		/*
		 * TODO 2: Document, test, and implement this constructor that takes an
		 * ArrayList<Coordinates> specifying all the initially occupied squares
		 * on the game board. The Coordinates class is provided. NOTE: You will
		 * probably need a "smart" constructor.  Instead of just storing
		 * initialCells, you'll need to convert to whatever representation you
		 * chose in the previous to-do item.
		 * 
		 * Set livingCells to the initials 
		 */
		this.livingCells=initialCells;
	}

	/**
	 * @param row
	 * @param column
	 * @return whether or not the square in the given row and column is occupied
	 */
	public boolean isOccupied(int row, int column) {
		/*
		 * TODO 4: Document, test, and implement this method that detects whether
		 * a particular square is occupied.
		 * 
		 * To check whether the cell is living or not.
		 */
		for (Coordinates temp: this.livingCells){
			if(temp.getColumn() == column && temp.getRow() == row){
				return true;
			}
		}
		return false;
	}

	/**
	 * Counts the number of occupied cells around the given square.
	 * 
	 * @param row
	 * @param column
	 * @return the number of occupied cells
	 */
	public int getNeighborCount(int row, int column) {
		/*
		 * DONE 5: Document, test, and implement this method that takes a row and
		 * column and returns the number of occupied neighbor squares.
		 * 
		 * return the number of living cells around this row and column.
		 */
		int count = 0;
		for(int i = 0; i< 3; i++){
			for(int j=0; j<3; j++){
				if(this.isOccupied(row-1+i , column-1+j)){
					count++;
				}
			}
		}
		if(this.isOccupied(row, column)){
			count--;
		}
		return count;
	}

	/**
	 * Updates the state of this game board for the next generation.
	 */
	public void nextGeneration() {
		/*
		 * DONE 6: Document, test, and implement this method that calculates the
		 * occupied squares for the next generation of this game. See p. 332 of
		 * Big Java, or the class slides for the rules. You'll need to use
		 * temporary storage to hold the next generation information as you
		 * calculate it.
		 * 
		 * Change the cells of living according to the rule of game of life. 
		 */
		ArrayList <Coordinates> newLiving = new ArrayList<Coordinates>();
		
		for(int i=0; i<MAX_ROWS; i++){
			
			for(int j=0; j<MAX_COLUMNS; j++){
				if(this.getNeighborCount(i, j) == 3){
					Coordinates temp = new Coordinates(i, j);
					newLiving.add(temp);
				}
				else{
					if (this.isOccupied(i,j) && this.getNeighborCount(i, j)==2){
						Coordinates temp = new Coordinates(i, j);
						newLiving.add(temp);
						
					}
				}
			}
		}
		this.livingCells = newLiving;
	}

	@Override
	protected void paintComponent(Graphics g) {
		// Draws the living cells on the graphics window.
		super.paintComponent(g);
		Graphics2D graphics2 = (Graphics2D) g;
		for(int i = 0; i<MAX_ROWS ; i++){
			for(int j= 0; j<MAX_COLUMNS; j++){
			
				if (this.isOccupied(i, j)){
					Ellipse2D.Double living = new Ellipse2D.Double(i* DOT_SIZE, j*DOT_SIZE, DOT_SIZE, DOT_SIZE);
					graphics2.fill(living);
				}
			}
		}
		/*
		 * DONE 3: Implement this method to draw the game board.  You don't have to 
		 * draw the grid if you don't want, just the occupied cells.
		 */	
	}

}
