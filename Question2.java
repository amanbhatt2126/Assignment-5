// Aman Bhatt 19105013
import java.util.*;
class Customer{

	int customerID;
	String name;
	String email;
	String phone;

	Customer(int customerID, String name, String email, String phone){
		this.customerID = customerID;
		this.name = name;
		this.email = email;
		this.phone = phone;
	}

}

class Account{

	int accountID;
	int amount;
	
	Customer customer;

	Account(int accountID, int amount, Customer customer){
		this.accountID = accountID;
		this.amount = amount;
		this.customer = customer;
	}

	void withDraw(int amount){
		this.amount -= amount;
	}
	void deposit(int amount){
		this.amount += amount;
	}
}

class RBI{

	int minInterest;
	int maxWithdraw;
	int minBalance;

	RBI(int minInterest, int maxWithdraw, int minBalance){
		this.minInterest = minInterest;
		this.minBalance = minBalance;
		this.maxWithdraw = maxWithdraw;
	}
}

class Bank{
	
	RBI rbi_guidelines;  // each bank maintains a copy of rbi guidelines 
	int interest;

	Bank(RBI rbi){
		this.rbi_guidelines = rbi; 
		this.interest =rbi.minInterest; 
	}

	void setInterest(int newInterest){

		if(newInterest < rbi_guidelines.minInterest){
			System.out.println("Cannot change interest rate because minInterest is : " + rbi_guidelines.minInterest); 
			return;
		}


		this.interest = newInterest;
	}
	int getInterest(){
		return this.interest;
	}
}

class SBI extends Bank{

	Vector<Account> accounts;
	SBI(RBI rbi){
		super(rbi); 
		accounts = new Vector<Account>();
	}
	void createAccount(int accountID, Customer customer, int amount){
		if(amount < this.rbi_guidelines.minBalance){
			System.out.println("Cannot create account with less than minimum amount."); 
			return;
		}
		Account ac = new Account(accountID, amount, customer); 
		accounts.add(ac);
	}

	void withDraw(int accountID, int amount){
		for(int i=0;i<accounts.size();i++){
			if(accounts.get(i).accountID == accountID){
				if(accounts.get(i).amount - amount < this.rbi_guidelines.minBalance){
					System.out.println("Cannot withdraw from account " + accountID + " because minimum balance needs to be maintained."); 
					return;
				}else if(accounts.get(i).amount > this.rbi_guidelines.maxWithdraw){
					System.out.println("Cannot withdraw more than maximum allowed limit.");
					return;
				}
				
				Account ac = accounts.get(i); 
				accounts.set(i, new Account(ac.accountID, ac.amount - amount, ac.customer));
				// change amount 	
			} 
		}
	}

	void deposit(int accountID, int amount){
		for(int i=0;i<accounts.size();i++){
			if(accounts.get(i).accountID == accountID){
				
				Account ac = accounts.get(i); 
				accounts.set(i, new Account(ac.accountID, ac.amount + amount, ac.customer));
			} 
		}
	}
}

public class Question2{

	public static void main(String args[]){

		RBI rbi_guidelines = new RBI(4,100000,5000); 
		SBI sbi = new SBI(rbi_guidelines); 

		Customer aman = new Customer(1, "Aman Bhatt", "amanbhatt@email", "1234567890"); 
		sbi.createAccount(1, aman, 6000); 

		sbi.withDraw(1,500); 
		sbi.withDraw(1,1000); 

		sbi.deposit(1,1000000);
		sbi.withDraw(1,200000); 


	}
}