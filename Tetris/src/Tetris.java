import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;


/**
 * TODO Put here a description of what this class does.
 *
 * @author Pengdi.
 *         Created Mar 4, 2014.
 */
public class Tetris {
	private int level = 1;
	private JFrame tetrisFrame;
	private int score = 0;
	private int multiplier = 0;
	private JLabel scoreInd;
	private JLabel levelInd;
	private JLabel multiInd;
	private JPanel rightPanel;
	
	
	
	public Tetris(){
		loadGameFrame();
		loadGameBoard();
		loadStaticElement();
		loadTetrisLabels();
	}

	public void loadGameFrame(){
		this.tetrisFrame = new JFrame("Game Start!");
		this.tetrisFrame.setSize(600,750);
		this.tetrisFrame.setLocationRelativeTo(null);
		this.tetrisFrame.getContentPane().setBackground(Color.black);
		
		this.tetrisFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.tetrisFrame.setVisible(true);
	}
	
	/**
	 * TODO Put here a description of what this method does.
	 *
	 */
	public void loadStaticElement(){

		this.rightPanel = new JPanel();
		
		this.rightPanel.setLayout(new BoxLayout(this.rightPanel, BoxLayout.Y_AXIS));
		this.rightPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		JLabel nextLabel = new JLabel("Next:");
		nextLabel.setForeground(Color.white);
		LoadNextGameBoard nextBoard = new LoadNextGameBoard();

		Font font = new Font("Calibri", Font.PLAIN, 20);
		nextLabel.setFont(font);

		this.rightPanel.setBackground(Color.black);
		this.rightPanel.add(nextLabel);
		this.rightPanel.add(nextBoard);

		this.tetrisFrame.add(this.rightPanel, BorderLayout.EAST);
		
		
	}
	
	/**
	 * TODO Put here a description of what this method does.
	 *
	 */
	public void loadTetrisLabels(){
		JLabel scoreLabel = new JLabel("Score:");
		this.scoreInd = new JLabel(this.score +"");
		JLabel levelLabel = new JLabel("Level:");
		this.levelInd = new JLabel(this.level+"");
		JLabel multiLabel = new JLabel("Multiplier:");
		this.multiInd = new JLabel(this.multiplier+"");
		Font font = new Font("Calibri", Font.PLAIN, 20);
		
		scoreLabel.setFont(font);
		scoreInd.setFont(font);
		levelLabel.setFont(font);
		levelInd.setFont(font);
		multiLabel.setFont(font);
		multiInd.setFont(font);
		
		scoreLabel.setForeground(Color.white);
		scoreInd.setForeground(Color.white);
		levelLabel.setForeground(Color.white);
		levelInd.setForeground(Color.white);
		multiLabel.setForeground(Color.white);
		multiInd.setForeground(Color.white);
		this.rightPanel.add(scoreLabel);
		this.rightPanel.add(scoreInd);
		this.rightPanel.add(levelLabel);
		this.rightPanel.add(levelInd);
		this.rightPanel.add(multiLabel);
		this.rightPanel.add(multiInd);

	}
	
	/**
	 * TODO Put here a description of what this method does.
	 *
	 */
	public void loadGameBoard(){
		LoadGameBoard gameBoard = new LoadGameBoard();
		this.tetrisFrame.add(gameBoard);
	}
	

}

