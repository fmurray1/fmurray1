/* Account class */

public abstract class Accounts
{
    private Transactions [] transactions = new Transactions[10];
    private String accountNumber;
    private double balance = 0;
    private int numTrans;

    public Accounts(String an, double bal)
    {
	balance = bal;
	accountNumber = an;
    }

    public  void deposit(double d)
    {
	balance += d;
    }

    public void withdraw(Customer cust, double w)
    {
	balance -= w;
    }

    public void addTransaction(String an, String transactionType, double amount, String date)
    {
	transactions[numTrans]= new Transactions(an, transactionType, amount, date);
	numTrans++;
    }
    
    public void displayTrans()
    {
	for(int i = 0; i < numTrans; i++)
	    {
		System.out.println(transactions[i]);
	    }
    }
    
    public String getAccountNumber()
    {
	return accountNumber;
    }
    
    public double getBalance()
    {
	return balance;
    }

    public String toString()
    {
	String as;
	
	as = "Account: " +accountNumber +"\n";
	as+= "Balance: " +balance +"\n";
	as += "Number of past transactions :" +numTrans;
	
	return as;
    }
}

