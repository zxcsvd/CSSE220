/**
 * 
 */

/**
 * TODO Put here a description of what this class does.
 *
 * @author pengb.
 *         Created 2013-12-12.
 */
public class SometimesShouter {
	private int saving = 1;
	private int period = 2;
	/**
	 * TODO Put here a description of what this constructor does.
	 *
	 * @param i
	 */
	public SometimesShouter(int i) {
		this.period = i;
	}

	/**
	 * TODO Put here a description of what this constructor does.
	 *
	 */
	public SometimesShouter() {
		this.period = 2;
	}

	/**
	 * TODO Put here a description of what this method does.
	 *
	 * @param string
	 * @return
	 */
	public String transform(String string) {
		String temp = string;
		
		if (this.saving % this.period == 0){
			this.saving = this.saving + 1;
			String result = string.toUpperCase();
			
			return result;
		}
		this.saving = this.saving + 1;
		return temp;
	}

}
