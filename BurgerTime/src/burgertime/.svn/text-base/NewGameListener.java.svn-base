/**
 * 
 */
package burgertime;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

/**
 * TODO Put here a description of what this class does.
 *
 * @author wangx3.
 *         Created Feb 2, 2014.
 */
public class NewGameListener implements ActionListener{
	private JFrame mainFrame;
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public NewGameListener(JFrame mainFrame){
		this.mainFrame = mainFrame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.mainFrame.dispose();
		LevelLoader loader = new LevelLoader(1);
		loader.loadGame();
		loader.constructNewGame();
		
		
	}

}
