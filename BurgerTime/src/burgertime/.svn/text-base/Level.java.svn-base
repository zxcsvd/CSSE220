package burgertime;

import java.util.ArrayList;

/**
 * TODO Put here a description of what this class does.
 *
 * @author Pengb.
 *         Created Feb 2, 2014.
 */

public class Level{
	private ArrayList<Drawable> components;
	private int level;
	private boolean isModified;
	
	
	
	public Level(int numberOfLevel){
		this.components = new ArrayList<Drawable>();
		this.level = numberOfLevel;
		
	}
	public void addcomponent(Drawable component){
		this.components.add(component);

	}
	
	public int getFrameHeight(){
		int max = 0;
		for(Drawable temp: this.components){
			if(temp.getCoordinate().getY() > max){
				max = temp.getCoordinate().getY();
			}
		}
		return max+20;
	}
	
	public int getFrameWidth(){
		int max = 0;
		for(Drawable temp: this.components){
			
			if(temp.getCoordinate().getX() > max){
				max = temp.getCoordinate().getX();
			}
		}
		if(!this.isModified){
			return max+21;
		}
		return max+11;
	}
	public int getLevel(){
		return this.level;	
	}
	
	public ArrayList<Drawable> getComponents(){
		return this.components;
	}
	
	public Hero getHero(){
		for(Drawable temp: this.components){
			if (temp.getClass().equals(Hero.class)){
				return (Hero) temp;
			}
		}
		return null;

	}
	
	public ArrayList<Ladder> getLadder(){
		ArrayList<Ladder> tempList = new ArrayList<Ladder>();
		for(Drawable temp: this.components){
			if(temp.getClass().equals(Ladder.class)){
				tempList.add((Ladder) temp);
			}
		}
		return tempList;
	}
	
	public ArrayList<Floor> getFloor(){
		ArrayList<Floor> tempList = new ArrayList<Floor>();
		for(Drawable temp: this.components){
			if(temp.getClass().equals(Floor.class)){
				tempList.add((Floor) temp);
			}
		}
		return tempList;
	}
	
	public ArrayList<Enemy> getEnemy(){
		ArrayList<Enemy> tempList = new ArrayList<Enemy>();
		for(Drawable temp: this.components){
			if(temp.getClass().equals(Enemy.class)){
				tempList.add((Enemy) temp);
			}
		}
		return tempList;
	}
	public ArrayList<Plate> getPlate(){
		ArrayList<Plate> tempList = new ArrayList<Plate>();
		for(Drawable temp: this.components){
			if(temp.getClass().equals(Plate.class)){
				tempList.add((Plate) temp);
			}
		}
		return tempList;
	}
	
	public ArrayList<Burger> getBurger(){
		ArrayList<Burger> tempList = new ArrayList<Burger>();
		for(Drawable temp: this.components){
			if(temp.getClass().equals(Burger.class)){
				tempList.add((Burger) temp);
			}
		}
		return tempList;
	}
	
	public void modifySelected(Drawable newVersion){
		
		if(newVersion.getClass().equals(Enemy.class)){
			for(int i=0; i< this.components.size(); i++){
				if(this.components.get(i).getClass().equals(Enemy.class)){
					Enemy temp = (Enemy) this.components.get(i);
					if(temp.getIndex() == ((Enemy) newVersion).getIndex()){
						this.components.remove(this.components.get(i));
						this.components.add(newVersion);
						return;
					}
				}
			}
		}
		if(newVersion.getClass().equals(Burger.class)){
			for(int i=0; i< this.components.size(); i++){
				if(this.components.get(i).getClass().equals(Burger.class)){
					Burger temp = (Burger)this.components.get(i);
					if(temp.getRow() == ((Burger)newVersion).getRow() && temp.getColumn() == ((Burger)newVersion).getColumn()){
						this.components.remove(this.components.get(i));
						this.components.add(newVersion);
						return;
					}

				}
				
			}
		}
		if(newVersion.getClass().equals(Hero.class)){
			for(int i=0; i< this.components.size(); i++){
				if(this.components.get(i).getClass().equals(Hero.class)){
					this.components.remove(this.components.get(i));
					this.components.add(newVersion);
					return;
				}
				
			}
		}		
	}
	
	public void setLevel(int level){
		this.level = level;
	}
	
	public void deletComponent(Drawable component){
		this.components.remove(component);
	}
}
