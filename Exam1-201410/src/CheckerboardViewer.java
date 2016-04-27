import javax.swing.JFrame;


public class CheckerboardViewer {

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
		frame.setTitle("Checkerboards!");
		
		frame.add(new CheckerboardComponent());
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
