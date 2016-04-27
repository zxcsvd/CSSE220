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
public class Enemy implements Movable{
	private Coordinate startPosition;
	private Coordinate currentPosition;
	private Coordinate previousPosition;
	private int timeInterval;
	private boolean move;
	private int index;
	private boolean visible;
	private String facing;
	
	public Enemy(Coordinate startPosition, int index){
		this.startPosition = startPosition;
		this.currentPosition = new Coordinate(startPosition.getX(),startPosition.getY());
		this.previousPosition = new Coordinate(startPosition.getX(),startPosition.getY());
		this.move = true;
		this.index = index;
		this.visible = true;
		this.facing = "Right";

	}
	
	public int getIndex(){
		return this.index;
	}
	
	public boolean stop() {
		this.move=false;
		return this.move;
	}

	@Override
	public boolean continueGame() {
		this.move=true;
		return this.move;
	}


	@Override
	public void drawOn(Graphics g, int multiplier) {
		Graphics2D g2 = (Graphics2D) g;
		int recX = (this.currentPosition.getX())*multiplier;
		int recY = (this.currentPosition.getY()-7)*multiplier;
		
		g.setColor(Color.RED);
		Rectangle square = new Rectangle(recX, recY, 4*multiplier, 8*multiplier);
		g2.fill(square);
		
	}

	@Override
	public Coordinate getCoordinate() {
		return this.currentPosition;
	}

	/**
	 * TODO Put here a description of what this method does.
	 *
	 */
	
	public void die(){
		
		this.move = false;
		this.visible = false;
		this.currentPosition = new Coordinate(this.startPosition.getX(),this.startPosition.getY());
	}
	
	public void reBirth() {
		this.visible = true;
		this.move = true;
		this.setFacing("Right");
	}

	@Override
	public Coordinate move(int x, int y) {
		if(this.move){
			this.previousPosition = new Coordinate(this.currentPosition.getX(),this.currentPosition.getY());
			int xCurrent = this.currentPosition.getX() + x;
			int yCurrent = this.currentPosition.getY() + y;
			this.currentPosition.reSet(xCurrent, yCurrent);
			return this.previousPosition;
		}
		return currentPosition;

	}
	public boolean getPause(){
		return this.move;
	}
	
	
	//move continuously
	
	public boolean checkOnTheFloor(ArrayList<Floor> floors){
		for(int i=0; i<floors.size(); i++){
			if(this.currentPosition.getX()==floors.get(i).getCoordinate().getX()&&
			   this.currentPosition.getY()+1==floors.get(i).getCoordinate().getY()){
				return true;
			}
		}
		return false;
	}
	
	public boolean checkOnTheLadder(ArrayList<Ladder> ladders){
		for(int i=0; i<ladders.size(); i++){
			if(this.currentPosition.getX()-1==ladders.get(i).getCoordinate().getX()&&
			   this.currentPosition.getY()+1==ladders.get(i).getCoordinate().getY()){
				return true;
			}
			if(this.currentPosition.getX()==ladders.get(i).getCoordinate().getX()&&
					   this.currentPosition.getY()+1==ladders.get(i).getCoordinate().getY()){
						return true;
					}
		}
		return false;
	}
	
	public boolean previousUp(){
		if(this.previousPosition.getX()==this.currentPosition.getX()&&
			this.previousPosition.getY()>=this.currentPosition.getY()){
			return true;
		}
		return false;
	}
	
	public boolean previousDown(){
		if(this.previousPosition.getX()==this.currentPosition.getX()&&
			this.previousPosition.getY()<this.currentPosition.getY()){
			return true;
		}
		return false;
	}
	
	public boolean previousLeft(){
		if(this.previousPosition.getY()==this.currentPosition.getY()&&
			this.previousPosition.getX()>=this.currentPosition.getX()){
			return true;
		}
		return false;
	}
	
	public boolean previousRight(){
		if(this.previousPosition.getY()==this.currentPosition.getY()&&
			this.previousPosition.getX()<this.currentPosition.getX()){
			return true;
		}
		return false;
	}
	
	public boolean leftMovable(ArrayList<Floor> floors, ArrayList<Ladder> ladders){
		for(int i=0; i<floors.size(); i++){
			if(floors.get(i).getCoordinate().getX()+1==this.currentPosition.getX()&&
				floors.get(i).getCoordinate().getY()-1==this.currentPosition.getY()){
				return true;
			}
		}
		for(int j=0; j<ladders.size(); j++){
			if(ladders.get(j).getCoordinate().getY()-1==this.currentPosition.getY()&&
				ladders.get(j).getCoordinate().getX()+5==this.currentPosition.getX()){
				return true;
			}
		}
		return false;
	}
	
	public boolean rightMovable(ArrayList<Floor> floors, ArrayList<Ladder> ladders){
		for(int i=0; i<floors.size(); i++){
			if(floors.get(i).getCoordinate().getX()-4==this.currentPosition.getX()&&
				floors.get(i).getCoordinate().getY()-1==this.currentPosition.getY()){
				return true;
			}
		}
		for(int j=0; j<ladders.size(); j++){
			if(ladders.get(j).getCoordinate().getY()-1==this.currentPosition.getY()&&
				ladders.get(j).getCoordinate().getX()-1==this.currentPosition.getX()){
				return true;
			}
			if(ladders.get(j).getCoordinate().getX()==this.currentPosition.getX()&&
				ladders.get(j).getCoordinate().getY()-1==this.currentPosition.getY()){
				return true;
			}
		}
		return false;
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

	public void setFacing(String direction){
		this.facing = direction;
	}
	
	public String getFacing(){
		return this.facing;
	}



}
