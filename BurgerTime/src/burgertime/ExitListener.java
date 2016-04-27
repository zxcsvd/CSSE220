package burgertime;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

/**
 * TODO Put here a description of what this class does.
 *
 * @author Pengdi.
 *         Created Feb 4, 2014.
 */
public class ExitListener implements ActionListener{
	private JFrame mainFrame;
	
	public ExitListener(JFrame mainFrame){
		this.mainFrame = mainFrame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.mainFrame.dispose();
		
	}

}
