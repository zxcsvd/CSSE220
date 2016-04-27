package comparingShapes;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Comparator;

import org.junit.AfterClass;
import org.junit.Test;

/**
 * Tests the circle and triangle classes
 * 
 * @author Matt Boutell. Created Dec 1, 2013.
 */

public class ShapeTest {

	private static int points = 0;

	/**
	 * Tests the given method.
	 */
	@Test
	public void testSortCircles() {
		Circle c1 = new Circle(10);
		Circle c2 = new Circle(18.4);
		Circle c3 = new Circle(15.3);
		Circle c4 = new Circle(8.25);
		Circle c5 = new Circle(0.9);
		Circle[] circles = new Circle[] { c1, c2, c3, c4, c5 };
		System.out.println("Before sorting circles: ");
		printArray(circles);

		// TODO: Nothing to change here. But note,
		// there is only one way to sort circles, since sorting by
		// radius, perimeter, or area will always give the same results.
		// To make this code run without crashing, make the Circle class
		// Comparable (that is, change the Circle class)
		System.out.println("After sorting circles: ");
		Arrays.sort(circles);
		printArray(circles);
		assertEquals(circles[0], c5);
		assertEquals(circles[1], c4);
		assertEquals(circles[2], c1);
		assertEquals(circles[3], c3);
		assertEquals(circles[4], c2);
		points += 5;
	}

	/**
	 * Tests the given method.
	 */
	@Test
	public void testSortTrianglesByPerimeter() {
		Triangle t1 = new Triangle(3, 4, 5);
		Triangle t2 = new Triangle(6, 6, 1);
		Triangle t3 = new Triangle(4.5, 4.5, 4.5);
		Triangle t4 = new Triangle(1, 1, 1.5);
		Triangle t5 = new Triangle(12, 5, 13);
		Triangle[] triangles = new Triangle[] { t1, t2, t3, t4, t5 };
		System.out.println("Before sorting triangles: ");
		printArray(triangles);

		System.out.println("After sorting triangles by perimeter: ");
		// TODO: Nothing to write here. Just study this example. Note that we
		// can sort triangles by perimeter or area, so it isn't enough to make
		// triangles implement Comparable. For maximum flexibility, we write and
		// pass Comparator objects to the sort() method to compare triangles by
		// perimeter and by area. 
		Comparator<Triangle> byPerimeter = new Comparator<Triangle>() {
			@Override
			public int compare(Triangle first, Triangle second) {
				return (int) Math
						.signum(first.perimeter() - second.perimeter());
			}
		};
		Arrays.sort(triangles, byPerimeter);
		printArray(triangles);
		assertEquals(triangles[0], t4);
		assertEquals(triangles[1], t1);
		assertEquals(triangles[2], t2);
		assertEquals(triangles[3], t3);
		assertEquals(triangles[4], t5);
	}

	/**
	 * Tests the given method.
	 */
	@Test
	public void testSortTrianglesByArea() {
		Triangle t1 = new Triangle(3, 4, 5);
		Triangle t2 = new Triangle(6, 6, 1);
		Triangle t3 = new Triangle(4.5, 4.5, 4.5);
		Triangle t4 = new Triangle(1, 1, 1.5);
		Triangle t5 = new Triangle(12, 5, 13);
		Triangle[] triangles = new Triangle[] { t1, t2, t3, t4, t5 };
		System.out.println("Before sorting triangles: ");
		printArray(triangles);

		System.out.println("After sorting triangles by area: ");
		// TODO: Create and add a comparator to compare triangles by area,
		// so we can sort by area. Then pass it as a second argument to the
		// sort method.
		Arrays.sort(triangles);
		printArray(triangles);
		assertEquals(triangles[0], t4);
		assertEquals(triangles[1], t2);
		assertEquals(triangles[2], t1);
		assertEquals(triangles[3], t3);
		assertEquals(triangles[4], t5);
		points += 5;
	}

	@AfterClass
	public static void showPoints() {
		System.out.printf("COMPARING SHAPES POINTS = %d of 10\n", points);
	}

	private static void printArray(Object[] array) {
		System.out.print("[");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]); // calls toString
			if (i < array.length - 1) {
				System.out.print(", ");
			}
		}
		System.out.print("]\n");
	}
}
