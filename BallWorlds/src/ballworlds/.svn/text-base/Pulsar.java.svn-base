package ballworlds;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.geom.Point2D;
import java.util.Random;

public class Pulsar extends Ball{
	private static final double PULSAR_TO_WORLD_RATIO= 1.0/12.0;	
	
	private Color color;
	private boolean isDarkening;
	private Random random= new Random();
	private int slower = 0;
	private double diameter;
	
	public Pulsar(BallEnvironment world) {
		super(world);
		this.color=color.WHITE;
		this.isDarkening=true;
		Dimension worldSize=world.getSize();
		this.diameter = worldSize.getWidth()*PULSAR_TO_WORLD_RATIO;
		double xCoord;
		double yCoord;
		while(true){
			xCoord= this.random.nextDouble()*worldSize.getWidth();
			if(xCoord>=this.diameter/2.0 && xCoord<=worldSize.getWidth()-this.diameter/2){
				break;
			}
		}
		while(true){
			yCoord= this.random.nextDouble()*worldSize.getHeight();
			if(yCoord>=this.diameter/2.0 && yCoord<=worldSize.getHeight()-this.diameter/2){
				break;
			}
		}
		this.setCenterPoint(new Point2D.Double(xCoord,yCoord));
		
	}

	@Override
	public Color getColor() {
		return this.color;
	}

	@Override
	public void updatePosition() {
		
	}

	@Override
	public void updateSize() {

	}

	@Override
	public void updateColor() {
		int slowFactor= 11;
		this.slower += 1;
		if(this.slower % slowFactor ==0){
			if(this.isDarkening ){
				this.color=this.color.darker();
				if(this.color.equals(color.BLACK)){
					this.isDarkening=false;
				}
			}
			else{
				this.color=this.color.brighter();
				if(this.color.equals(color.WHITE)){
					this.isDarkening=true;
				}
			}
		}
	}

	@Override
	public double getDiameter() {
		
		return this.diameter;
	}

}
