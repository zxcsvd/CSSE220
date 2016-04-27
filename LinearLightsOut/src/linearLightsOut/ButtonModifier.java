package linearLightsOut;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * This class creates buttons ,modifies buttons and detect whether user win the game.
 *
 * @author pengb.
 *         Created Jan 20, 2014.
 */
public class ButtonModifier {
	private ArrayList<JButton> listOfButtons = new ArrayList<JButton>();
	private int numOfButtons;
	
	
	
	/**
	 * Initialize "O" and "X"
	 *
	 * @param numberOfButtons
	 */
	public ButtonModifier(int numberOfButtons){
		this.numOfButtons = numberOfButtons;
		ArrayList<JButton> listOfButtons = new ArrayList<JButton>(); 
		for(int i=0; i<numberOfButtons; i++){
			Boolean a = (Math.random() > 0.5);
			if(a){
				listOfButtons.add(new JButton("X"));
			}
			else{
				listOfButtons.add(new JButton("O"));
			}
			
		}
		this.listOfButtons = listOfButtons;
	}
	
	/**
	 * Restart the game, change back the title.
	 *
	 * @param numberOfButtons
	 * @param frame
	 */
	public void reStart(int numberOfButtons, JFrame frame){
		frame.setTitle("Linear Lights Out!");
		ArrayList<JButton> listOfButtons = new ArrayList<JButton>();
		for(int i=0; i<numberOfButtons; i++){
			Boolean a = (Math.random() > 0.5);
			if(a){
				listOfButtons.add(new JButton("X"));
				this.listOfButtons.get(i).setText("X");
			}
			else{
				listOfButtons.add(new JButton("O"));
				this.listOfButtons.get(i).setText("O");
			}
		}

		
		
	}
	
	/**
	 * return specified button
	 *
	 * @param index
	 * @return
	 */
	@SuppressWarnings("javadoc")
	public JButton getButton(int index){
		return this.listOfButtons.get(index);
	}
	
	/**
	 * return the entire list of buttons
	 *
	 * @return
	 */
	@SuppressWarnings("javadoc")
	public ArrayList<JButton> getButtonList(){
		return this.listOfButtons;
	}
	
	/**
	 * change the sign of buttons when click
	 *
	 * @param index
	 * @param frame
	 */
	public void changeSign(int index, JFrame frame){
		JButton present =  this.listOfButtons.get(index);
		if(index == 0){
			JButton next = this.listOfButtons.get(index +1);
			if(next.getText().equals("X")){
				next.setText("O");
			}
			else{
				next.setText("X");
			}
			
			if(present.getText().equals("X")){
				present.setText("O");
			}
			else{
				present.setText("X");
			}			
		}
		if(index == this.numOfButtons - 1){
			JButton previous = this.listOfButtons.get(index -1);
			if(previous.getText().equals("X")){
				previous.setText("O");
			}
			else{
				previous.setText("X");
			}
			
			if(present.getText().equals("X")){
				present.setText("O");
			}
			else{
				present.setText("X");
			}	
		}
		if(index !=0 && index != this.numOfButtons - 1){
			JButton previous = this.listOfButtons.get(index -1);
			JButton next = this.listOfButtons.get(index +1);
			if(previous.getText().equals("X")){
				previous.setText("O");
			}
			else{
				previous.setText("X");
			}
			
			if(next.getText().equals("X")){
				next.setText("O");
			}
			else{
				next.setText("X");
			}
			if(present.getText().equals("X")){
				present.setText("O");
			}
			else{
				present.setText("X");
			}	
		}
		detectVic(frame);
	}
	
	/**
	 * detect whether the user win the game
	 *
	 * @param frame
	 */
	public void detectVic(JFrame frame){
		String temp = this.listOfButtons.get(0).getText();
		int count = 0;
		for(int i=0; i<this.numOfButtons; i++){
			if(this.listOfButtons.get(i).getText() == temp){
				count++;
			}
		}
		if(count == this.numOfButtons){
			frame.setTitle("You Win!");
			
		}
		
	}
	/**
	 * put a list of button into the given frame
	 *
	 * @param listOfButton
	 * @param frame
	 */
	public void putButton(ArrayList<JButton> listOfButton, JFrame frame){
		JPanel panel = new JPanel();
		
		for (int i=0; i<listOfButton.size(); i++){
			panel.add(listOfButton.get(i));
		}
		frame.add(panel, BorderLayout.NORTH);
		
	}
}
