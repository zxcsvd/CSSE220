/**
 * 
 */

/**
 * TODO Put here a description of what this class does.
 *
 * @author pengb.
 *         Created 2013-12-12.
 */
public class Repeater {

	/**
	 * TODO Put here a description of what this method does.
	 *
	 * @param string
	 * @return
	 */
	public Object transform(String string) {
		String result = "";
		String temp = string;
		for (int k=0; k<string.length(); k++){
			result = result + temp;
		}
		return result;
	}

}
