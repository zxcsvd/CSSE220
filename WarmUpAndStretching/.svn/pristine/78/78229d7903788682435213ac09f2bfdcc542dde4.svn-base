package hardysTaxi;

import static java.lang.Math.min;
import static java.lang.Math.max;


/**
 * A TaxicabNumber object stores an integer s that can be written
 * in more than one way as a sum of cubes along with two pairs of  
 * integers (a, b) and (c, d) that demonstrate this fact.
 * 
 * @author Claude Anderson November, 2010.
 *
 */


public class TaxicabNumber implements Comparable<TaxicabNumber> {
	private int s, a, b, c, d;  //  s = a*a*a + b*b*b = c*c*c + d*d*d
	
	/**
	 * Returns the cube of the given number.
	 *
	 * @param x
	 * @return The cube of the given number.
	 */
	public static int cube(int x) {
		return x * x * x;
	}
	
	/**
	 * A member of this class is basically a struct that holds a taxicab number and 
	 * the evidence that it is indeed such a number.  a^3 + b^3 = s = c^3 + d^3 
	 * @param s  sum of cubes
	 * @param a  cube(a) + cube(b) = s
	 * @param b
	 * @param c  cube (c) + cube(d) = s
	 * @param d
	 */
	public TaxicabNumber(int s, int a, int b, int c, int d) {
		this.s = s;
		// We want a <=b, c <= d, and a <= c in constructed object.
		int firstSmall = min(a, b);
		int secondSmall = min(c, d);
		this.a = min(firstSmall, secondSmall);
		this.c = max(firstSmall, secondSmall);
		if (this.a == firstSmall) {
			this.b = max (a, b);
			this.d = max(c, d);
		} else {
			this.b = max (c, d);
			this.d = max(a, b);
		}
		// Is this a legal taxicab number instance?
		if (this.s != cube (this.a) + cube (this.b))
			throw new HardyException(this.a + "^3 + " + this.b + "^3 != " + this.s);
		if (this.s != cube (this.c)+ cube (this.d))
			throw new HardyException(c + "^3 + " + d + "^3 != " + s);
		if (this.a == this.c)
			throw new HardyException("The two given ways of writing  " + s +
					                  " as the sum of two cubes are identical");
	}
	
	/**
	 * string representation of this taxicab number
	 * @return a string representation of this taxicab Number
	 */
	@Override
	public String toString() {
		return this.s + " = " + this.a + "^3 + " + this.b + "^3 = " +
		this.c + "^3 + " + this.d + "^3"; 
	}
	
	/**
	 * Are the numbers in these representations the same (except for order)
	 * @param otherCab
	 * @return true iff the numbers in these representations are the same (except for order)
	 */
	public boolean equals(TaxicabNumber otherCab) {
		return this.toString().equals(otherCab.toString());
		// In a later program, we may want a more inclusive definition.
	}
	
	@Override
	public int compareTo(TaxicabNumber other) {
		if (this.s < other.s) return -1;
		if (this.s > other.s) return 1;
		if (this.a < other.a) return -1;
		if (this.a > other.a) return 1;
		if (this.c < other.c) return -1;
		if (this.c > other.c) return 1;
		return 0;
	}
	
	// NOTE: The following getter methods were generated automatically, 
	//       using Source--> Generate Getters and Setters

	/**
	 * @return the s
	 */
	public int getS() {
		return this.s;
	}

	/**
	 * @return the a
	 */
	public int getA() {
		return this.a;
	}

	/**
	 * @return the b
	 */
	public int getB() {
		return this.b;
	}

	/**
	 * @return the c
	 */
	public int getC() {
		return this.c;
	}

	/**
	 * @return the d
	 */
	public int getD() {
		return this.d;
	}
}
