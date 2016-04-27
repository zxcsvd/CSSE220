/**
 * 
 */

/**
 * TODO Put here a description of what this class does.
 *
 * @author pengb.
 *         Created 2013-12-12.
 */
public class SlowThinker {
	private String saving = "";
	private String second = "";
	/**
	 * TODO Put here a description of what this method does.
	 *
	 * @param string
	 * @return
	 */
	public Object transform(String string) {
		saving = second;
		second = string;
		return saving;
	}

}
