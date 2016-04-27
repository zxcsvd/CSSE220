package ballworlds;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.geom.Point2D;
import java.util.Random;

/**
 * A ball that bounces off the walls.
 * 
 * @author Curt Clifton. Created Jan 22, 2011.
 */
public abstract class AbstractBouncer extends Ball {
	private static final double BOUNCER_TO_WORLD_RATIO= 1.0/12.0;
	private static final double SPEED_MULTIPLIER = 2.0;
	
	private double diameter;
	private double xVelocity;
	private double yVelocity;
	private Random random = new Random();

	/**
	 * Constructs a abstract bouncer in the given world.
	 * 
	 * @param world
	 */
	public AbstractBouncer(BallEnvironment world) {
		super(world);
		Dimension worldSize = world.getSize();
		this.setCenterPoint(new Point2D.Double(worldSize.getWidth()/2, worldSize.getHeight()/2));
		this.diameter = worldSize.getWidth()*BOUNCER_TO_WORLD_RATIO;
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
	public void updatePosition() {
		Dimension worldSize = this.getWorld().getSize(); 
		if(this.getCenterPoint().getX()<=this.diameter/2.0){
			this.xVelocity = Math.abs(this.xVelocity);
		}
		if(this.getCenterPoint().getX()>=worldSize.getWidth()-this.diameter/2){
			this.xVelocity = -Math.abs(this.xVelocity);
		}
		if(this.getCenterPoint().getY()<=this.diameter/2.0){
			this.yVelocity = Math.abs(this.yVelocity);
		}
		if(this.getCenterPoint().getY()>=worldSize.getHeight()-this.diameter/2){
			this.yVelocity = -Math.abs(this.yVelocity);
		}
		
		double newX = this.xVelocity +this.getCenterPoint().getX();
		double newY = this.yVelocity +this.getCenterPoint().getY();
		
		
		this.setCenterPoint(new Point2D.Double(newX, newY));
		
	}
	@Override
	public double getDiameter() {
		return this.diameter;
	}
	public void setDiameter(double diameter) {
		this.diameter= diameter;
	}

}
