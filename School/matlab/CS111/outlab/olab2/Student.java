/* Student Class */

public class Student extends Customer
{
    private double checkingInterest=.0075, savingsInterest=.005, checkCharge=0, overdraftPenalty=10;

    public Student(String custNum, int a, String n, String ad, String t, int accntType, String acctNum, double bal)
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