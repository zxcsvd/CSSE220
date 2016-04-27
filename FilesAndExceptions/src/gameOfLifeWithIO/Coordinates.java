package gameOfLifeWithIO;

/**
 * This class represents a pair of coordinates.
 * 
 * @author Curt Clifton. Created Sep 24, 2008.
 */
class Coordinates {
	private int row;
	private int column;

	/**
	 * Constructs a coordinate pair.
	 * 
	 * @param row
	 * @param column
	 */
	public Coordinates(int row, int column) {
		this.row = row;
		this.column = column;
	}

	/**
	 * @return the row of this pair
	 */
	public int getRow() {
		return this.row;
	}

	/**
	 * @return the column of this pair
	 */
	public int getColumn() {
		return this.column;
	}

}
