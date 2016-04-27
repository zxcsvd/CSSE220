package linearLightsOut;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

/**
 * TODO Put here a description of what this class does.
 *
 * @author pengb.
 *         Created Jan 21, 2014.
 */

public class ExitButtonListener implements ActionListener{
/**
 * the window frame.
 */
public JFrame frame;
	//Exit the window and end the game, listener of the exit button
	@Override
	public void actionPerformed(ActionEvent e) {
		this.frame.dispose();
		
	}
	/**
	 * pass the parameter: frame
	 *
	 * @param frame
	 */
	public ExitButtonListener(JFrame frame){
		this.frame = frame;
	}

}
