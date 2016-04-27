/**
 * 
 */
package burgertime;

/**
 * TODO Put here a description of what this class does.
 *
 * @author wangx3.
 *         Created Feb 2, 2014.
 */
public class Coordinate {
	private int x;
	private int y;
	
	public Coordinate(int x, int y){
		this.x=x;
		this.y=y;
	}
	
	public int getX(){
		return this.x;
	}
	
	public int getY(){
		return this.y;
	}
	
	public void reSet(int x, int y){
		this.x=x;
		this.y=y;
	}

}
