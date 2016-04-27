package burgertime;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class Pepper implements Drawable{
	private Hero hero;
	private boolean isPresent;
	private Coordinate presentPosition;
	
	public Pepper(Hero hero){
		this.hero = hero;
		this.isPresent = true;
	}
	
	public Pepper(Coordinate presentPosition){
		//use when construct the initial form of each level,not the PepperListener, but read file
		this.presentPosition = presentPosition;
	}
	
	public Coordinate getPosition(){
		return this.presentPosition;
	}
	
	public void drawOn(Graphics g, int multiplier){
		while(this.isPresent ==true){
		Graphics2D g2 = (Graphics2D) g;
		int circleX = (this.hero.getCoordinate().getX()-2)*multiplier;
		int circleY = (this.hero.getCoordinate().getY()-7)*multiplier;
		
		g.setColor(Color.MAGENTA);
		
		Ellipse2D.Double pepper = new Ellipse2D.Double(circleX, circleY, 6*multiplier, 3*multiplier);
		g2.draw(pepper);}
	}
	
	public void disappear(){
		this.isPresent = false;
	}

	@Override
	public Coordinate getCoordinate() {
		// TODO Auto-generated method stub
		return this.hero.getCoordinate();
	}
	
	

}

