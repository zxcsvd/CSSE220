
package burgertime;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

/**
 * TODO Put here a description of what this class does.
 *
 * @author wangx3.
 *         Created Feb 2, 2014.
 */
public class Hero implements Movable{
	private Coordinate startPosition;
	private Coordinate currentPosition;
	private boolean move;
	private int life;
	private boolean isProtected;
	private int numOfPeppers;
	private boolean visible;
	

	
	public Hero(Coordinate startPosition){
		this.startPosition = startPosition;
		this.currentPosition = new Coordinate(this.startPosition.getX(),this.startPosition.getY());
		this.move = true;
		this.life = 5;
		this.isProtected = false;
		this.numOfPeppers = 3;
		this.visible = true;
	}
	
	public void putPepper(){
		this.isProtected = true;
		this.numOfPeppers--;
	}
	
	public void addPepper(){
		this.numOfPeppers++;
	}
	
	public void deletePepper(){
		this.isProtected = false;
	}
	
	public boolean getProtectedStatus(){
		return this.isProtected;  
	}
	
	public int getNumOfPepper(){
		return this.numOfPeppers;
	}
	
	public void reBirth(){
		this.move=true;
		this.visible=true;
	}
	
	public void die(){
		this.life = this.life -1;
		this.visible =false;
		this.move=false;
		this.currentPosition = new Coordinate(this.startPosition.getX(),this.startPosition.getY());
	}


	@Override
	public boolean stop() {
		this.move = false;
		return this.move;
	}

	@Override
	public boolean continueGame() {
		this.move = true;
		return this.move;
	}

	@Override
	public void drawOn(Graphics g, int multiplier) {
		if(this.visible){
		Graphics2D g2 = (Graphics2D) g;
		int recX = (this.currentPosition.getX())*multiplier;
		int recY = (this.currentPosition.getY()-7)*multiplier;
		g.setColor(Color.BLUE);
		Rectangle square = new Rectangle(recX, recY, 4*multiplier, 8*multiplier);
		g2.fill(square);
		}
	}

	@Override
	public Coordinate getCoordinate() {
		return this.currentPosition;
	}
	
	public int getLives(){
		return this.life;
	}

	@Override
	public Coordinate move(int x, int y) {
		int xCurrent = this.currentPosition.getX() + x;
		int yCurrent = this.currentPosition.getY() + y;
		this.currentPosition.reSet(xCurrent, yCurrent);
		return this.currentPosition;
	}
	
	public boolean getPause(){
		return this.move;
	}
	
	public boolean checkLeftFloor(ArrayList<Floor> floors){
		for(int i=0; i<floors.size(); i++){
			if(this.currentPosition.getY()+1==floors.get(i).getCoordinate().getY()){
				if(this.currentPosition.getX()-1==floors.get(i).getCoordinate().getX()){
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean checkRightFloor(ArrayList<Floor> floors){
		for(int i=0; i<floors.size(); i++){
			if(this.currentPosition.getY()+1==floors.get(i).getCoordinate().getY()){
				if(this.currentPosition.getX()+1==floors.get(i).getCoordinate().getX()){
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean checkUpLadder(ArrayList<Ladder> ladders){
		for(int i=0; i<ladders.size(); i++){
			if(this.currentPosition.getY()==ladders.get(i).getCoordinate().getY()){
				if(this.currentPosition.getX()==ladders.get(i).getCoordinate().getX()
				  ||this.currentPosition.getX()-1==ladders.get(i).getCoordinate().getX()){
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean checkDownLadder(ArrayList<Ladder> ladders){
		for(int i=0; i<ladders.size(); i++){
			if(this.currentPosition.getY()+1==ladders.get(i).getCoordinate().getY()){
				if(this.currentPosition.getX()==ladders.get(i).getCoordinate().getX()
				  ||this.currentPosition.getX()-1==ladders.get(i).getCoordinate().getX()){
					return true;
				}
			}
		}
		return false;
	}

}