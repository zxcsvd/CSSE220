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
public class IShape extends TetrisShape{
	private Coordinate spinCoordinate; 
	private int spinX;
	private int spinY;
	private Square s1;
	private Square s2;
	private Square s3;
	private Square s4;
	private Color color;
	
	public IShape(Coordinate coordinate){
		super(coordinate, Color.green);
	}

	public void spin(Square s) {
		int deltaX = s.getCoord().getX()-this.spinX;
		int deltaY = s.getCoord().getY()-this.spinY;
		int temp = deltaX;
		deltaX = -deltaY;
		deltaY = temp;
	}
	
	public void spinAll(){
		spin(this.s1);
		spin(this.s3);
		spin(this.s2);
		spin(this.s4);
	}

	@Override
	public void createShape() {
		this.s1 = new Square(this.spinX, this.spinY-1);
		this.s2 = new Square(this.spinX, this.spinY);
		this.s3 = new Square(this.spinX, this.spinY+1);
		this.s4 = new Square(this.spinX, this.spinY+2);
		
		
		// TODO Auto-generated method stub.
		
	}


	public void DrawOn(Graphics g) {
		this.s1.draw(g);
		this.s2.draw(g);
		this.s3.draw(g);
		this.s4.draw(g);
		
	}


	
}
