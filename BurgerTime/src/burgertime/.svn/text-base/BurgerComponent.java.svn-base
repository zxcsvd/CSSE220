package burgertime;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;

import javax.swing.JComponent;

/**
 * TODO Put here a description of what this class does.
 *
 * @author Pengdi.
 *         Created Feb 2, 2014.
 */
public class BurgerComponent extends JComponent{
	private Level levelInformation;
//	private ArrayList<Drawable> component;
	public static final int PIXEL_MULTIPLIER = 5;
	public static final int FRAMES_PER_SECOND = 3000;
	public static final int REPAINT_INTERVAL_MS = 1000/FRAMES_PER_SECOND;
	public BurgerComponent(Level levelInformation){
		this.levelInformation = levelInformation;
		Runnable repainter = new Runnable() {
			@Override
			public void run() {
				// Periodically asks Java to repaint this component
				try {
					while (true) {
						Thread.sleep(REPAINT_INTERVAL_MS);
						repaint();
					}
				} catch (InterruptedException exception) {
					// Stop when interrupted
				}
			}
		};
		new Thread(repainter).start();
	}
	
	
	
	@Override
	public void paintComponent(Graphics g){
		
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.BLACK);
		
		g2.fillRect(0, 0, this.levelInformation.getFrameWidth()*PIXEL_MULTIPLIER , this.levelInformation.getFrameHeight()*PIXEL_MULTIPLIER);
		ArrayList<Drawable> tempList = this.levelInformation.getComponents();
	
			
		for (Drawable components: tempList) {	
			
			components.drawOn(g2, PIXEL_MULTIPLIER); 
			
		}

	}
	
	public void modifyComponents(Drawable newData){
		System.out.println("Modifying components");
		this.levelInformation.modifySelected(newData);
	}
}
