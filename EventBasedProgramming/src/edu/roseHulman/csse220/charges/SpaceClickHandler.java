package edu.roseHulman.csse220.charges;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * This class handles mouse events for a space with charges
 * 
 * @author Delvin Defoe and Curt Clifton. Created April 12, 2011
 * 
 */
public class SpaceClickHandler implements MouseListener {

	// TODO: add fields to this state as needed

	/**
	 * Constructs a SpaceClickHandler for the given space
	 * @param space 
	 */
	public SpaceClickHandler(Space space) {
		// TODO: implement constructor
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO: implement mouseClicked to add point charge.
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// ignored
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// ignored
	}

	@Override
	public void mousePressed(MouseEvent e) {
		System.out.printf("Pressed: (%3d, %3d)%n", e.getX(), e.getY());
		// TODO: add state for tracking down event
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		System.out.printf("Released: (%3d, %3d)%n", e.getX(), e.getY());
		// TODO: handle release and do the right thing

		// single click is handled by mouseClicked, so only deal with
		// click and drag here.  Add linear charge here.

	}

}
