import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JComponent;

/**
 * 
 * A general Java Swing component to specify cardinal directions (e.g. North, South, East, West)
 * 
 * This code already handles figuring out which direction you clicked.  You should interact with it
 * using addCompassEventListener, similar to the way you use addActionListener in JButton.
 * 
 * IF YOU WANT MOST OF THE CREDIT ON THE EXAM2 QUESTION, DO NOT MODIFY THIS CLASS IN ANY WAY.
 * 
 * @author Michael Hewner
 *
 */
public class CompassComponent extends JComponent implements MouseListener {

	Rectangle north, south, east, west;
	ArrayList<CompassEventListener> eventListeners;
	
	public CompassComponent()
	{
		this.addMouseListener(this);
		eventListeners = new ArrayList<CompassEventListener>();
	}
	
	public void addCompassEventListener(CompassEventListener newListener)
	{
		eventListeners.add(newListener);
	}
	
	public void removeCompassEventListener(CompassEventListener listenerToRemove)
	{
		eventListeners.remove(listenerToRemove);
	}
	
	@Override
	protected void paintComponent(Graphics g) {

		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;
		
		int buttonWidth = this.getWidth()/3;
		int buttonHeight = this.getHeight()/3;
		
		west = new Rectangle(0,buttonHeight,buttonWidth,buttonHeight);
		south = new Rectangle(buttonWidth,2*buttonHeight,buttonWidth, buttonHeight);
		north = new Rectangle(buttonWidth,0,buttonWidth,buttonHeight);
		east = new Rectangle(2*buttonWidth,buttonHeight,buttonWidth,buttonHeight);
		
		g2.setColor(Color.GREEN);
		g2.fill(west);

		
		g2.setColor(Color.RED);
		g2.fill(east);
		
		g2.setColor(Color.CYAN);
		g2.fill(north);
		
		g2.setColor(Color.ORANGE);
		g2.fill(south);

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(north.contains(e.getPoint())) {
			for(CompassEventListener l : this.eventListeners) {
				l.northClicked(e);
			}
		}
		if(south.contains(e.getPoint())) {
			for(CompassEventListener l : this.eventListeners) {
				l.southClicked(e);
			}
		}
		if(east.contains(e.getPoint())) {
			for(CompassEventListener l : this.eventListeners) {
				l.eastClicked(e);
			}
		}
		if(west.contains(e.getPoint())) {
			for(CompassEventListener l : this.eventListeners) {
				l.westClicked(e);
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}
	
}
