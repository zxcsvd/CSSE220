import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;


/**
 * TODO Put here a description of what this class does.
 *
 * @author Pengdi.
 *         Created Jan 30, 2014.
 */
public class resetListener implements ActionListener{
	private JLabel field;
	private int num;
	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.field.setText("Current counter value: " + (0));
		
	}
	public resetListener(JLabel field){
		this.field = field;
		String temp = field.getText();
		this.num = Integer.parseInt(temp.substring(temp.length()-1, temp.length()));
	}
}
