package firstBank;
import java.util.Scanner;
public class Account {
	
	int balance;
	int previousTrans;
	String customerName;
	String customerID;
	
	//constructor
	Account(String cname, String cid){
		customerName = cname;
		customerID = cid;
	}
	//Function for Depositing 
void deposit(int amount) {
	if(amount != 0) {
		balance = balance + amount;
		previousTrans = amount;
		System.out.println("Deposited " + amount);	
	}
}
//Function for Withdraw
	void withdraw(int amount) {
		if(amount != 0) {
			balance = balance - amount;
			previousTrans = -amount;
}
}
	//Show previous trans
	void getPrevTrans() {
		if(previousTrans > 0) {
			System.out.println("Deposited " + previousTrans);	
		}
		else if(previousTrans < 0) {
			System.out.println("WithDrawn " + Math.abs(previousTrans));	
		}
		else  {
			System.out.println("No Transaction Occurred ");	
		}
	}
	//Interest Calc
	void calculateInterest(int years) {
		double interestRate = .0185;
		double newBalance = (balance *  interestRate * years) + balance;
		System.out.println("The current interest rate is " + (100* interestRate) + "%") ;
		System.out.println("After" + years + "years your balance will be" + newBalance);
	}
	// main menu
	void showMenu() {
		char UpperCaseOption = '\0';
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome, " + customerName);
		System.out.println("Your ID is : " + customerID);
		System.out.println();
		System.out.println("What would you like to do?");
		System.out.println();
		System.out.println("A. Check your balance?");
		System.out.println("B. Make a deposit");
		System.out.println("C. Make a withdrawl");
		System.out.println("D. View previous transaction");
		System.out.println("E. Calculate interest");
		System.out.println("F. Exit");
		
		do {
			System.out.println();
			System.out.println("Enter an option: ");
			char option = scanner.next().charAt(0);
			UpperCaseOption = Character.toUpperCase(option);
			System.out.println();
			
			switch(UpperCaseOption) {
			//case A for balance
			case 'A' :
				System.out.println("==========");
				System.out.println("Your balance is : " + balance);
				System.out.println("==========");
				System.out.println();
				break;
				//Case B for deposit
			case 'B' :
				System.out.println("Enter amount to deposit : ");
				int amount = scanner.nextInt();
				deposit(amount);
				System.out.println();
				break;
				//Case C for withdraw
				case 'C' :
					System.out.println("Enter an amount to withdraw");
					int withdrawAmount = scanner.nextInt();
					withdraw(withdrawAmount);
					System.out.println();
					break;
					//Case D for previous trans
				case 'D' :
					System.out.println("======");
					getPrevTrans();
					System.out.println("======");
					System.out.println();
					break;
					//Calcs interest
				case 'E' :
					 System.out.println("How many years of interest : ");
					 int years = scanner.nextInt();
					 calculateInterest(years);
					 break;
					 //Exit your account
				case 'F' :
					System.out.println("======");
					break;
					//Default. Invalid key
					default:
					System.out.println("Invalid Key. Try again from options");
					break;	
			}
			
		}
		while(UpperCaseOption != 'F');
		System.out.println("Thanks for your service");
		System.out.println();
		
	}
	
	}
	
