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


		frame.add(newCompass);
		MyEventHandler handler =  new MyEventHandler();
		newCompass.addCompassEventListener(handler);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
