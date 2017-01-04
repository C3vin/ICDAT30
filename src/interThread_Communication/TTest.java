package interThread_Communication;

public class TTest {
		public static void main(String args[]) {
			//Chat
			Chat m = new Chat();
			new T1(m);
			new T2(m);
			
			//Customer
			final Customer c = new Customer();
			new Thread() {
				public void run() {
					c.withdraw(15000);
				}
			}.start();
			
			new Thread() {
				public void run() {
					c.deposit(10000);
				}
			}.start();
		}
}
