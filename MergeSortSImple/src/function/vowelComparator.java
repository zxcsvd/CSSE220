package function;

import java.util.Comparator;

/**
 * TODO Put here a description of what this class does.
 *
 * @author Pengdi.
 *         Created Feb 11, 2014.
 */
public class vowelComparator implements Comparator<String>{

	@Override
	public int compare(String o1, String o2) {
		// TODO Auto-generated method stub.
		int lengtha = 0;
		int lengthb = 0;
		for (int i=0; i<o1.length(); i++){

			if(o1.charAt(i)=='a' ||o1.charAt(i)=='e'||o1.charAt(i)=='i'||o1.charAt(i)=='o'||o1.charAt(i)=='u'){
				lengtha++;
			}
			if(o2.charAt(i)=='a' ||o2.charAt(i)=='e'||o2.charAt(i)=='i'||o2.charAt(i)=='o'||o2.charAt(i)=='u'){
				lengthb++;
			}
			
		}
		return (lengtha - lengthb);
	}

}
