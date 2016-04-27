import javax.swing.JFrame;


public class CompassViewer {

	/**
	 * The width of the frame.
	 */
	public static final int WIDTH = 800;
	/**
	 * The height of the frame.
	 */
	public static final int HEIGHT = 600;

	/**
	 * Starts the Polygon viewer.
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		
		frame.setSize(WIDTH, HEIGHT);
		frame.setTitle("Choose a direction (N, S, E, W)");
		CompassComponent newCompass = new CompassComponent();
		
		// TODO: You'll need to add a small amount of code here to
		// to register your event handler with the CompassComponent.
		
		// For full credit, don't put the code that actually prints
		// "You Pressed North" in this class (either as an inner class
		// or as an anonymous inner class).  Instead, put that code
		// in MyEventHanlder and just register your MyEventHanlder
		// with newCompress here.
		newCompass.addCompassEventListener(new MyEventHandler());
		frame.add(newCompass);
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
