package slides;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * This class demonstrates ActionListeners.
 * 
 * @author Curt Clifton. Created Oct 7, 2008.
 */
public class BreakfastMain {

	/**
	 * Starts the program.
	 * 
	 * @param args
	 *            ignored
	 */
	public static void main(String[] args) {
		/*
		 * TODO: Use JOptionPane to get description of porridge flavor; update
		 * inner classes to use the String.implements 
		 */
		JFrame frame = new JFrame();
		frame.setTitle("Breakfast for Goldilocks");

		JButton eatButton = new JButton("Eat Porridge");
		frame.add(eatButton);
		PorridgeListener myListener = new PorridgeListener();
		eatButton.addActionListener(myListener);
		// TODO: add an ActionListener using an external class
		final String coolString ="hello";
		class PorridgeListenerTwo implements ActionListener{
			private String message;
			public PorridgeListenerTwo(String message){
				this.message = message;
			}
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub.
				System.out.println(this.message);
			}
		
			
		}
		PorridgeListenerTwo myListener2 = new PorridgeListenerTwo(coolString);
		eatButton.addActionListener(myListener2);
		eatButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				System.out.println("just right");
			}
		});
		// TODO: add an ActionListener using an inner class

		// TODO: add an ActionListener using an anonymous class

		/*
		 * CONSIDER: pack() sets the size of the frame based on what we've put
		 * in it:
		 */
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
