package spaceships;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;

/**
 * Creates the spaceship objects and invokes their
 * drawing functions from paintComponent.
 * 
 * You may modify this class in any way you wish.
 * 
 * @author TODO <YOUR_NAME_GOES_HERE>
 *
 */
public class SpaceshipComponent extends JComponent {

	private TeleportySpaceship teleporter;
	private MovingSpaceship mover;
	
	// in Stage 3 the above variables will be removed and
	// replaced with something like this
	// private ArrayList<????????> spaceships;
	
	/**
	 * Default constructor for SpaceshipComponent.
	 *
	 */
	public SpaceshipComponent() {
		this.teleporter = new TeleportySpaceship(300,300);
		this.mover = new MovingSpaceship(500,500);		
		
		
	}
	
	public TeleportySpaceship getTeleporter(){
		return this.teleporter;
	}
	
	public MovingSpaceship getMover(){
		return this.mover;
	}
	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	protected void paintComponent(Graphics arg0) {
		super.paintComponent(arg0);
		Graphics2D g = (Graphics2D) arg0;
		
		teleporter.drawOn(g);
		mover.drawOn(g);
		
	}


	
}
