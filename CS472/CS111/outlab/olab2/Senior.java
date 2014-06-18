/* Senior Class */

public class Senior extends Customer
{
    double checkCharge = .5, checkingInterest=.0075, overdraftPenalty=20, savingsInterest= .0005;
    
    public Senior(String cn, int a, String n, String ad, String t, int at, String an, double bal)
    {
	super(cn, a, n, ad, t, at, an, bal);
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