/**
 * 
 */
package burgertime;

import java.util.ArrayList;

/**
 * TODO Put here a description of what this class does.
 *
 * @author wangx3. 
 *         Created Feb 2, 2014.
 */
public interface Movable extends Drawable{
	Coordinate move(int x, int y);
	boolean stop();
	boolean continueGame();
	boolean getPause();
	/**
	 * TODO Put here a description of what this method does.
	 *
	 * @param ladders
	 * @return
	 */
	boolean checkDownLadder(ArrayList<Ladder> ladders);
	/**
	 * TODO Put here a description of what this method does.
	 *
	 * @param floors
	 * @return
	 */
	boolean checkLeftFloor(ArrayList<Floor> floors);
	/**
	 * TODO Put here a description of what this method does.
	 *
	 * @param ladders
	 * @return
	 */
	boolean checkUpLadder(ArrayList<Ladder> ladders);
	/**
	 * TODO Put here a description of what this method does.
	 *
	 * @param floors
	 * @return
	 */
	boolean checkRightFloor(ArrayList<Floor> floors);


}
