import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import javax.swing.JComponent;

public class CheckerboardComponent extends JComponent {

	@Override
	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;
		drawExample1(g2);
		//drawExample2(g2);
		//drawExample3(g2);

	}
	
	public void drawExample1(Graphics2D g2) {
		Checkerboard board = new Checkerboard(10, 10);
		board.drawOn(g2);
	}
	
	public void drawExample2(Graphics2D g2) {
		Checkerboard board = new Checkerboard(10, 10);
		board.setWidth(300);
		board.setHeight(450);
		board.setNumberOfColumns(5);
		board.setNumberOfRows(30);
		board.drawOn(g2);
		
		board = new Checkerboard(350, 20);
		board.setWidth(300);
		board.setHeight(300);
		board.setNumberOfColumns(11);
		board.setNumberOfRows(12);
		board.drawOn(g2);
		
	}

	public void drawExample3(Graphics2D g2) {
		Checkerboard board = new Checkerboard(10, 10);
		board.setWidth(300);
		board.setHeight(450);
		board.setNumberOfColumns(5);
		board.setNumberOfRows(30);
		board.addColor(Color.green);
		board.drawOn(g2);
		
		board = new Checkerboard(350, 20);
		board.setWidth(300);
		board.setHeight(300);
		board.setNumberOfColumns(11);
		board.setNumberOfRows(12);
		board.addColor(Color.DARK_GRAY);
		board.addColor(Color.LIGHT_GRAY);
		board.drawOn(g2);
		
	}
	
}
