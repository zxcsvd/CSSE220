import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;


/**
 * TODO Put here a description of what this class does.
 *
 * @author Pengdi.
 *         Created Jan 30, 2014.
 */

public class counterListener implements ActionListener{
	private JLabel field;
	private int num;
	@Override
	public void actionPerformed(ActionEvent e) {
		String temp = this.field.getText();
		this.num = Integer.parseInt(temp.substring(temp.length()-1, temp.length()));
		this.field.setText("Current counter value: " + (this.num + 1));
		
	}
	
	public counterListener(JLabel field){
		this.field = field;

	}

}
