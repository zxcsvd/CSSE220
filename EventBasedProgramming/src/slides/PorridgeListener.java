package slides;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * TODO Put here a description of what this class does.
 *
 * @author Pengdi.
 *         Created Jan 20, 2014.
 */
public class PorridgeListener implements ActionListener{
public String n;
	@Override
	public void actionPerformed(ActionEvent arg0) {

		System.out.print(this.n);
		// TODO Auto-generated method stub.
		
	}
	public PorridgeListener(){
		this.n = n;
	}
}
