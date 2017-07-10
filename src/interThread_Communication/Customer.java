package interThread_Communication;

public class Customer {
	int amount=10000;
	
	public synchronized void withdraw(int amount) {
		System.out.println("Going to withdraw...");
		
		if(this.amount < amount) {
			System.out.println("Less balance; waiting for deposit...");
			try{
				wait();
				this.amount-= amount;
				System.out.println("withdraw amount:" + amount + ", rest amount: " + this.amount);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		this.amount = amount;
		System.out.println("Withdraw completed...");
	}
	
	public synchronized void deposit(int amount) {
		System.out.println("Going to deposit...");
		this.amount += amount;
		System.out.println("amount:" + this.amount);
		System.out.println("Deposit completed...");
		notify();
	}
}
