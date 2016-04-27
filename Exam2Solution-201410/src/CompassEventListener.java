import java.awt.event.MouseEvent;


public interface CompassEventListener {

	public void northClicked(MouseEvent e);
	public void southClicked(MouseEvent e);
	public void eastClicked(MouseEvent e);
	public void westClicked(MouseEvent e);
}
