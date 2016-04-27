import java.util.Scanner;




public class AnotherClass {


		public static void main(String[] args) {
			
			Scanner keyboard = new Scanner(System.in);
			// TODO Auto-generated method stub4.	

	        int numberGrade = keyboard.nextInt();

	           if (numberGrade <= 100 && numberGrade >= 90)
	           {
	              System.out.println("A");
	           }
	           else if (numberGrade <= 89 && numberGrade >= 80)
	          {
	          System.out.println("B");
	           }
	           else if (numberGrade <= 79 && numberGrade >= 70)
		           {
	              System.out.println("C");
		            }
	           else if (numberGrade <= 69 && numberGrade >= 60)
		           {
	              System.out.println("D");
	              }
		}         
}
