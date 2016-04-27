package burgertime;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * TODO Put here a description of what this class does.
 *
 * @author Pengb.
 *         Created Feb 2, 2014.
 */
public class LevelLoader {
	private int lowFloor;
	private int level;
	private Scanner inScanner;
	private Level newLevel;
	private int lives;
	private int score;
	private int pepper;
	
	
	public LevelLoader(int level){
		this.level = level;
		String fileName = "Level"+level+".txt";
		this.inScanner = null;
		try{
			URL url = getClass().getResource(fileName);
			File levelInformation = new File(url.getPath());
			this.inScanner = new Scanner(levelInformation);
		}catch(Exception e){
			System.err.print("File Not Found!");
		}
	}
	
	public void loadGame(){
		
		this.newLevel = new Level(this.level);
		try {
			int counter = 0;
			int row = 0;
			int enemyIndex = 0;
			
			while (this.inScanner.hasNextInt()) {
				
				int currentInt = this.inScanner.nextInt();
				if(currentInt == -1){
					counter++;
				}
				else{
					if(counter == 1){
						loadFloor(this.inScanner, newLevel, this.lowFloor);
					}
					if(counter == 2){
						loadLadder(this.inScanner, newLevel);
					}
					if(counter == 3 ){
						loadHero(this.inScanner, newLevel);
					}
					if(counter == 4){
						loadEnemy(this.inScanner, enemyIndex, newLevel);
						enemyIndex++;
					}	
					if(counter >= 5 && counter <= 8 ){
						int column = counter - 5;

						loadBurgerAndPlates(this.inScanner, row % 4, column, newLevel);
						row++;
					}
				}

				
				
					
			}

		} catch (NullPointerException exception) {
			
			System.err.println("Invalid operation");
		}			
	}
	public void constructNewGame(){
		BurgerTime newGame = new BurgerTime(this.newLevel);
		
	}
	
	
	public void constructNewGame(Level levelInformation, int lives, int score, int pepper){
		BurgerTime newGame = new BurgerTime(this.newLevel, lives, score, pepper);
		
	}
	
	
	public void loadFloor(Scanner scan, Level level, int floor){
		Coordinate startPoint = new Coordinate(scan.nextInt(), scan.nextInt());
		int length = scan.nextInt();
		if(startPoint.getY()+1 > floor){
			this.lowFloor = startPoint.getY()+1;
		}
		for(int i=0; i<length; i++){
			Coordinate newPoint = new Coordinate(startPoint.getX()+i,startPoint.getY());
			level.addcomponent(new Floor(newPoint));
		}
	}
	
	public void loadLadder(Scanner scan, Level level){
		Coordinate startPoint = new Coordinate(scan.nextInt(), scan.nextInt());
		int length = scan.nextInt();
		for(int j=0; j<length; j++){
			
				Coordinate newPoint = new Coordinate(startPoint.getX(),startPoint.getY()+j);
				level.addcomponent(new Ladder(newPoint));	
			
		}
	}
	
	public void loadHero(Scanner scan, Level level){
		Coordinate startPoint = new Coordinate(scan.nextInt(), scan.nextInt());
		Movable player= new Hero(startPoint);
		level.addcomponent(player);
	}
	
	public void loadEnemy(Scanner scan, int enemyIndex, Level level){
		Coordinate startPoint = new Coordinate(scan.nextInt(), scan.nextInt());
		Movable enemy= new Enemy(startPoint, enemyIndex);
		level.addcomponent(enemy);
	}
	
	public void loadBurgerAndPlates(Scanner scan, int row, int column, Level level){
		Coordinate startPoint = new Coordinate(scan.nextInt(), scan.nextInt());
		int length = scan.nextInt();
		for(int i=0; i<length; i++){
			Coordinate newPoint = new Coordinate(startPoint.getX()+i,startPoint.getY());
			Movable burger = new Burger(newPoint, row, column);
			level.addcomponent(burger);
		}
		if(row == 3){
			for(int i=0; i<length; i++){
				Coordinate newPoint = new Coordinate(startPoint.getX() + i,this.lowFloor + 16);
				Plate plates = new Plate(newPoint);
				level.addcomponent(plates);
			}
		}
	
	}

	
}
