/* Bank Application Class */

public class BankApp
{
    public static void main (String [] args)
    {
	Bank b = new Bank();
	

	// make 3 new customers and 3 new accounts
	b.addAccount();
	b.addAccount();
	b.addAccount();
	
	// adds accounts to existing customers
	b.addAccount("0");
	b.addAccount("0");
	b.addAccount("1");
	b.addAccount("2");

	//makes deposit to different accounts for different customers
	b.makeDeposit("0", "0", 5.00, "3/15/2012");
	b.makeDeposit("0", "1", 1000.50, "2/23/2012");
	b.makeDeposit("0", "2", 399.99, "12/25/2012");

	//makes withdrawls from different accounts for different customers
	b.makeWithdrawl("0", "0", 1.45, "7/7/2012");
	b.makeWithdrawl("0", "1", 209.85, "3/4/2012");
	b.makeWithdrawl("0", "2", 0.99, "7/11/2012");
	

	//prints out the specific accounts for specific customers
	System.out.println(b.getAccount("0", "0"));
	System.out.println(b.getAccount("0", "1"));
	System.out.println(b.getAccount("0", "2"));
    }
}