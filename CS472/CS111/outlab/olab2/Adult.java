/* Adult Class */

public class Adult extends Customer
{
    private double checkingInterest=.01, savingsInterest=.0075, checkCharge=.5, overdraftPenalty=35;

    public Adult(String custNum, int a, String n, String ad, String t, int accntType, String acctNum, double bal)
    {
	super(custNum, a, n, ad, t, accntType, acctNum, bal);
    }
    
    public double getCheckCharge()
    {
	return checkCharge;
    }
    
    public double getCheckingInterest()
    {
	return checkingInterest;
    }
    
    public double getOverdraftPenalty()
    {
	return overdraftPenalty;
    }

    public double getSavingsInterest()
    {
	return savingsInterest;
    }
}