
/**
 * TODO Put here a description of what this class does.
 *
 * @author Pengdi.
 *         Created Jan 28, 2014.
 */
public class Pirate extends Robot  implements Shouter{

	public Pirate(double b){
		super();
	}
	
	public Pirate(){
		super();
		this.q = super.q + 2;
	}
	
	@Override
	public void shout() {
		System.out.println("Pirate");
	}
		
	public void money(){
		System.out.println("Show me your money!" + q + noWay());
	}
}
