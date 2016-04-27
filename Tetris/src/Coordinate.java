
/**
 * TODO Put here a description of what this class does.
 *
 * @author Pengdi.
 *         Created Mar 4, 2014.
 */
public class Coordinate {
	private int pixelMulti = 30;
	private int leftBorder = 60;
	private int upBorder = 60;
	private int x;
	private int y;
	
	public Coordinate(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public int getX(){
		return this.x;
	}
	
	public int getY(){
		return this.y;
	}
	
	public void moveDown(){
		this.y  = this.y + 1;
	}
	
	public int getMulti(){
		return this.pixelMulti;
	}
	
	public void resetPixelMulti(int newMulti){
		this.pixelMulti = newMulti;
	}
	
	public void resetBorder(int left, int up){
		this.leftBorder = left;
		this.upBorder = up;
	}
	
	public Coordinate convertToReal(){
		Coordinate real = new Coordinate(this.x*pixelMulti + leftBorder, this.y*pixelMulti+upBorder);
		return real;
		
	}
}
