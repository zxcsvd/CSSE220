package spaceships;

/**
 * TODO Put here a description of what this class does.
 *
 * @author Pengdi.
 *         Created Feb 27, 2014.
 */
public class MoveRunnable implements Runnable{

	private MovingSpaceship ship;
	private int x;
	private int y;
	private int deltaX; 
	private	int deltaY;
	public MoveRunnable(MovingSpaceship ship, int x, int y){
		this.ship = ship;
		this.x =x;
		this.y =y;
		this.deltaX = -(ship.getX() - this.x)/20;
		this.deltaY=-(ship.getY() - this.y)/20;
	}
	
	public void run() {


		try {
			while (ship.getX() < x || ship.getY() < y) {
				ship.reset(deltaX, deltaY);
				System.out.println(ship.getX()+ " "+ ship.getY());
			}
			Thread.sleep(100);
		} catch (InterruptedException exception) {
			// TODO Auto-generated catch-block stub.
			exception.printStackTrace();
		}
	}

}
