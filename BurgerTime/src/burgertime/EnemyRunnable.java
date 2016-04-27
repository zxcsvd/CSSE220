/**
 * 
 */
package burgertime;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * TODO Put here a description of what this class does.
 *
 * @author wangx3.
 *         Created Feb 19, 2014.
 */
public class EnemyRunnable implements Runnable{
//	private Enemy enemy;
	private Level levelInformation;
	private Enemy enemy;
	private ArrayList<Floor> floorList;
	private ArrayList<Ladder> ladderList;
	private Hero hero;
	private Lock lock;
	private int index;
	public EnemyRunnable(int index, Level levelInformation){
		this.levelInformation = levelInformation;
		
		this.floorList = this.levelInformation.getFloor();
		this.ladderList = this.levelInformation.getLadder();
		this.hero = this.levelInformation.getHero();
		this.lock = new ReentrantLock();
		this.index = index;
		this.enemy = this.levelInformation.getEnemy().get(this.index);
	}
	
	@Override
	public void run() {

		try{
			boolean breaker = true;
			while(breaker){
				
				

				
				
				int HeroX = this.hero.getCoordinate().getX();
				int HeroY = this.hero.getCoordinate().getY();
				int EnemyX = this.levelInformation.getEnemy().get(this.index).getCoordinate().getX();
				int EnemyY = this.levelInformation.getEnemy().get(this.index).getCoordinate().getY();
				
				if(EnemyX == HeroX && EnemyY == HeroY){
					ArrayList<Enemy> enemies = this.levelInformation.getEnemy();
					for(Enemy e: enemies){
						e.reBirth();
					}
//					breaker = false;
					break;
					
				}
				
////					System.out.print("1");
//					if(isClimbingLadder()){
//						moveTowardCurrent();
//					}
//					else if(isOnTopOfLadder()){
//						if(enemy.getFacing().equals("Right") || enemy.getFacing().equals("Left")){
//							moveDown();
//							
//						}
//						if(enemy.getFacing().equals("Up")){
//							
//						}
//					}
//					else if(isOnBottomLadder()){
//						if(enemy.getFacing().equals("Right") || enemy.getFacing().equals("Left")){
//							moveUp();
//						}
//						if(enemy.getFacing().equals("Down")){
//							setFacingX();
//							moveTowardCurrent();
//						}
//					}
//				
//				else if(isOnFloor()){
////					System.out.println("1");
////					enemy.setFacing("Right");
//					moveTowardCurrent();
//					System.out.println(enemy.getFacing());
//				}
//				else {
//					if(hasLadderAbove()){
//						moveUp();
////						breaker = false;
////						System.out.print("ww");
//					
//					}
//					else{
////						System.out.println("2");
//						dragToFloor();
//						moveTowardCurrent();
//						dragToFloor();
//					}
//
//				}
//				
				
				
				if(EnemyX == HeroX && EnemyY < HeroY){
					if(isNextToLadder()){
						if(isClimbingLadder()){
							if(this.enemy.getFacing().equals("Left")){
								moveLeft();
							}
							else if(this.enemy.getFacing().equals("Right")){
								moveRight();
							}
							else if(this.enemy.getFacing().equals("Up")){
								this.enemy.move(0, -1);
								this.enemy.setFacing("Up");
							}
							else if(this.enemy.getFacing().equals("Down")){
								this.enemy.move(0, 1);
								this.enemy.setFacing("Down");
							}
						}
						else if(isOnTopOfLadder()){
							if(this.enemy.getFacing().equals("Left")){
								this.enemy.move(0, 1);
								this.enemy.setFacing("Down");
							}
							else if(this.enemy.getFacing().equals("Right")){
								this.enemy.move(0, 1);
								this.enemy.setFacing("Down");
							}
							else if(this.enemy.getFacing().equals("Up")){
								moveLeft();
							}
//							else if(this.enemy.getFacing().equals("Down")){
//								this.enemy.move(0, 1);
//								this.enemy.setFacing("Down");
//							}
						}
						else if(isOnBottomLadder()){
							if(this.enemy.getFacing().equals("Left")){
								this.enemy.move(0, -1);
								this.enemy.setFacing("Up");
							}
							else if(this.enemy.getFacing().equals("Right")){
								this.enemy.move(0, -1);
								this.enemy.setFacing("Up");
							}
							else if(this.enemy.getFacing().equals("Down")){
								moveLeft();
							}
							else if(this.enemy.getFacing().equals("Up")){
								this.enemy.move(0, -1);
								this.enemy.setFacing("Up");
							}
						}
					}
					else if(isOnFloor()){
						if(this.enemy.getFacing().equals("Right")){
							moveRight();
						}
						else if(this.enemy.getFacing().equals("Left")){
							moveLeft();
						}
							
					}
				}
				if(EnemyX == HeroX && EnemyY > HeroY){
					
					if(isNextToLadder()){
						if(isClimbingLadder()){
							
							if(this.enemy.getFacing().equals("Left")){
								
								this.enemy.move(0,  -1);
								this.enemy.setFacing("Up");
							}
							else if(this.enemy.getFacing().equals("Right")){
								
								this.enemy.move(0, -1);
								this.enemy.setFacing("Up");
							}
							else if(this.enemy.getFacing().equals("Up")){
								
								this.enemy.move(0, -1);
								this.enemy.setFacing("Up");
							}
							else if(this.enemy.getFacing().equals("Down")){
								
								this.enemy.move(0, 1);
								this.enemy.setFacing("Down");
							}
						}
						else if(isOnTopOfLadder()){
							if(this.enemy.getFacing().equals("Left")){
								this.enemy.move(-1,0);
								this.enemy.setFacing("Left");
							}
							else if(this.enemy.getFacing().equals("Right")){
								this.enemy.move(1,0);
								this.enemy.setFacing("Right");
							}
							else if(this.enemy.getFacing().equals("Up")){
								moveRight();
							}
//							else if(this.enemy.getFacing().equals("Down")){
//								this.enemy.move(0, 1);
//								this.enemy.setFacing("Down");
//							}
						}
						else if(isOnBottomLadder()){
							
							if(this.enemy.getFacing().equals("Left")){
								moveLeft();
							}
							else if(this.enemy.getFacing().equals("Right")){
								moveRight();
							}
							else if(this.enemy.getFacing().equals("Down")){
								
								moveRight();
							}
//							else if(this.enemy.getFacing().equals("Down")){
//								this.enemy.move(0, 1);
//								this.enemy.setFacing("Down");
//							}
						}
					}
					else if(isOnFloor()){
						if(this.enemy.getFacing().equals("Right")){
							moveRight();
						}
						else if(this.enemy.getFacing().equals("Left")){
							moveLeft();
						}
							
					}
				}
				if(EnemyX < HeroX && EnemyY < HeroY){
					if(isNextToLadder()){
						if(isClimbingLadder()){
							if(this.enemy.getFacing().equals("Left")){
								this.enemy.move(0, 1);
								this.enemy.setFacing("Down");
							}
							else if(this.enemy.getFacing().equals("Right")){
								this.enemy.move(0, 1);
								this.enemy.setFacing("Down");
							}
							else if(this.enemy.getFacing().equals("Up")){
								this.enemy.move(0, -1);
								this.enemy.setFacing("Up");
							}
							else if(this.enemy.getFacing().equals("Down")){
								this.enemy.move(0, 1);
								this.enemy.setFacing("Down");
							}
						}
						else if(isOnTopOfLadder()){
							if(this.enemy.getFacing().equals("Left")){
								this.enemy.move(0, 1);
								this.enemy.setFacing("Down");
							}
							else if(this.enemy.getFacing().equals("Right")){
								this.enemy.move(0, 1);
								this.enemy.setFacing("Down");
							}
							else if(this.enemy.getFacing().equals("Up")){
								moveRight();
							}
//							else if(this.enemy.getFacing().equals("Down")){
//								this.enemy.move(0, 1);
//								this.enemy.setFacing("Down");
//							}
						}
						else if(isOnBottomLadder()){
							if(this.enemy.getFacing().equals("Left")){
								this.enemy.move(0, -1);
								this.enemy.setFacing("Up");
							}
							else if(this.enemy.getFacing().equals("Right")){
								this.enemy.move(0, -1);
								this.enemy.setFacing("Up");
							}
							else if(this.enemy.getFacing().equals("Down")){
								moveRight();
							}
//							else if(this.enemy.getFacing().equals("Down")){
//								this.enemy.move(0, 1);
//								this.enemy.setFacing("Down");
//							}
						}
					}
					else if(isOnFloor()){
						if(this.enemy.getFacing().equals("Right")){
							moveRight();
						}
						else if(this.enemy.getFacing().equals("Left")){
							moveLeft();
						}
							
					}
				}
				
				if(EnemyX < HeroX && EnemyY > HeroY){
//					System.out.print("Attention");
					if(isNextToLadder()){
						if(isClimbingLadder()){
//							System.out.println("Climbing");
							if(this.enemy.getFacing().equals("Left")){
//								System.out.println("L");
								moveLeft();
							}
							else if(this.enemy.getFacing().equals("Right")){
								moveRight();
							}
							else if(this.enemy.getFacing().equals("Up")){
//								System.out.println("U");
								
								this.enemy.move(0, -1);
								this.enemy.setFacing("Up");
							}
							else if(this.enemy.getFacing().equals("Down")){
//								System.out.println("D");
								if(detectValid());
								this.enemy.move(0, 1);
								this.enemy.setFacing("Down");
							}
						}
						else if(isOnTopOfLadder()){
							if(this.enemy.getFacing().equals("Left")){
								if(detectValid());
								this.enemy.move(0 ,1);
								this.enemy.setFacing("Down");
							}
							else if(this.enemy.getFacing().equals("Right")){
								if(detectValid());
								this.enemy.move(0, 1);
								this.enemy.setFacing("Down");
							}
							else if(this.enemy.getFacing().equals("Up")){
								moveRight();
							}
//							else if(this.enemy.getFacing().equals("Down")){
//								this.enemy.move(0, 1);
//								this.enemy.setFacing("Down");
//							}
						}
						else if(isOnBottomLadder()){
							
							if(this.enemy.getFacing().equals("Left")){
								this.enemy.move(0, -1);
								this.enemy.setFacing("Up");
							}
							else if(this.enemy.getFacing().equals("Right")){
								this.enemy.move(0, -1);
								this.enemy.setFacing("Up");
							}
							else if(this.enemy.getFacing().equals("Down")){
								
								moveRight();
							}
//							else if(this.enemy.getFacing().equals("Down")){
//								this.enemy.move(0, 1);
//								this.enemy.setFacing("Down");
//							}
						}
					}
					else if(isOnFloor()){
						if(this.enemy.getFacing().equals("Right")){
							moveRight();
						}
						else if(this.enemy.getFacing().equals("Left")){
							moveLeft();
						}
							
					}
				}
				if(EnemyX < HeroX && EnemyY == HeroY){
					if(isNextToLadder()){
						if(isClimbingLadder()){
							if(this.enemy.getFacing().equals("Left")){
								moveLeft();
							}
							else if(this.enemy.getFacing().equals("Right")){
								moveRight();
							}
							else if(this.enemy.getFacing().equals("Up")){
								this.enemy.move(0, -1);
								this.enemy.setFacing("Up");
							}
							else if(this.enemy.getFacing().equals("Down")){
								if(detectValid());
								this.enemy.move(0, 1);
								this.enemy.setFacing("Down");
							}
						}
						else if(isOnTopOfLadder()){
							if(this.enemy.getFacing().equals("Left")){
								this.enemy.move(0 ,1);
								this.enemy.setFacing("Down");
							}
							else if(this.enemy.getFacing().equals("Right")){
								this.enemy.move(0, 1);
								this.enemy.setFacing("Down");
							}
							else if(this.enemy.getFacing().equals("Up")){
								moveRight();
							}
//							else if(this.enemy.getFacing().equals("Down")){
//								this.enemy.move(0, 1);
//								this.enemy.setFacing("Down");
//							}
						}
						else if(isOnBottomLadder()){
							if(this.enemy.getFacing().equals("Left")){
								this.enemy.move(0, -1);
								this.enemy.setFacing("Up");
							}
							else if(this.enemy.getFacing().equals("Right")){
								this.enemy.move(0, -1);
								this.enemy.setFacing("Up");
							}
							else if(this.enemy.getFacing().equals("Down")){
								moveRight();
							}
							else if(this.enemy.getFacing().equals("Up")){
								moveRight();
							}
						}
					}
					else if(isOnFloor()){
						if(this.enemy.getFacing().equals("Right")){
							moveRight();
						}
						else if(this.enemy.getFacing().equals("Left")){
							moveLeft();
						}
							
					}
				}
				if(EnemyX > HeroX && EnemyY < HeroY){
					if(isNextToLadder()){
						if(isClimbingLadder()){
							if(this.enemy.getFacing().equals("Left")){
								moveLeft();
							}
							else if(this.enemy.getFacing().equals("Right")){
								moveRight();
							}
							else if(this.enemy.getFacing().equals("Up")){
								this.enemy.move(0, -1);
								this.enemy.setFacing("Up");
							}
							else if(this.enemy.getFacing().equals("Down")){
								this.enemy.move(0, 1);
								this.enemy.setFacing("Down");
							}
						}
						else if(isOnTopOfLadder()){
							if(this.enemy.getFacing().equals("Left")){
								moveLeft();
							}
							else if(this.enemy.getFacing().equals("Right")){
								moveRight();
							}
							else if(this.enemy.getFacing().equals("Up")){
								moveLeft();
							}
//							else if(this.enemy.getFacing().equals("Down")){
//								this.enemy.move(0, 1);
//								this.enemy.setFacing("Down");
//							}
						}
						else if(isOnBottomLadder()){
							if(this.enemy.getFacing().equals("Left")){
								this.enemy.move(0, -1 );
								this.enemy.setFacing("Up");
							}
							else if(this.enemy.getFacing().equals("Right")){
								this.enemy.move(0, -1 );
								this.enemy.setFacing("Up");
							}
							else if(this.enemy.getFacing().equals("Down")){
								moveLeft();
							}
							else if(this.enemy.getFacing().equals("Up")){
								this.enemy.move(0, -1);
								this.enemy.setFacing("Up");
							}
						}
					}
					else if(isOnFloor()){
						if(this.enemy.getFacing().equals("Right")){
							moveRight();
						}
						else if(this.enemy.getFacing().equals("Left")){
							moveLeft();
						}
							
					}
				}
				if(EnemyX > HeroX && EnemyY == HeroY){
					if(isNextToLadder()){
						if(isClimbingLadder()){
							if(this.enemy.getFacing().equals("Left")){
								moveLeft();
							}
							else if(this.enemy.getFacing().equals("Right")){
								moveRight();
							}
							else if(this.enemy.getFacing().equals("Up")){
								this.enemy.move(0, -1);
								this.enemy.setFacing("Up");
							}
							else if(this.enemy.getFacing().equals("Down")){
								this.enemy.move(0, 1);
								this.enemy.setFacing("Down");
							}
						}
						else if(isOnTopOfLadder()){
							if(this.enemy.getFacing().equals("Left")){
								this.enemy.move(-1, 0);
								this.enemy.setFacing("Left");
							}
							else if(this.enemy.getFacing().equals("Right")){
								this.enemy.move(1, 0);
								this.enemy.setFacing("Right");
							}
							else if(this.enemy.getFacing().equals("Up")){
								moveLeft();
							}
//							else if(this.enemy.getFacing().equals("Down")){
//								this.enemy.move(0, 1);
//								this.enemy.setFacing("Down");
//							}
						}
						else if(isOnBottomLadder()){
							if(this.enemy.getFacing().equals("Left")){
								this.enemy.move(0, -1);
								this.enemy.setFacing("Up");
							}
							else if(this.enemy.getFacing().equals("Right")){
								this.enemy.move(0, -1);
								this.enemy.setFacing("Up");
							}
							else if(this.enemy.getFacing().equals("Down")){
								moveLeft();
							}
							else if(this.enemy.getFacing().equals("Up")){
								this.enemy.move(0, -1);
								this.enemy.setFacing("Up");
							}
						}
					}
					else if(isOnFloor()){
						if(this.enemy.getFacing().equals("Right")){
							moveRight();
						}
						else if(this.enemy.getFacing().equals("Left")){
							moveLeft();
						}
							
					}
				}
				if(EnemyX > HeroX && EnemyY > HeroY){
					if(isNextToLadder()){
						if(isClimbingLadder()){
							if(this.enemy.getFacing().equals("Left")){
								this.enemy.move(0, -1);
								this.enemy.setFacing("Up");
							}
							else if(this.enemy.getFacing().equals("Right")){
								moveRight();
							}
							else if(this.enemy.getFacing().equals("Up")){
								this.enemy.move(0, -1);
								this.enemy.setFacing("Up");
							}
							else if(this.enemy.getFacing().equals("Down")){
								this.enemy.move(0, 1);
								this.enemy.setFacing("Down");
							}
						}
						else if(isOnTopOfLadder()){
							if(this.enemy.getFacing().equals("Left")){
								this.enemy.move(-1, 0);
								this.enemy.setFacing("Left");
							}
							else if(this.enemy.getFacing().equals("Right")){
								this.enemy.move(1, 0);
								this.enemy.setFacing("Right");
							}
							else if(this.enemy.getFacing().equals("Up")){
								
								moveLeft();
							}
							else if(this.enemy.getFacing().equals("Down")){
								this.enemy.move(0, 1);
								this.enemy.setFacing("Down");
							}
						}
						else if(isOnBottomLadder()){
							if(this.enemy.getFacing().equals("Left")){
								this.enemy.move(0, -1);
								this.enemy.setFacing("Up");
							}
							else if(this.enemy.getFacing().equals("Right")){
								this.enemy.move(0, -1);
								this.enemy.setFacing("Up");
							}
							else if(this.enemy.getFacing().equals("Down")){
								if(detectValid())
								moveLeft();
							}
							else if(this.enemy.getFacing().equals("Up")){
								this.enemy.move(0, -1);
								this.enemy.setFacing("Up");
							}
						}
					}
					else if(isOnFloor()){
						if(this.enemy.getFacing().equals("Right")){
							moveRight();
						}
						else if(this.enemy.getFacing().equals("Left")){
							moveLeft();
						}
							
					}
				}

				
				
				Thread.sleep(200);
				
			}
	
			
			}catch(InterruptedException e){}

	}
	public boolean hasLadderAbove(){
		for(int j=0; j< this.ladderList.size(); j++){
			if(this.ladderList.get(j).getCoordinate().getX() == this.enemy.getCoordinate().getX()){
				if(this.ladderList.get(j).getCoordinate().getY() == this.enemy.getCoordinate().getY()-1){
					return true;
				}										
			}
		}
		return false;
	}
	
	public boolean hasLadderCurrent(){
		for(int j=0; j< this.ladderList.size(); j++){
			if(this.ladderList.get(j).getCoordinate().getX() == this.enemy.getCoordinate().getX()){
				if(this.ladderList.get(j).getCoordinate().getY() == this.enemy.getCoordinate().getY()){
					return true;
				}										
			}
		}
		return false;
	}
	
	public boolean hasLadderBelow(){
		for(int j=0; j< this.ladderList.size(); j++){
			if(this.ladderList.get(j).getCoordinate().getX() == this.enemy.getCoordinate().getX()){
				if(this.ladderList.get(j).getCoordinate().getY() == this.enemy.getCoordinate().getY()+1){
					return true;
				}										
			}
		}
		return false;
	}
	
	public boolean hasFloorRight(){
		for(int j=0; j< this.floorList.size(); j++){
			if(this.floorList.get(j).getCoordinate().getX() == this.enemy.getCoordinate().getX()+1){
				if(this.floorList.get(j).getCoordinate().getY() == this.enemy.getCoordinate().getY()+1){
					return true;
				}										
			}
		}
		return false;
	}
	
	public boolean isFloorCurrent(){
		for(int j=0; j< this.floorList.size(); j++){
			if(this.floorList.get(j).getCoordinate().getX() == this.enemy.getCoordinate().getX()){
				if(this.floorList.get(j).getCoordinate().getY() == this.enemy.getCoordinate().getY()+1){
					return true;
				}										
			}
		}
		return false;
	}
	
	public boolean hasFloorLeft(){
		for(int j=0; j< this.floorList.size(); j++){
			if(this.floorList.get(j).getCoordinate().getX() == this.enemy.getCoordinate().getX()-1){
				if(this.floorList.get(j).getCoordinate().getY() == this.enemy.getCoordinate().getY()+1){
					return true;
				}										
			}
		}
		return false;
	}
	public void moveTowardCurrent(){
		String direction = this.enemy.getFacing();
			if(direction.equals("Left")){
				moveLeft();
				return;
			}
			if(direction.equals("Right")){
				moveRight();
				return;
			}
			if(direction.equals("Down")){
				moveDown();
				return;
			}
			if(direction.equals("Up")){
				moveUp();
				return;
			}
	
	}
	
	public boolean isNextToLadder(){
		return (hasLadderCurrent() || hasLadderBelow());
	}
	
	public boolean isClimbingLadder(){
		return (hasLadderCurrent() && hasLadderBelow());
	}
	public boolean isOnTopOfLadder(){
		return(hasLadderCurrent() == false && hasLadderBelow() == true && hasLadderAbove() == false);
	}
	public boolean isOnBottomLadder(){
		return (hasLadderCurrent() == true && hasLadderBelow() == false);
	}
	public boolean isOnFloor(){
		return (isFloorCurrent());
	}
	public void moveRight(){
		if(hasFloorRight()){
			this.enemy.move(1, 0);
			this.enemy.setFacing("Right");
		}
		else{
			moveLeft();
		}
	}
	public void moveLeft(){
		if(hasFloorLeft()){
			this.enemy.move(-1, 0);
			this.enemy.setFacing("Left");
		}
		else{
			moveRight();
		}
	}
	
	public void moveUp(){
		
		this.enemy.move(0, -1);
		this.enemy.setFacing("Up");
	}
	public void moveDown(){
		this.enemy.move(0, 1);
		this.enemy.setFacing("Down");
		System.out.println("XXX");
	}

	
	public boolean detectValid(){
		return (!(hasFloorRight() || hasFloorLeft() || isFloorCurrent()));
	}
	public void dragToFloor(){
		int deltaX =(this.floorList.get(0).getCoordinate().getX()-enemy.getCoordinate().getX());
		int deltaY = (this.floorList.get(0).getCoordinate().getY()-enemy.getCoordinate().getY());
		double distance = Math.sqrt(deltaX*deltaX + deltaY*deltaY);
		int counter = 0;
		for(int i=0; i<this.floorList.size(); i++){
			int tempX = (this.floorList.get(i).getCoordinate().getX()-enemy.getCoordinate().getX());
			int tempY = (this.floorList.get(i).getCoordinate().getY()-enemy.getCoordinate().getY());
			if (Math.sqrt(tempX*tempX + tempY*tempY)<distance){
				distance = Math.sqrt(deltaX*tempX + tempY*tempY);
				counter = i;
			}
		}
		
		//this.enemy.setCoordinate(this.floorList.get(counter).getCoordinate().getX(), this.floorList.get(counter).getCoordinate().getY()-1);
		this.enemy.setFacing("Up");
	}
	public String setFacingX(){
		
		int HeroX = this.hero.getCoordinate().getX();
		int HeroY = this.hero.getCoordinate().getY();
		int EnemyX = this.levelInformation.getEnemy().get(this.index).getCoordinate().getX();
		int EnemyY = this.levelInformation.getEnemy().get(this.index).getCoordinate().getY();
		if(EnemyX < HeroX){
			this.enemy.setFacing("Right");
			return "Right";
		}
		else{
			this.enemy.setFacing("Left");
			return "Left";
		}
	}
	
	
}
