import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JComponent;
import javax.swing.JPanel;


/**
 * TODO Put here a description of what this class does.
 *
 * @author Pengdi.
 *         Created Mar 6, 2014.
 */
public class LoadGameBoard extends JComponent{
	
	private static int GAME_BOARD_WIDTH = 360 ;
	private static int GAME_BOARD_LENGTH = 600;
	private final static  int LEFT_MARGIN = 60;
	private final static int UP_MARGIN = 60;
	private final static int BORDER_MARGIN = 40;
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.WHITE);
		Rectangle gameBoard = new Rectangle(LEFT_MARGIN,UP_MARGIN,GAME_BOARD_WIDTH,GAME_BOARD_LENGTH);
		g2.draw(gameBoard);
	}
}
