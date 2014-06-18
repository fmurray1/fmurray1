/* Checking Account Class */

public class CheckingAccount extends Accounts
{
    public CheckingAccount(String an, double bal)
    {
	super(an, bal);
	super.addTransaction(an, "Opened Account", bal, "Date");
    }
    
    public void deposit(double d)
    {
	super.addTransaction(super.getAccountNumber(), "Deposit", d, "Date");
	super.deposit(d);
    }
    
    public void withdraw(Customer cust, double w)
    {
	super.addTransaction(super.getAccountNumber(),"Withdraw", w, "Date");
	super.withdraw(cust, w);
    }
}