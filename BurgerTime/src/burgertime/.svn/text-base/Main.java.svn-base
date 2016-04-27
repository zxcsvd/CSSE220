package burgertime;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



/**
 * @author Your team number and names here and in all your code files
 */
public class Main {
public static final int HEIGHT = 400;
public static final int WIDTH = 250;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Add code here.  Create any other needed methods in this class, 
		//      and any other classes that you need.
		JFrame mainMenu = new JFrame();
		mainMenu.setTitle("BurgerTime");
		
		JPanel buttonPanel= new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
		mainMenu.setSize(WIDTH,HEIGHT);
		
		
		ExitListener exitL = new ExitListener(mainMenu);
		NewGameListener newGameL = new NewGameListener(mainMenu);
		
		JButton newGame = new JButton("New Game");
		JButton exit = new JButton("EXIT");
		JButton help = new JButton("Help");
		
		exit.addActionListener(exitL);
		newGame.addActionListener(newGameL);
		addBorder(buttonPanel);

		fixPosition(buttonPanel, newGame);
		fixPosition(buttonPanel, help);
		fixPosition(buttonPanel, exit);
		
		mainMenu.add(buttonPanel);
		mainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainMenu.setVisible(true);
		
		
	}
	public static void addBorder(JPanel buttonPanel){
		JPanel p =new JPanel();
		p.setBorder(new EmptyBorder(0, 20, 0, 0) );
		buttonPanel.add(p);
	}
	
	public static void fixPosition(JPanel buttonPanel,JButton button){
		button.setAlignmentX(Component.CENTER_ALIGNMENT);
		buttonPanel.add(button);
		addBorder(buttonPanel);
	}
	
}
