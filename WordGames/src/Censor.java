import java.nio.charset.Charset;
import java.util.ArrayList;

/**
 * 
 */

/**
 * TODO Put here a description of what this class does.
 *
 * @author pengb.
 *         Created 2013-12-12.
 */
public class Censor {
	private char sensor;
	private String temp;
	private String result ="";
	
	/**
	 * TODO Put here a description of what this constructor does.
	 *
	 * @param c
	 */
	public Censor(char c) {
		this.sensor = c;
	}

	/**
	 * TODO Put here a description of what this constructor does.
	 *
	 */
	public Censor() {
		this.sensor = 'e';
	}

	/**
	 * TODO Put here a description of what this method does.
	 *
	 * @param string
	 * @return
	 */
	public String transform(String string) {
		
		result = "";
		for (int k = 0; k < string.length(); k++){
			if (string.charAt(k) == this.sensor){
				result = result + "*";
			}
			else{
//				temp = string.substring(k, k+1);
				result = result + string.charAt(k);
			}
			
		}

		return result;
	}

}
