
/**
 * TODO Put here a description of what this class does.
 *
 * @author Pengdi.
 *         Created Jan 28, 2014.
 */


public class Robot extends AbstractAttribute implements Shouter{
	public int q = 9;
	private int a;
	
	public Robot(){
		this.q += 1;
	}
	
	public Robot(int a){
		this.a = a;
	}
	
	public void Kill(){
		System.out.println("HAHA KILL");
	}

	public void shout() {
		System.out.println("Robot" + q);
	}
;
	public String noWay(){
		return "NoWay!";
	}
	@Override
	public void killPeople() {
		System.out.println("Robot never kill!" + noWay());
		
	}
}
