import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;

/**
 * 
 */

/**
 * TODO Put here a description of what this class does.
 *
 * @author pengb.
 *         Created 2013-12-16.
 */



public class Face {
	
	private static final float BORDER_WIDTH = 3;
	private Color borderColor;
	private Color mouthColor;
	private Color fillColor;
	
	private double centerX;
	private double centerY;
	private double radius;
	private int number;
	private Color eyesColor;
	private double angleInRadians = 0.0;
	private double degreesToRotate;
	private double distance = 0.0;
	
	public Face(double centerX, double centerY, double diameter, 
			Color borderColor, Color fillColor, Color eyesColor, Color mouthColor, double degreesToRotate, double distance){
		this.centerX = centerX;
		this.centerY = centerY;
		this.radius = diameter/2;
		this.borderColor = borderColor;
		this.eyesColor = eyesColor;
		this.mouthColor = mouthColor;
		this.fillColor = fillColor;
		this.degreesToRotate = degreesToRotate;
		this.distance = distance;
	}
	
	public void drawTotal(Graphics2D graphics2){
		drawmouth(graphics2,0);
		drawFace(graphics2, 0);
		drawEyes(graphics2,0);

	}

	public void drawFace(Graphics2D graphics2, int times){
		Ellipse2D.Double face = new Ellipse2D.Double(this.centerX-this.radius, this.centerY-this.radius,
				2*radius, 2*radius);
		
		
		graphics2.translate((this.distance+radius*2)*times, 0);		
		graphics2.setColor(this.fillColor);
		

		graphics2.fill(face);		
		graphics2.setStroke(new BasicStroke(this.BORDER_WIDTH));
		graphics2.setColor(this.borderColor);
		
		graphics2.draw(face);
		graphics2.translate(-(this.distance+radius*2)*times, 0);
	}
	
	public void drawEyes(Graphics2D graphics2, int times){


//		graphics2.translate(this.centerX, this.centerY);	
//					
//		for (int i =0; i< times; i++){
			Ellipse2D.Double eyes1 = new Ellipse2D.Double(-(this.radius/3*2), -(this.radius/4*1),
				this.radius/2, this.radius/2);
			Ellipse2D.Double eyes2 = new Ellipse2D.Double((this.radius/6*1), -(this.radius/4*1),
				this.radius/2, this.radius/2);
			graphics2.setColor(this.eyesColor);
			graphics2.rotate(times*this.angleInRadians);
	
			graphics2.translate((this.distance+radius*2)*times*Math.cos(angleInRadians*times), 
					-(this.distance+radius*2)*times*Math.sin(angleInRadians*times));
			graphics2.translate(0,-this.radius/3*1);
			graphics2.fill(eyes1);
			graphics2.fill(eyes2);		
			graphics2.draw(eyes1);
			graphics2.draw(eyes2);				
			graphics2.translate(0,this.radius/3*1);
			graphics2.translate(-(this.distance+radius*2)*times*Math.cos(angleInRadians*times), 
					(this.distance+radius*2)*times*Math.sin(angleInRadians*times));
			

			
			graphics2.rotate(-times*this.angleInRadians);

//			}
//		graphics2.translate(-this.centerX, -this.centerY);

		
	}
	

	
	public void drawmouth(Graphics2D graphics2, int times){
		Arc2D.Double mouth = new Arc2D.Double(- (this.radius/3*2), -(this.radius/3*2),
				(this.radius / 3 * 4), (this.radius / 3 * 4), 180, 180, Arc2D.PIE);
		graphics2.setColor(this.mouthColor);
		graphics2.setStroke(new BasicStroke(1.0f));
		graphics2.rotate(times*this.angleInRadians);
		graphics2.translate((this.distance+radius*2)*times*Math.cos(angleInRadians*times), 
				-(this.distance+radius*2)*times*Math.sin(angleInRadians*times));
		
		graphics2.draw(mouth);
		
		graphics2.translate(-(this.distance+radius*2)*times*Math.cos(angleInRadians*times), 
				(this.distance+radius*2)*times*Math.sin(angleInRadians*times));

		graphics2.rotate(-times*this.angleInRadians);
	}
	
	public void translate(double translateX, double translateY) {
		this.centerX += translateX;
		this.centerY += translateY;
	}
	
	public void rotate(double degreesToRotate) {
		double radiansToRotate = Math.toRadians(degreesToRotate);
		this.angleInRadians  += radiansToRotate;
	}
}
