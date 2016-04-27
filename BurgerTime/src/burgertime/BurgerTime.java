package burgertime;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * TODO Put here a description of what this class does.
 *
 * @author Pengb.
 *         Created Feb 5, 2014.
 */
public class BurgerTime {
	private int score = 0;
	private int lives = 5;
	private Level levelInformation;
	public static final int PIXEL_MULTIPLIER = 5;
	private int level;
	private ArrayList<ArrayList<Burger>> sortedBurgerComponent = new ArrayList<ArrayList<Burger>>();
	private JLabel lifeLable;
	private JLabel scoreLable;
	private JFrame gameFrame;
	private JLabel pepperLable;
	private ArrayList<Coordinate> fallingBurger = new ArrayList<Coordinate>();
	private int pepper = 3;
	public static final int FRAMES_PER_SECOND = 30;
	public static final int REPAINT_INTERVAL_MS = 1000/FRAMES_PER_SECOND;
//	private ArrayList<Drawable> components;
	

	public BurgerTime(Level levelInformation){
		this.levelInformation = levelInformation;
		graphicInitialize();
	}
	
	public BurgerTime(Level levelInformation, int lives, int score, int pepper){
		this.levelInformation = levelInformation;
		this.score = score;
		this.pepper = pepper;
		this.lives = lives;
		graphicInitialize();

	}
	
	
	
	public void graphicInitialize(){
		
		this.level = this.levelInformation.getLevel();
		sortBurgerComponent();
		int windowWidth = this.levelInformation.getFrameWidth()*PIXEL_MULTIPLIER;
		int windowHeight = this.levelInformation.getFrameHeight()*PIXEL_MULTIPLIER;
	
		this.gameFrame = new JFrame("BurgerTime Start!  " + "Level:" + this.level);
		this.gameFrame.setSize(windowWidth, windowHeight);
		this.lifeLable = new JLabel();
		this.lifeLable.setText("Lives: " + this.lives);
		this.lifeLable.setForeground(Color.RED);
		this.lifeLable.setFont(new Font(this.lifeLable.getName(),Font.BOLD,15));
		this.scoreLable = new JLabel();
		this.scoreLable.setText("Score: " + this.score);
		this.scoreLable.setForeground(Color.ORANGE);
		this.scoreLable.setFont(new Font(this.lifeLable.getName(),Font.BOLD,15));
		this.pepperLable = new JLabel();
		this.pepperLable.setText("Pepper: " + this.pepper);
		this.pepperLable.setForeground(Color.GREEN);
		this.pepperLable.setFont(new Font(this.pepperLable.getName(),Font.BOLD,15));
		
		JPanel panel = new JPanel();
		panel.add(this.lifeLable,BorderLayout.WEST);
		panel.add(this.scoreLable,BorderLayout.SOUTH);
		panel.add(this.pepperLable,BorderLayout.SOUTH);
		this.gameFrame.add(panel, BorderLayout.SOUTH);
		
		BurgerComponent drawing = new BurgerComponent(this.levelInformation);
		drawing.setFocusable(true);
		Hero currentHero = this.levelInformation.getHero();
		drawing.addKeyListener(new MoveListener(currentHero, this));
		drawing.addKeyListener(new StopListener(currentHero));
		drawing.addKeyListener(new PepperListener(this.levelInformation, this));
		this.gameFrame.add(drawing);
		
		ArrayList<Enemy> currentEnemis = this.levelInformation.getEnemy();
		for(int i=0;i<currentEnemis.size();i++){
			drawing.addKeyListener(new StopListener(currentEnemis.get(i)));
			enemyRun();
		}
		Runnable r1 = new HeroBeKilledRunnable(currentEnemis, this.levelInformation.getHero(),this);
		Thread t1 = new Thread(r1);
		t1.start();
		
		this.gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.gameFrame.setVisible(true);
		drawing.addKeyListener(new ChangeLevelListener(this, this.gameFrame));
		enemyRun();
		
	}
	
	
	
	@SuppressWarnings("javadoc")
	public void burgerFalling(ArrayList<Burger> burger, int index){
		for(int i=0; i<burger.size(); i++){
			
			burger.get(i).setIsFalling(true);
		}
		
		if(burger.get(0).isStepped()){
			ArrayList<Floor> floor = this.levelInformation.getFloor();
			Runnable r = new BurgerFallingComponent(burger, index, this);
			Thread t = new Thread(r);
			if(burger.get(0).isStepped() && burger.get(0).getIsFalling()){
				t.start();
				checkFallingParts();
			}	
			
		}
	}
	
	public void enemyRun(){
		for(int i=0; i< this.levelInformation.getEnemy().size(); i++){
			Runnable r = new EnemyRunnable(i,this.levelInformation);
			Thread t = new Thread(r);
			t.start();
		}
	}
	
	public void sortBurgerComponent(){
		ArrayList<Burger> burger = this.levelInformation.getBurger();
		for(int column =0; column < 4; column++){
			for (int row = 0; row < 4; row++){
				ArrayList<Burger> tempList = new ArrayList<Burger>();
				
				for(Burger temp:burger){
					if(temp.getRow() == row && temp.getColumn() == column){
						tempList.add(temp);
					}
				}
				this.sortedBurgerComponent.add(tempList);
			}
		}
		
	}
	
	
	
	public ArrayList<Burger> getSpecifiedBurgerList(int row, int column){
		return this.sortedBurgerComponent.get(column*4+row);
	}
	
	
	public void checkFallingParts(){

		Runnable r = new BurgerCollisionChecker(this.fallingBurger, this.sortedBurgerComponent, this);
		Thread t = new Thread(r);
		t.start();
		
		burgerAllStepped();
	}
	
	
	public void burgerAllStepped(){
		ArrayList<Burger> temp = new ArrayList<Burger>();
			for(int i=0; i<this.sortedBurgerComponent.size(); i++){
				temp = this.sortedBurgerComponent.get(i);
				Boolean hasFalse = false;
				int index = 0;
				
				while(!hasFalse && index < temp.size()){
					hasFalse = !temp.get(index).isStepped;
					if(!hasFalse)index++;
				}
				
				if(index == temp.size() && !temp.get(0).getIsFalling()){
					this.addScore(500);
					burgerFalling(temp, i);
					
					
				}
			}
	}
	
	public ArrayList<ArrayList<Burger>> getSortedBurgerComponent(){
		return this.sortedBurgerComponent;
	}
	
	public boolean detectBurgerStepped(){
		Hero hero = this.levelInformation.getHero();
		ArrayList<Burger> burgerList = this.levelInformation.getBurger();
		
			for(int i=0; i<burgerList.size(); i++){
				for(int j=0; j<4; j++){
					if(hero.getCoordinate().getX()+j == burgerList.get(i).getCoordinate().getX() && hero.getCoordinate().getY()==burgerList.get(i).getCoordinate().getY()){
						this.addScore(10);
//						if(!burgerList.get(i).isStepped()){
							burgerList.get(i).stepped();
							return false;
//					}
					}
				}

			}
		
		return true;
		
	}
	
	public void detectDie(){
		ArrayList<Enemy> enemyList = this.levelInformation.getEnemy();
		ArrayList<Burger> burgerList = this.levelInformation.getBurger(); 
		Hero hero = this.levelInformation.getHero();
		
		for(int i=0; i<enemyList.size(); i++){
			if((Math.abs(hero.getCoordinate().getX() - enemyList.get(i).getCoordinate().getX()) <  4) && (Math.abs(hero.getCoordinate().getY() - enemyList.get(i).getCoordinate().getY()) <  8)){
				Enemy enemy = enemyList.get(i);
				hero.die();
				enemy.die();
				System.out.print("Hero die");
				return;
			}
		}
		
		for(int i=0; i<enemyList.size(); i++){
			for(int j=0; j<burgerList.size(); j++){
				Enemy enemy = enemyList.get(i);
				Burger burger = burgerList.get(j);
				if(burgerList.get(j).getIsFalling()){
					if(enemy.getCoordinate().getX() == burger.getCoordinate().getX() && enemy.getCoordinate().getY() == burger.getCoordinate().getY()){
						enemy.die();
						System.out.print("Enemy die");
						return;
					}
				}
			}
		}
		
	}
	
	
	public void addScore(int scoreToAdd){
		this.score = this.score + scoreToAdd;
		this.scoreLable.setText("Score: " + (this.score));
	}
	
//	public void minusLife(){
//		String temp = this.lifeLable.getText();
//		int num = Integer.parseInt(temp.substring(temp.length()-1, temp.length()));
//		if(num -1 >=0){
////			System.out.print("ssss");
//			this.lifeLable.setText("Lives: " + (num - 1));
//		}
//		else{
//			this.gameFrame.setVisible(false);
//			System.out.println("You Lose Game Over");
//		}
//	}
	
	public void changePepper(){
		this.pepper = this.levelInformation.getHero().getNumOfPepper();
		this.pepperLable.setText("Peppers " + (this.pepper));
	}
	
	public int getLevel(){
		return this.level;
	}
	
	public int getScore(){
		return this.score;
	}
	
	public int getLives(){
		return this.lives;
	}
	
	public Level getLevelInformation(){
		return this.levelInformation;
	}
	
	public boolean detectRight(Movable element){
		for(int i=0; i<this.levelInformation.getFloor().size();i++){
			Floor temp = this.levelInformation.getFloor().get(i);
			if(element.getCoordinate().getX() + 4 <= temp.getCoordinate().getX() && element.getCoordinate().getY()+1==temp.getCoordinate().getY()){
//				System.out.println(element.getCoordinate().getX() + 4 + " "+ element.getCoordinate().getY()+1);
				
				return true;
			}
				
		}
		return false;
		
	}
	public boolean detectLeft(Movable element){
		for(int i=0; i<this.levelInformation.getFloor().size();i++){
			Floor temp = this.levelInformation.getFloor().get(i);
			if(element.getCoordinate().getX() > temp.getCoordinate().getX() && element.getCoordinate().getY()+1==temp.getCoordinate().getY()){
//				System.out.println(element.getCoordinate().getX() + 4 + " "+ element.getCoordinate().getY()+1);
				
				return true;
			}
				
		}
		return false;
		
	}
	public boolean detectUp(Movable element){
		for(int i=0; i<this.levelInformation.getLadder().size();i++){
			Ladder temp = this.levelInformation.getLadder().get(i);
			if(element.getCoordinate().getX() >= temp.getCoordinate().getX() -2 && element.getCoordinate().getX()+4 <= temp.getCoordinate().getX() +2 && element.getCoordinate().getY()==temp.getCoordinate().getY()){
//				System.out.println(element.getCoordinate().getX() + 4 + " "+ element.getCoordinate().getY()+1);
				
				return true;
			}
				
		}
		return false;
	}
	
	public boolean detectDown(Movable element){
		for(int i=0; i<this.levelInformation.getLadder().size();i++){
			Ladder temp = this.levelInformation.getLadder().get(i);
			if(element.getCoordinate().getX() >= temp.getCoordinate().getX() -2 && element.getCoordinate().getX()+4 <= temp.getCoordinate().getX() +2 && element.getCoordinate().getY()+1==temp.getCoordinate().getY()){
//				System.out.println(element.getCoordinate().getX() + 4 + " "+ element.getCoordinate().getY()+1);
				
				return true;
			}
				
		}
		return false;
	}
	
	public ArrayList<Coordinate> getFallingBurger(){
		return this.fallingBurger;
	}
	
	public void detectWin(){
		int win = 1;
		for(int i =0; i<this.getSortedBurgerComponent().size(); i++){
			
			if (!this.getSortedBurgerComponent().get(i).get(0).isOnThePlate()){
				win = 0;
			}
			
		}
		if(win == 1){
			LevelLoader loader = new LevelLoader(this.level + 1);
			loader.loadGame();
			loader.constructNewGame(this.levelInformation,this.lives,this.score,this.pepper);
			this.gameFrame.setVisible(false);
		}
	}
	
	public void setLives(){
		this.lives=this.levelInformation.getHero().getLives();
		if(this.lives>=0){
			this.lifeLable.setText("Lives: " + this.lives);
		}
		else{
			this.gameFrame.setVisible(false);
			gameOver();
			this.gameFrame.dispose();
		}
	}
	
	public void gameOver(){
		JFrame mainMenu = new JFrame();
		mainMenu.setTitle("BurgerTime");
		JPanel buttonPanel= new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
		mainMenu.setSize(200,100);

		
		JLabel newGame = new JLabel("Game Over!");
		JLabel exit = new JLabel("Your score is: " + this.score);		
		buttonPanel.add(newGame);
		buttonPanel.add(exit);


		mainMenu.add(buttonPanel);
		mainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainMenu.setVisible(true);
	}
}
