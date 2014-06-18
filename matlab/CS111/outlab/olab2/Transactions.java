/* Transactions Class */

public class Transactions
{
    private String accountNumber, transactionType, date;
    private double amount;

    public Transactions(String an, String tt, double amt, String dt)
    {
	accountNumber = an;
	transactionType = tt;
	amount = amt;
	date = dt;
    }

    public String toString()
    {
	String ts;
	
	ts = "Account: " +accountNumber + "\n";
	ts += "Transaction: " +transactionType +"\n";
	ts += "Amount: " +amount +"\n";
	ts += "Date: " +date;
	return ts;
    }
}