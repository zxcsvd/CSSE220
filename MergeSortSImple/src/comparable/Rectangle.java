package comparable;

import java.util.ArrayList;
import java.util.Collections;

/**
 * A example class for implementing comparable
 * 
 * @author hewner
 *
 */
public class Rectangle implements Comparable<Rectangle>{
	private int width, height;
	
	public Rectangle(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	public int getArea() {
		return this.width*this.height;
	}
	
	public String toString() {
		return this.width + "x" + this.height;
	}
	
	public static void main(String[] args) {
		ArrayList<Rectangle> rects = new ArrayList<Rectangle>();
		rects.add(new Rectangle(5,5));
		rects.add(new Rectangle(1,20));
		rects.add(new Rectangle(3,3));
		
		Collections.sort(rects);
		
		System.out.println(rects);
	}

	@Override
	public int compareTo(Rectangle o) {
		if(this.width == o.width){
			return this.getArea() - o.getArea();
		}
		return this.getArea() - o.getArea();
//		return this.compareTo(o.);
	}
}
