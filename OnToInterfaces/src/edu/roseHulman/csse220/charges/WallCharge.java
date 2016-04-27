//package edu.roseHulman.csse220.charges;
//
//import java.awt.Graphics2D;
//
///**
// * TODO Put here a description of what this class does.
// *
// * @author Pengdi.
// *         Created Jan 16, 2014.
// */
//
//public class WallCharge implements Charge{
//	private double xposition;
//	private double charge;
//	
//	
//	public WallCharge(double xposition, double charge){
//		this.xposition = xposition;
//		this.charge = charge;
//	}
//	public Vector forceAt(int x, int y) {
//		// TODO Auto-generated method stub.
//		
//		int numberOfPoints = 1000;
//		double position = this.xposition;
//		double deltaY = 600/numberOfPoints;
//		double partialCharge = this.charge/numberOfPoints;
//		Vector forceSum = Vector.ZERO;
//		for(int i =0; i<= numberOfPoints; i++){
//			PointCharge ittyBittyCharge = new PointCharge(this.xposition, 0, partialCharge);
//			Vector partialForce = ittyBittyCharge.forceAt(x, y);
//			forceSum = forceSum.add(partialForce);
//			currentX += deltaX;
//			currentY += deltaY;
//		}
//		return null;
//	}
//
//	@Override
//	public void drawOn(Graphics2D g) {
//		// TODO Auto-generated method stub.
//		
//	}
//
//}
