import java.util.Scanner;


/**
 * This is an example of using a Scanner to read console input.
 *
 * @author defoe.
 *         Created Dec 6, 2013.
 */
public class ScannerExample {
	
	static private String firstName;
	static private String lastName;
	static private String major;
	static private int currentHours;
	static private double gpa;

	/**
	 * Starts here.
	 * 
	 * @param args
	 *            ignored
	 */
	public static void main(String[] args) {
		
		getInput();
		
		System.out.printf("I am %s %s. My major is %s. I am taking %02d hours this term and my GPA is %3.2f.%n", firstName, lastName,
				major, currentHours, gpa);

	}
	
	
	/**
	 * Gets console input from user.
	 *
	 */
	public static void getInput(){
		// Create scanner object to read console input
		Scanner inputScanner = new Scanner(System.in);
		
		// TODO Add appropriate prompts before each input
		System.out.println("First name?");
		firstName = inputScanner.nextLine().trim();
		System.out.println("Last name?");
		
		lastName = inputScanner.nextLine().trim();
		
		// TODO write code that uses the inputScanner to read the requested data
		System.out.print("Enter the abbreviation for your first major (e.g., CS, SE, MA):  ");
		major = inputScanner.next();
		
		System.out.print("How many credit hours you are taking this term?  ");
		currentHours = inputScanner.nextInt();
		
		System.out.print("What is your current GPA?  ");
		gpa = inputScanner.nextDouble();
	}

}
