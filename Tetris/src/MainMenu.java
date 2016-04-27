import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


/**
 * TODO Put here a description of what this class does.
 *
 * @author Pengdi.
 *         Created Mar 4, 2014.
 */
public class MainMenu {
	
	
	/**
	 * TODO Put here a description of what this constructor does.
	 *
	 */
	public MainMenu(){
		JFrame mainFrame = new JFrame("Tetris");
		mainFrame.setSize(800, 600);
		mainFrame.setLocationRelativeTo(null);
		JPanel buttonPanel = new JPanel();
		JButton newGameButton = new JButton("New Game");
		JButton exitButton = new JButton("EXIT");
		JButton helpButton = new JButton("Help");
		buttonPanel.setLayout(new FlowLayout(FlowLayout.TRAILING));
		buttonPanel.setBackground(Color.black);
		
		ExitListener exitListener = new ExitListener(mainFrame);
		exitButton.addMouseListener(exitListener);
		
		NewGameListener newGameListener = new NewGameListener(mainFrame);
		newGameButton.addMouseListener(newGameListener);
		
		buttonPanel.add(newGameButton);
		buttonPanel.add(exitButton);
		buttonPanel.add(helpButton);
		
		
		
		mainFrame.add(buttonPanel,BorderLayout.SOUTH);
		mainFrame.add(new JLabel(new ImageIcon(loadBackGround())),BorderLayout.CENTER);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setVisible(true);
	}

	/**
	 * The main method which creates the main menu.
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		new MainMenu();
	}
	
	/**
	 * TODO Put here a description of what this method does.
	 *
	 * @return
	 */
	public String loadBackGround(){
		URL url = this.getClass().getResource("square.png");
		return url.getPath();
	}


}
