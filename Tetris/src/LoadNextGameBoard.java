import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JComponent;
import javax.swing.JPanel;


/**
 * TODO Put here a description of what this class does.
 *
 * @author Pengdi.
 *         Created Mar 5, 2014.
 */
public class LoadNextGameBoard extends JPanel{
	private static int NEXT_GAME_BOARD_WIDTH = 90;
	private static int NEXT_GAME_BOARD_LENGTH = 120;
	private final static  int LEFT_MARGIN = 10;
	private final static int UP_MARGIN = 10;
	private final static int BORDER_MARGIN = 50;
	private int score = 0;
	private int level = 1;
	private int multiplier = 0;
	
	public LoadNextGameBoard(){
		
	}
	
	@Override
	public void paintComponent(Graphics graphics){
		super.paintComponent(graphics);
		Graphics2D graphics2 = (Graphics2D) graphics;
		graphics2.setColor(Color.WHITE);
		Rectangle gameBoard = new Rectangle(LEFT_MARGIN,UP_MARGIN,NEXT_GAME_BOARD_WIDTH,NEXT_GAME_BOARD_LENGTH);
		graphics2.draw(gameBoard);
		setBackground(Color.black);
	}
	
	public Dimension getPreferredSize(){
		return new Dimension(BORDER_MARGIN,NEXT_GAME_BOARD_LENGTH+2+UP_MARGIN);
	}
	
}
