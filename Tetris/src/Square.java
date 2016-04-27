import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;


/**
 * TODO Put here a description of what this class does.
 *
 * @author Pengdi.
 *         Created Mar 4, 2014.
 */
public class Square {
	private Coordinate coordinate;
	private Color color;
	
	public Square(int x, int y){
		this.coordinate = new Coordinate(x, y);
		
	}
	
	public void setColor(Color color){
		this.color = color;
	}
	
	public Coordinate getCoord(){
		return this.coordinate;
	}
	
	public void resetCoord(int x, int y){
		Coordinate newCoord = new Coordinate(x, y);
		this.coordinate = newCoord;
	}

	/**
	 * TODO Put here a description of what this method does.
	 *
	 * @param g
	 */
	public void draw(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g.setColor(this.color);
		Coordinate realCoord = this.coordinate.convertToReal();
		Rectangle square = new Rectangle(realCoord.getX(), realCoord.getY(), realCoord.getMulti(), realCoord.getMulti());
		g2.fill(square);	
		g2.setColor(Color.white);
		g2.draw(square);
		
	}

}
