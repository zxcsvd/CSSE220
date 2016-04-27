package ballworlds;

import java.awt.Color;
import java.awt.geom.Point2D;
import java.util.Random;

public class Exploder extends AbstractBouncer{
	private static final double RANDOM_FACTOR = 8.0;
	private static final double RANDOM_CORRECTER = 2.0;
	private static final double BOUNCES_TIL_EXPLODE = 2000.0;
	private static final double EXPLODER_TO_WORLD_RATIO= 1.0/12.0;
	
	private Color color;
	private Random random =new Random();
	private double finalDiameter;
	private double increaseIncrement;
	
	public Exploder(BallEnvironment world) {
		super(world);
		this.color = color.ORANGE;
		double sizeMultiplier = Math.min(world.getSize().getHeight(), world.getSize().getWidth());
		this.setDiameter(sizeMultiplier*EXPLODER_TO_WORLD_RATIO);
		this.finalDiameter = this.getDiameter()*
				(this.random.nextDouble()*RANDOM_FACTOR+RANDOM_CORRECTER);
		this.increaseIncrement = (this.finalDiameter-this.getDiameter())/BOUNCES_TIL_EXPLODE;
	}
	public Exploder(BallEnvironment world, Point2D point2d){
		super(world);
		this.setCenterPoint(point2d);
		this.color = color.ORANGE;
		this.finalDiameter = this.getDiameter()*
				this.random.nextDouble()*RANDOM_FACTOR+RANDOM_CORRECTER;
		this.increaseIncrement = (this.finalDiameter-this.getDiameter())/BOUNCES_TIL_EXPLODE;
	}

	@Override
	public Color getColor() {
		// TODO Auto-generated method stub
		return this.color;
	}

	@Override
	public void updateSize() {
		if((this.getCenterPoint().getX()<=this.getDiameter()/2.0 + this.increaseIncrement || this.getCenterPoint().getX()>=this.getWorld().getSize().getWidth() - this.getDiameter()/2 -this.increaseIncrement || this.getCenterPoint().getY()<=this.getDiameter()/2.0 + this.increaseIncrement|| this.getCenterPoint().getY()>=this.getWorld().getSize().getHeight()-this.getDiameter()/2-this.increaseIncrement)){
			
		}
		else{
			this.setDiameter(this.getDiameter()+this.increaseIncrement);
		}
		this.setDiameter(this.getDiameter()+this.increaseIncrement);
		if(this.getDiameter()>=this.finalDiameter){
			this.die();
			this.getWorld().addBall(new Exploder(this.getWorld(), this.getCenterPoint()));
			this.getWorld().addBall(new Exploder(this.getWorld(), this.getCenterPoint()));
			
		}
		
	}
		
	@Override
	public void updateColor() {
		
	}
	
	public double getIncresement(){
		return this.increaseIncrement;
	}

} 
