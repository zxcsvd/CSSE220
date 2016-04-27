import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Counter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame("Counter");
		final JLabel field = new JLabel();
		field.setText("Current counter value: 0");
		
		frame.add(field);
		JButton counter = new JButton("Add one to the counter");
		JButton reset = new JButton("Reset to 0");

		JPanel buttons = new JPanel();
		buttons.add(counter);
		buttons.add(reset);
		
		counterListener add = new counterListener(field);
		counter.addActionListener(add);
		resetListener zero = new resetListener(field);
		reset.addActionListener(zero);
		frame.add(buttons, BorderLayout.SOUTH);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
