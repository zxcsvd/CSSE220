package linearLightsOut;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Runs the Linear Lights Out application.
 * 
 * @author <Bo Peng>. Created Jan 18, 2010.
 */
public class LinearMain {
/**
 * width constant 
 */
public final static int BUTTONWIDTH = 55;
/**
 * length constant
 */
public final static int BUTTONHEIGHT = 80;

	/**
	 * Starts here.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		String nButtonsString = JOptionPane
				.showInputDialog("How many buttons would you like?");
		int nButtons = Integer.parseInt(nButtonsString);
		
		JFrame myFrame = new JFrame();

		myFrame.setTitle("Linear Lights Out!");
		
		ButtonModifier newSetButton = new ButtonModifier(nButtons);
		
		JButton exit = new JButton("EXIT");
		JButton newGame = new JButton("NEWGAME");
				
		JPanel exitPanel = new JPanel();
		exitPanel.add(newGame, BorderLayout.SOUTH);
		exitPanel.add(exit, BorderLayout.SOUTH);
		
		NewGameButtonListener newGameListener = new NewGameButtonListener(newSetButton, myFrame);
		ExitButtonListener exitListener = new ExitButtonListener(myFrame);
		newGame.addActionListener(newGameListener);
		exit.addActionListener(exitListener);
		

		myFrame.add(exitPanel);
		myFrame.setSize(BUTTONWIDTH*nButtons+40, (int) (BUTTONHEIGHT*1.5));
		
			
		
		for(int i =0; i<nButtons; i++){
			MyButtonListener buttonReact = new MyButtonListener(i, newSetButton, myFrame);
			newSetButton.getButton(i).addActionListener(buttonReact);
		}
		
		newSetButton.putButton(newSetButton.getButtonList(), myFrame);
		
		// you'll want to think about how you want to manage the state of the game
		//also you want to add some buttons and stuff
		myFrame.setVisible(true);
	}
}
