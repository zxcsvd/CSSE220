package linearLightsOut;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 * TODO Put here a description of what this class does.
 *
 * @author pengb.
 *         Created Jan 20, 2014.
 */
public class MyButtonListener implements ActionListener{
private int index;
private ButtonModifier listOfButtons;
private JFrame frame; 
	//listener of those buttons with "O" and "X".
	@Override
	public void actionPerformed(ActionEvent e) {
		this.listOfButtons.changeSign(this.index, this.frame);
	}
	/**
	 * the constructor that is used to pass parameter: index, listOfButtons and frame
	 *
	 * @param index
	 * @param listOfButtons
	 * @param frame
	 */
	public MyButtonListener(int index, ButtonModifier listOfButtons, JFrame frame){
		this.index = index;
		this.listOfButtons = listOfButtons;
		this.frame = frame;
		
	}

}
