package burgertime;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * TODO Put here a description of what this class does.
 *
 * @author Pengdi.
 *         Created Feb 18, 2014.
 */
public class BurgerCollisionChecker implements Runnable{
	
	private ArrayList<Coordinate> fallingBurger;
	private ArrayList<ArrayList<Burger>> sortedBurgerComponent;
	private BurgerTime game;
	public BurgerCollisionChecker(ArrayList<Coordinate> fallingBurger, ArrayList<ArrayList<Burger>> sortedBurgerComponent, BurgerTime game){
		this.fallingBurger = fallingBurger;
		this.sortedBurgerComponent = sortedBurgerComponent;
		this.game = game;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub.
		Lock lock = new ReentrantLock();
		lock.lock();
		try{
			while(this.fallingBurger.size() > 0){
				
				
				for(int i=0; i<this.fallingBurger.size(); i++){
					int index = this.fallingBurger.get(i).getX()*4+this.fallingBurger.get(i).getY();
//					System.out.println(this.fallingBurger.size());
					ArrayList<Burger> temp = this.sortedBurgerComponent.get(index);
					if(!temp.get(0).getIsFalling()){
//						Coordinate removeCoordinate = new Coordinate(this.fallingBurger.get(i).getX(),this.fallingBurger.get(i).getY());
//						stopFalling(this.fallingBurger.get(i).getX(),this.fallingBurger.get(i).getY());
						//stopFalling(index/4,index%4);
						return;
						}
				}
				
				for(int i=0; i<this.fallingBurger.size(); i++){
					ArrayList<Burger> burgerUnder = new ArrayList<Burger>();
					ArrayList<Burger> burgerAbove = new ArrayList<Burger>();
					int column = this.fallingBurger.get(i).getX();
					int row = this.fallingBurger.get(i).getY();
					burgerAbove = this.sortedBurgerComponent.get(column*4+row);		
					burgerUnder = this.sortedBurgerComponent.get(column*4+row+1);
					if(!burgerUnder.get(0).isOnThePlate()){
						if(burgerAbove.get(0).getCoordinate().getY()+1 >= burgerUnder.get(0).getCoordinate().getY()){
							for(Burger temp: burgerUnder){
								System.out.println("setting is stepped to true");
								temp.isStepped = true;

							}
							
						}
					}

					if(burgerUnder.get(0).isOnThePlate()){
						if(burgerAbove.get(0).getCoordinate().getY()+1 >= burgerUnder.get(0).getCoordinate().getY()){
							for(Burger temp: burgerUnder){
								
							}
							
						}
					}
				}
				System.out.println();Thread.sleep(20);
			}
		
		}catch(Exception exception){
			exception.printStackTrace();
		}
		lock.unlock();
	}

	public void stopFalling(int column, int row){
//		System.out.println("Successful Stop");
		if(this.fallingBurger.size()>0)
		for(int i=0; i<this.fallingBurger.size();i++){
			if(this.fallingBurger.get(i).getX() == column && this.fallingBurger.get(i).getY() == row){
				this.fallingBurger.remove(i);
			}
		}
	}
	public boolean isBurgerBelowOnPlate(){
		return false;
		
	}
	

}
