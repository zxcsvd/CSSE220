package burgertime;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * TODO Put here a description of what this class does.
 *
 * @author Pengdi.
 *         Created Feb 6, 2014.
 */
public class StopListener implements KeyListener{
	private Movable movableComponent;
	
	public StopListener(Movable movableComponent){
		this.movableComponent = movableComponent;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyChar()=='p')
		{
			this.movableComponent.stop();
		}
		if (e.getKeyChar()=='r'){
			this.movableComponent.continueGame();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
