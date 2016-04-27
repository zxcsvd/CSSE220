/**
 * 
 */
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
public class Burger implements Movable{
	private Coordinate startPosition;
	private Coordinate currentPosition;
	public boolean isStepped = false;
	private boolean isOnThePlate = false;
	private int column;
	private int row;
	private boolean isFalling = false;
	public boolean move;
	
	public Burger(Coordinate startPosition, int row, int column){
		this.move = false;
		this.currentPosition = startPosition;
		this.startPosition = startPosition;
		this.column = column;
		this.row = row;
	}
	
	public boolean isOnThePlate(){
		return this.isOnThePlate;
	}
	
	public void stepped(){
		int x = this.currentPosition.getX();
		int y = this.currentPosition.getY();
		this.currentPosition.reSet(x,y);
		this.isStepped = true;
		this.move(0, 1);
	}
	
	public boolean getIsFalling(){
		return this.isFalling;
	}
	
	public void setIsFalling(boolean t){
		this.isFalling = t;
	}
	@Override
	public void drawOn(Graphics g, int multiplier) {
		Graphics2D g2 = (Graphics2D) g;
		int width = this.currentPosition.getX()*multiplier;
		int height = this.currentPosition.getY()*multiplier;
		if(this.row == 0){
			g.setColor(Color.ORANGE);
			Rectangle square = new Rectangle(width, height-multiplier, multiplier, 2*multiplier);
			g2.fill(square);
		}
		if(this.row == 1){
			g.setColor(Color.GREEN);
			Rectangle square = new Rectangle(width, height-multiplier, multiplier, 2*multiplier);
			g2.fill(square);
		}
		if(this.row == 2){
			g.setColor(Color.RED);
			Rectangle square = new Rectangle(width, height-multiplier, multiplier, 2*multiplier);
			g2.fill(square);
		}
		if(this.row == 3){
			g.setColor(Color.ORANGE);
			Rectangle square = new Rectangle(width, height-multiplier, multiplier, 2*multiplier);
			g2.fill(square);
		}
	}

	@Override
	public Coordinate getCoordinate() {
		return this.currentPosition;
	}
	public Coordinate getPosition() {
		return this.currentPosition;
	}

	@Override
	public boolean stop() {
		// TODO Auto-generated method stub.
		return false;
	}

	@Override
	public boolean continueGame() {
		// TODO Auto-generated method stub.
		return false;
	}
	
	public boolean isStepped(){
		return this.isStepped;
	}
	
	public int getRow(){
		return this.row;
	}
	
	public int getColumn(){
		return this.column;
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
	
	public void setIsOnPlate(boolean b){
		this.isOnThePlate = b;
	}

	@Override
	public boolean checkDownLadder(ArrayList<Ladder> ladders) {
		// TODO Auto-generated method stub.
		return false;
	}



	@Override
	public boolean checkLeftFloor(ArrayList<Floor> floors) {
		// TODO Auto-generated method stub.
		return false;
	}

	@Override
	public boolean checkUpLadder(ArrayList<Ladder> ladders) {
		// TODO Auto-generated method stub.
		return false;
	}

	@Override
	public boolean checkRightFloor(ArrayList<Floor> floors) {
		// TODO Auto-generated method stub.
		return false;
	}
}
