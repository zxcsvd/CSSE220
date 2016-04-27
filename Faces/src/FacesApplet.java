import java.awt.Dimension;

import javax.swing.JApplet;

/**
 * A FacesApplet displays Face objects via a FacesComponent. You can run it from
 * <a href="../bin/Faces.htm">this simple web page</a>.
 * 
 * @author David Mutchler. Created December 9, 2009.
 */
public class FacesApplet extends JApplet {
	/**
	 * Initial size of the window that displays the Faces.
	 */
	public static final Dimension FACE_VIEWER_SIZE = new Dimension(500, 400);

	/**
	 * Displays Face objects via a FacesComponent.
	 */
	@Override
	public void init() {
		super.init();

		this.setSize(FacesApplet.FACE_VIEWER_SIZE);
		// TODO: uncomment the following line if you choose to do Stage 7
		 this.add(new FacesComponent());
	}
}
