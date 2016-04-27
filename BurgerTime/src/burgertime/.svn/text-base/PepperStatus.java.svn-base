/**
 * 
 */
package burgertime;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

/**
 * TODO Put here a description of what this class does.
 *
 * @author wangx3.
 *         Created Feb 16, 2014.
 */
public class PepperStatus implements Drawable{
	
	private Hero hero;
	
	public PepperStatus(Hero hero){
		this.hero = hero;
	}
	@Override
	public void drawOn(Graphics g, int multiplier) {
		Graphics2D g2 = (Graphics2D) g;
		int circleX = (this.hero.getCoordinate().getX()-2)*multiplier;
		int circleY = (this.hero.getCoordinate().getY()-7)*multiplier;
		
		g.setColor(Color.MAGENTA);
		
		Ellipse2D.Double pepper = new Ellipse2D.Double(circleX, circleY, 8*multiplier, 8*multiplier);
		g2.draw(pepper);
		
	}

	@Override
	public Coordinate getCoordinate() {
		return this.hero.getCoordinate();
	}
	

}

