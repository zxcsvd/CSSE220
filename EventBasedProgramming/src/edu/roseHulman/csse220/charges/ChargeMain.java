package edu.roseHulman.csse220.charges;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Starts the Charges application.
 * 
 * @author Curt Clifton. Created Oct 3, 2008.
 */
public class ChargeMain {

	private static final int HEIGHT = 600;
	private static final int WIDTH = 900;

	/**
	 * Starts the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(WIDTH, HEIGHT);
		frame.setTitle("Charge!");

		// TODO: space probably needs to be final, why?
		final Space space = new Space();
		addCharges(space);

		
		frame.add(space, BorderLayout.CENTER);
		JPanel panel = new JPanel();
		// TODO: add Zoom In and Zoom Out buttons to the GUI.
		JButton zoomIn = new JButton("Zoom In");
		panel.add(zoomIn);
		
		
		class ClickOnWindow implements MouseListener{

			@Override
			public void mouseClicked(MouseEvent arg0) {
				double spaceX = space.convertToSpace(arg0.getX());
				double spaceY = space.convertToSpace(arg0.getY());		
				Charge newCharge = new PointCharge(spaceX, spaceY, -1);
				space.addCharge(newCharge);
				space.repaint();
				
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub.
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub.
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub.
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub.
				
			}
			
		}
		space.addMouseListener(new ClickOnWindow());
		class ZoomInButton implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("You tried to zoom in");
				space.zoomIn();
				// TODO Auto-generated method stub.
				
			}
			
		}
		zoomIn.addActionListener(new ZoomInButton());
		class ZoomOutButton implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("You tried to zoom out");
				space.zoomOut();
				// TODO Auto-generated method stub.
				
			}
			
		}
		
		
		JButton zoomOut = new JButton("Zoom Out");
		panel.add(zoomOut);
	
		zoomOut.addActionListener(new ZoomOutButton());
		frame.add(panel, BorderLayout.SOUTH);
		
		
		// TODO: set up action listeners for zoom in and zoom out buttons

		/* TODO: Add mouse listener to allow drawing on the space.  Use 
		 * the SpaceClickHandler class to implement the MouseListener. 
		 */

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	// TODO: create and use an external class to handle mouse events

	/**
	 * Adds charges to the given space for simulation purposes.
	 * 
	 * @param space
	 *            the charge space to simulate (mutated)
	 */
	private static void addCharges(Space space) {
		space.addCharge(new PointCharge(10, 10, 3.0));
		space.addCharge(new PointCharge(20, 10, -3.0));

		space.addCharge(new LinearCharge(0, 5, 30, 5, 10.0));
		space.addCharge(new LinearCharge(0, 15, 30, 15, -10.0));
	}

}
