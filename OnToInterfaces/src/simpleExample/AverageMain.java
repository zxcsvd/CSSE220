package simpleExample;

public class AverageMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		BankAccount realBank = new BankAccount();
//		Measurable m = new BankAccount();
//		m.getMeasure();
		
		BankAccount[] accounts = new BankAccount[3];
		accounts[0] = new BankAccount();
		accounts[0].setBalance(100);
		accounts[1] = new BankAccount();
		accounts[1].setBalance(150);
		accounts[2] = new BankAccount();
		accounts[2].setBalance(200);

		Country[] countries = new Country[3];
		countries[0] = new Country("Uruguay",176220);
		countries[1] = new Country("Thailand",513120);
		countries[2] = new Country("Belgium",30510);
		
		System.out.println(getTotal(countries));
		System.out.println(getTotal(accounts));
		
		// TODO: write functions that compute and print out the
		// average balance for the Bank account and average
		// area for the country
		//
		// Hint: once you get one working, I reccommend some
		// cut and pasting
		

	}
		public static double getTotal(Measurable[] printTotal){
			double total = 0;
			for(int i=0; i<printTotal.length ; i++){
				total += printTotal[i].getMeasure();
			}
			return total;
		}
}
