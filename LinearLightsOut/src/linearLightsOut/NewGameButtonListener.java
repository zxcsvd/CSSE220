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
public class NewGameButtonListener implements ActionListener{
	private ButtonModifier newSetButton;
	private JFrame frame; 
	@Override
	public void actionPerformed(ActionEvent e) {
		// listener of the newGame button
		this.newSetButton.reStart(this.newSetButton.getButtonList().size(), this.frame);
		
	}
	/**
	 * the constructor which is used to pass parameter: frame and newSetButton
	 *
	 * @param newSetButton
	 * @param frame
	 */
	public NewGameButtonListener(ButtonModifier newSetButton, JFrame frame){
		this.newSetButton = newSetButton;
		this.frame = frame;
	}
}
