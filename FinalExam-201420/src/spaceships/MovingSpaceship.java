package spaceships;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 * 
 * When a MovingSpaceship is told to move, it should not
 * change it's x and y to the target position immediately.  
 * Instead it should slowly adjust its x and y towards the 
 * target position.  That way the ship appears to animate.
 * 
 * Feel free to modify anything you wish about this class.
 * Add fields, modify any of the functions, add your own
 * functions, etc.
 * 
 * @author TODO <YOUR_NAME_GOES_HERE>
 *
 */
public class MovingSpaceship {

	private static final int WIDTH=60;
	private static final int HEIGHT=60;
	
	private int x, y;
	
	
	/**
	 * Constructs a MovingSpaceship at the specified location.
	 *
	 * @param startingX
	 * @param startingY
	 */
	public MovingSpaceship(int startingX, int startingY) {
		this.x = startingX;
		this.y = startingY;
	}
	
	/**
	 * Called to draw the spaceship.
	 */
	public void drawOn(Graphics2D g) {

		g.setColor(Color.ORANGE);
		g.fillOval(this.x - WIDTH/2, this.y - WIDTH/2, WIDTH, HEIGHT);
	}
	
	/**
	 * Should be called when a new destination is set for
	 * the moving spaceship.
	 */
	public void moveTo(int newX, int newY) {
		MoveRunnable move = new MoveRunnable(this, newX, newY);
		Thread t = new Thread(move);
		t.start();
	}
	
	public void reset(int x, int y){
		this.x = this.x + x;
		this.y = this.y + y;
	}
	
	public int getX(){
		return this.x;
	}
	
	public int getY(){
		return this.y;
	}
	
}
