package animation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;

/**
 * A component to hold the animated object.
 * 
 * @author Matt Boutell, modified by <YOUR NAME>. Created Jan 30, 2010.
 */
public class AnimationComponent extends JPanel implements Runnable{
	private double angle;
	private double radius;
	private int nRectangles;
	private static final double DELTA_ANGLE = Math.PI / 9;
	private static final double RADIUS_GROWTH_FACTOR = 1.5;
	private static final double SQUARE_SIZE = 20;
	private static final int DRAWING_SIZE = 400;
	private static final int MAX_RECTANGLES = 144;
	private int sleepTime;

	/**
	 * Creates a new component.
	 * 
	 */
	public AnimationComponent(int sleepTime) {
		
		this.angle = 0;
		this.radius = 0;
		this.nRectangles = 0;
		this.sleepTime = sleepTime;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		this.setBackground(Color.WHITE);
		this.radius = 0;
		this.angle = 0;
		for (int i = 0; i < this.nRectangles; i++) {
			double x = DRAWING_SIZE / 2 + this.radius * Math.cos(this.angle);
			double y = DRAWING_SIZE / 2 + this.radius * Math.sin(this.angle);
			// Angle determines hue of color. Decreasing saturation over time,
			// as the number of rectangles increases, causes it to fade
			// over time. 
			float hue = (float) (this.angle / (2 * Math.PI));
			float saturation = i/(float)(Math.pow(this.nRectangles, 1.2));
			g2.setColor(Color.getHSBColor(hue, saturation, 1.0f));
			g2.fill(new Rectangle2D.Double(x, y, SQUARE_SIZE, SQUARE_SIZE));
			this.radius += RADIUS_GROWTH_FACTOR;
			this.angle += DELTA_ANGLE; 
		}
	}

	/**
	 * Move the shape to the next location, resetting once the screen is full
	 * of some fixed number of rectangles.
	 */
	public void addSquare() {
		if (this.nRectangles > MAX_RECTANGLES) {
			this.nRectangles = 0;
		}
		this.nRectangles++;
		this.repaint();
	}

	@Override
	public void run() {
		try{
			this.setPreferredSize(new Dimension(DRAWING_SIZE, DRAWING_SIZE));
		}catch (Exception exception1) {
			// TODO Auto-generated catch-block stub.
			exception1.printStackTrace();
		}
		try {
			Thread.sleep(this.sleepTime);
		} catch (InterruptedException exception) {
			// TODO Auto-generated catch-block stub.
			exception.printStackTrace();
		}
	}
}
