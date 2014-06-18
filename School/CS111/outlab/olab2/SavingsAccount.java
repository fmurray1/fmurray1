/* Savings Account Class */

public class SavingsAccount extends Accounts
{
    public SavingsAccount(String an, double bal)
    {
	super(an, bal);
	super.addTransaction(an, "Opened Account", bal, "Date");
    }

    public void deposit(double d)
    {
	super.addTransaction(super.getAccountNumber(),"Deposit", d, "Date");
	super.deposit(d);
    }
    
    public void withdraw(Customer cust, double w)
    {
	super.addTransaction(super.getAccountNumber(),"Withdraw", w, "Savings");
	super.withdraw(cust, w);
    }
}