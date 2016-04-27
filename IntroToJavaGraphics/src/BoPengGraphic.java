import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JComponent;

/**
 * 
 */

/**
 * TODO Put here a description of what this class does.
 *
 * @author pengb.
 *         Created 2013-12-12.
 */
public class BoPengGraphic extends JComponent {

	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	protected void paintComponent(Graphics arg0) {
		// TODO Auto-generated method stub
		super.paintComponent(arg0);
		Graphics2D graphics2 = (Graphics2D) arg0;
		Rectangle box = new Rectangle(10, 20, 30, 40);
		graphics2.draw(box);
		for (int k=0; k< 37; k++){
			Rectangle box2 = new Rectangle(10, 10, k*10, k*10);
			graphics2.draw(box2);
		}
	}

}
