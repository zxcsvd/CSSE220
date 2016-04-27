import java.util.Scanner;

/**
 * Demonstrates comparing two separately entered Strings for equality.
 * 
 * @author Delvin Defoe, created Dec 6, 20013.
 */
public class EmailValidator {
	
	private Scanner inputScanner;
	private String emailFirst;
	private String emailSecond;
	
	
	/**
	 * Constructs an EmailValidator.
	 *
	 */
	public EmailValidator(){
		this.inputScanner = new Scanner(System.in);
	}

	/**
	 * Starts here.
	 * 
	 * @param args
	 *            ignored
	 */
	public static void main(String[] args) {
		EmailValidator ev = new EmailValidator();
		ev.getEmailAddresses();
		ev.compareEmailAddresses();
	}
	
	
	/**
	 * Gets an email address from the user twice
	 *
	 */
	public void getEmailAddresses(){
		System.out.println("What is the address?");
		emailFirst = inputScanner.next();
		System.out.printf("You entered '%s %n", this.emailFirst);
		// TODO store the first email in emailFirst then print it
		System.out.println("Enter again?");
		emailSecond = inputScanner.next();
		// TODO store the second email in emailSecond then print it
	
	}
	
	
	/**
	 * Compares the two email address for equality and print whether or not they are the same.
	 *
	 */
	public void compareEmailAddresses(){
		// TODO complete this method.
		if (emailFirst.equals(emailSecond)) {
			System.out.println("Excellent.  You your email address has been validated.");
		} else {
			System.out.println("You entered two different email address.");
		}
		
	}

}
