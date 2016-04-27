/**
 * 
 */

/**
 * TODO Put here a description of what this class does.
 *
 * @author pengb.
 *         Created 2013-12-12.
 */
public class Counter {
	private String result;
	private int k = 1;
	/**
	 * TODO Put here a description of what this method does.
	 *
	 * @param string
	 * @return
	 */
	public String transform(String string) {
		Integer count = new Integer(k);
		result = k + ". " + string;
		k = k + 1;
		return result;
	}

}
