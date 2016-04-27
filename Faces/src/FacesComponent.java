import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import javax.swing.JComponent;

/**
 * 
 */

/**
 * TODO Put here a description of what this class does.
 *
 * @author pengb.
 *         Created 2013-12-16.
 */

public class FacesComponent extends JComponent {
private double degreesToRotate = 30;
private double distance = 20;
private double centerX = 300;
private double centerY= 150;
private double diameter = 50;
private Color borderColor = Color.black;
private Color mouthColor = Color.black;
private Color fillColor = Color.yellow;
private Color eyesColor = Color.black;
	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	protected void paintComponent(Graphics graphics) {
		// Displays a circle and a filled circle
		super.paintComponent(graphics);

		Graphics2D graphics2 = (Graphics2D) graphics;
		
		Face alpha = new Face(centerX, centerY, diameter, borderColor, fillColor, eyesColor, mouthColor , degreesToRotate, distance);
		int timesToRotate = (int) (this.getWidth()/(diameter + distance));
		

		alpha.rotate(degreesToRotate);
		for (int i =0; i< timesToRotate; i++){
			alpha.drawFace(graphics2, i);
		}
		
		graphics2.translate(this.centerX, this.centerY);	
		
		for (int i =0; i< timesToRotate; i++){
			alpha.drawEyes(graphics2, i);	
			alpha.drawmouth(graphics2, i);
		}
		
		graphics2.translate(-this.centerX, -this.centerY);
		
//		Face beta = new Face(100, 100, 200, Color.cyan, Color.green, Color.red, Color.gray, 0, 0);
//		beta.rotate(0);
//		for (int i =0; i< 1; i++){
//			beta.drawFace(graphics2, i);
//		}
//		
//		graphics2.translate(100, 100);	
//		
//		for (int i =0; i< 1; i++){
//			beta.drawEyes(graphics2, i);	
//			beta.drawmouth(graphics2, i);
//		}
		
//		Face delta = new Face(150, 150, 100, Color.yellow, Color.red, Color.blue, Color.black, 0, 0);
//		delta.rotate(0);
//		for (int i =0; i< 1; i++){
//			delta.drawFace(graphics2, i);
//		}
//		
//		graphics2.translate(150, 150);	
//		
//		for (int i =0; i< 1; i++){
//			delta.drawEyes(graphics2, i);	
//			delta.drawmouth(graphics2, i);
//		}
//		Face echo = new Face(150, 150, 100, Color.blue, Color.green, Color.blue, Color.black, 0, 0);
//		echo.rotate(0);
//		for (int i =0; i< 1; i++){
//			echo.drawFace(graphics2, i);
//		}
//		
//		graphics2.translate(150, 150);	
//		
//		for (int i =0; i< 1; i++){
//			echo.drawEyes(graphics2, i);	
//			echo.drawmouth(graphics2, i);
//		}
	}

		
}

