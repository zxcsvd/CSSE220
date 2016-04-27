/**
 * 
 */
package burgertime;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 * TODO Put here a description of what this class does.
 *
 * @author wangx3.
 *         Created Feb 2, 2014.
 */
public class Floor implements Drawable {
	private Coordinate position;

	
	public Floor(Coordinate position){
		this.position = position;
	}
	
	@Override
	public void drawOn(Graphics g, int multiplier) {
		Graphics2D g2 = (Graphics2D) g;
		int width = this.position.getX()*multiplier;
		int height = this.position.getY()*multiplier;
		g.setColor(Color.GRAY);
		Rectangle square = new Rectangle(width, height, multiplier, multiplier);
		g2.fill(square);
	}

	@Override
	public Coordinate getCoordinate() {
		// TODO Auto-generated method stub.
		return this.position;
	}

}
