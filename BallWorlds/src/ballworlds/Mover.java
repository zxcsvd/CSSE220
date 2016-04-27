package ballworlds;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;
import java.util.Random;

public class Mover extends Ball {
	private static final double MOVER_TO_WORLD_RATIO= 1.0/12.0;
	private static final double SPEED_MULTIPLIER = 2.0;
	
	private Color color;
	private double diameter;
	private double xVelocity;
	private double yVelocity;
	private Random random = new Random();
	
	public Mover(BallEnvironment world) {
		super(world);
		Dimension worldSize = world.getSize();
		this.setCenterPoint(new Point2D.Double(worldSize.getWidth()/2, worldSize.getHeight()/2));
		this.color = color.GREEN;
		this.diameter = worldSize.getWidth()*MOVER_TO_WORLD_RATIO;
		this.xVelocity = this.random.nextDouble()*SPEED_MULTIPLIER;
		this.yVelocity = this.random.nextDouble()*SPEED_MULTIPLIER;
		if(this.random.nextBoolean()){
			this.xVelocity*=-1;
		}
		if(this.random.nextBoolean()){
			this.yVelocity*=-1;
		}
	}

	@Override
	public Color getColor() {
		return this.color;
	}

	@Override
	public void updatePosition() {
		double newX = this.xVelocity +this.getCenterPoint().getX();
		double newY = this.yVelocity +this.getCenterPoint().getY();
		this.setCenterPoint(new Point2D.Double(newX, newY));
		
	}

	@Override
	public void updateSize() {
		
	}

	@Override
	public void updateColor() {
		
	}

	@Override
	public double getDiameter() {
		// TODO Auto-generated method stub
		return this.diameter;
	}

}
