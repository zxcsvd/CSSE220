/**
 * 
 */
package burgertime;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.TimerTask;




/**
 * TODO Put here a description of what this class does.
 *
 * @author wangx3.
 *         Created Feb 14, 2014.
 */
public class PepperListener implements KeyListener{
	private Level levelInformation;
	private PepperStatus pepper;
	private BurgerTime game;
	
	public PepperListener(Level levelInformation, BurgerTime game){
		this.levelInformation = levelInformation; 
		this.game = game;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==32){
			
			if(this.levelInformation.getHero().getNumOfPepper()>0){
				this.levelInformation.getHero().putPepper();
				this.game.changePepper();
			
				this.pepper = new PepperStatus(this.levelInformation.getHero());
				this.levelInformation.addcomponent(this.pepper);
			
				Timer timer=new Timer();
				timer.schedule(new TimerTask() {

				@Override
				public void run() {
					PepperListener.this.levelInformation.getHero().deletePepper();
					PepperListener.this.levelInformation.deletComponent(PepperListener.this.pepper);
				}
				
			}, 2000);
			
			
			}
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