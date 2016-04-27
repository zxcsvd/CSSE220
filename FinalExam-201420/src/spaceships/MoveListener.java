package spaceships;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

/**
 * TODO Put here a description of what this class does.
 *
 * @author Pengdi.
 *         Created Feb 27, 2014.
 */

public class MoveListener implements MouseListener{
	private SpaceshipComponent ship;
//	private JFrame f;
	
	/**
	 * TODO Put here a description of what this constructor does.
	 *
	 * @param ship
	 */
	public MoveListener(SpaceshipComponent ship){
		this.ship = ship;
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		this.ship.getTeleporter().moveTo(e.getX(), e.getY());
		this.ship.getMover().moveTo(e.getX(), e.getY());
		this.ship.repaint();
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub.
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub.
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub.
		
	}
}
