import java.awt.Color;
import java.awt.Graphics;


/**
 * TODO Put here a description of what this class does.
 *
 * @author Pengdi.
 *         Created Mar 4, 2014.
 */
public class TetrisShape implements Drawable{
	private Coordinate spinCoordinate; 
	private int spinX;
	private int spinY;
	private Square s1;
	private Square s2;
	private Square s3;
	private Square s4;
	private Color color;
	
	public TetrisShape(Coordinate coordinate, Color color){
		this.spinCoordinate = coordinate;
		this.spinX = this.spinCoordinate.getX();
		this.spinY = this.spinCoordinate.getY();
		this.color = color;
	}
	
	public void spin(Square s){
		int deltaX = s.getCoord().getX()-this.spinX;
		int deltaY = s.getCoord().getY()-this.spinY;
		int temp = deltaX;
		deltaX = -deltaY;
		deltaY = temp;
	}
	public void createShape(){
		
	}
	public void spinAll(){
		spin(this.s1);
		spin(this.s3);
		spin(this.s2);
		spin(this.s4);
	}
	@Override
	public void DrawOn(Graphics g) {
		// TODO Auto-generated method stub.
		
	}
}
