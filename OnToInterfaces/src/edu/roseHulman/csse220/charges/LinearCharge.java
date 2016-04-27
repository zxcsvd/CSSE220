package edu.roseHulman.csse220.charges;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

/**
 * TODO Put here a description of what this class does.
 *
 * @author Pengdi.
 *         Created Jan 16, 2014.
 */
public class LinearCharge implements Charge{

	private double startX;
	private double endX;
	private double startY;
	private double endY;
	private double charge;
	
	public LinearCharge(double startX, double StartY, double endX, double endY, double charge){
		this.startX = startX;
		this.endX = endX;
		this.startX = startX;
		this.endY = endY;
		this.charge = charge;
	}
	@Override
	public Vector forceAt(int x, int y) {
		int numberOfPoints = 1000;
		double currentX = this.startX;
		double currentY = this.startY;
		double deltaX =(this.endX - this.startX)/numberOfPoints;
		double deltaY = (this.endY- this.startX)/numberOfPoints;
		double partialCharge = this.charge/numberOfPoints;
		Vector forceSum = Vector.ZERO;
		for(int i =0; i<= numberOfPoints; i++){
			PointCharge ittyBittyCharge = new PointCharge(currentX, currentY, partialCharge);
			Vector partialForce = ittyBittyCharge.forceAt(x, y);
			forceSum = forceSum.add(partialForce);
			currentX += deltaX;
			currentY += deltaY;
		}
		return forceSum;
	}

	@Override
	public void drawOn(Graphics2D g) {
		Line2D.Double line = new Line2D.Double(this.startX, this.startY, this.endX, this.endY);
		g.setColor(Color.orange);
		g.draw(line);
		// TODO Auto-generated method stub.
		
	}
	
}
