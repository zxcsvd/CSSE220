/**
 * 
 */
package burgertime;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/**
 * TODO Put here a description of what this class does.
 *
 * @author wangx3.
 *         Created Feb 19, 2014.
 */
public class HeroBeKilledRunnable implements Runnable{
	 
	private ArrayList<Enemy> enemies;
	private Hero hero;
	private BurgerTime game;
	private ArrayList<ArrayList<Burger>> burgerList;
	
	public HeroBeKilledRunnable(ArrayList<Enemy> enemies, Hero hero, BurgerTime game){
		this.enemies = enemies;
		this.hero = hero;
		this.game =game;
		this.burgerList = this.game.getSortedBurgerComponent();
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try{
			while(true){
			for(int i=0; i< this.enemies.size(); i++){
				if(!this.hero.getProtectedStatus() && 
				Math.abs(this.hero.getCoordinate().getY() - this.enemies.get(i).getCoordinate().getY())<=8
				&&Math.abs(this.hero.getCoordinate().getX()-this.enemies.get(i).getCoordinate().getX())<=4){
					this.hero.die();
					this.game.setLives();
					for(int j=0; j< this.game.getLevelInformation().getEnemy().size(); j++){
						this.game.getLevelInformation().getEnemy().get(j).die();
					}
					Thread.sleep(2000);
					this.hero.reBirth();
					for(int j=0; j< this.game.getLevelInformation().getEnemy().size(); j++){
						this.game.getLevelInformation().getEnemy().get(j).reBirth();
					}	
				}
				for(int k=0; k<burgerList.size();k++){
					if(burgerList.get(k).get(0).getIsFalling()){
						if(enemies.get(i).getCoordinate().getX() >= burgerList.get(k).get(0).getCoordinate().getX()){
							if(enemies.get(i).getCoordinate().getX() <= burgerList.get(k).get(0).getCoordinate().getX() +16){
								if(enemies.get(i).getCoordinate().getY() <= burgerList.get(k).get(0).getCoordinate().getY() + 6){
									if(enemies.get(i).getCoordinate().getY() >= burgerList.get(k).get(0).getCoordinate().getY()){
										enemies.get(i).die();
										this.game.addScore(1000);
										Thread.sleep(2000);
										enemies.get(i).reBirth();
									}
								}
							}
						}
					}
				}
			
			}
			
			
			
			
			}
		}
		catch(InterruptedException e){}
	}

}
