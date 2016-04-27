package burgertime;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;

/**
 * TODO Put here a description of what this class does.
 *
 * @author Pengdi.
 *         Created Feb 6, 2014.
 */
public class MoveListener implements KeyListener{
	private Movable movableComponent;
	private BurgerTime game;
	
	public MoveListener(Movable movableComponent, BurgerTime game){
		this.movableComponent = movableComponent;
		this.game = game;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		ArrayList<Ladder> ladders = this.game.getLevelInformation().getLadder();
		ArrayList<Floor> floors = this.game.getLevelInformation().getFloor();
		
		if(e.getKeyCode()==37 && this.movableComponent.checkLeftFloor(floors))
		{
			if(this.movableComponent.getPause()){
				this.movableComponent.move(-1, 0);
				this.game.detectBurgerStepped();
				this.game.burgerAllStepped();
			}
		}
		if(e.getKeyCode()==38 && this.movableComponent.checkUpLadder(ladders))
		{
			if(this.movableComponent.getPause()){
				this.movableComponent.move(0, -1);

			}
			
		}
		if(e.getKeyCode()==39 && this.movableComponent.checkRightFloor(floors))
		{
			if(this.movableComponent.getPause()){	
				this.movableComponent.move(1, 0);
				this.game.detectBurgerStepped();
				this.game.burgerAllStepped();

			}

		}
		if(e.getKeyCode()==40 && this.movableComponent.checkDownLadder(ladders))
		{
			if(this.movableComponent.getPause()){
				this.movableComponent.move(0, 1);

			}

		}
		
	}

	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
	}
	
}