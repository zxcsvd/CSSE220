package burgertime;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileNotFoundException;

import javax.swing.JFrame;

/**
 * TODO Put here a description of what this class does.
 *
 * @author Pengdi.
 *         Created Feb 16, 2014.
 */
public class ChangeLevelListener implements KeyListener{
	
	private int currentLevel;
	private JFrame frame;
	private BurgerTime game;
	public ChangeLevelListener(BurgerTime game, JFrame frame){
		this.currentLevel = game.getLevel();
		this.frame = frame;
		this.game = game;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyChar() == 'u'& this.currentLevel<2){
			try{
				LevelLoader loader = new LevelLoader(this.currentLevel + 1);
				loader.loadGame();
				loader.constructNewGame();
				this.frame.setVisible(false);
				
			}
			catch(NullPointerException excaption){
				System.out.println("Don't have such file");
			}


		}
		if(e.getKeyChar() == 'd' && this.currentLevel>0){
			try{
				LevelLoader loader = new LevelLoader(this.currentLevel - 1);
				loader.loadGame();
				loader.constructNewGame();;
				this.frame.setVisible(false);
			}catch(NullPointerException excaption){
				System.err.println("Don't have such file");
			}

		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub.
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub.
		
	}

}
