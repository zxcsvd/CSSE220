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
public class Ladder implements Drawable{
	/**
	 * TODO Put here a description of what this constructor does.
	 *
	 * @param newPoint
	 */
	private Coordinate position;
	public Ladder(Coordinate position) {
		this.position = position;
	}
	@Override
	public void drawOn(Graphics g, int multiplier) {
		Graphics2D g2 = (Graphics2D) g;
		for (int i=0;i<multiplier;i+=3){
			int width = this.position.getX()*multiplier;
			int height = this.position.getY()*multiplier+i;
			g.setColor(Color.WHITE);
			Rectangle square = new Rectangle(width, height, 4*multiplier, 1);
			g2.fill(square);
		}
	}
	@Override
	public Coordinate getCoordinate() {
		// TODO Auto-generated method stub.
		return this.position;
	}

	

}
