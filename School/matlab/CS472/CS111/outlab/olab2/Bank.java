/* The Bank class */

import java.util.*;

public class Bank
{
    private Customer [] customers = new Customer [10];
    private int numCusts = 0;
    
    //Constructor
    /** Default Constructor for Bank <br>
     *  Pre-Conditions none <br>
     *  Post-Coditions A bank is created witn an array of customers */
	
    public Bank()
    {}
    

    /** initializes a new account for a new customer <br>
     *  Pre-Conditions: none <br>
     *  Post-Conditions: A new Customer is created with the users inputs to the questions, and a new account for that Customer is created <br>
     * responses: InputMissMatchException */ 
    
    public void addAccount()
    {
	Scanner sc = new Scanner(System.in);
	int t, a, acctType;
	boolean correct= false;
	String cn, n, ad, tel, an;
	double bal;
	cn = ""+ numCusts;
	while(!correct)
	    {
		System.out.println("What type of customer are you?\n1.)Student\n2.)Adult\n3.)Senior");
		t = sc.nextInt();
		sc.nextLine();
		switch(t)
		    {
		    case 1:
			System.out.println("Please enter your Name:");
			n = sc.nextLine();
			System.out.println("Plese enter you age:");
			a = sc.nextInt();
			sc.nextLine();
			System.out.println("Please enter your telephone Number:");
			tel = sc.nextLine();
			System.out.println("Please enter your address (on one line);");
			ad = sc.nextLine();
			System.out.println("What type of account are you opening:\n1) Checking\n2) Savings");
			acctType = sc.nextInt();
			sc.nextLine();
			System.out.println("How much money are you opening your account with: ");
			bal = sc.nextDouble();
			sc.nextLine();
			customers[numCusts]= new Student(cn, a, n, ad, tel, acctType, "0", bal);
			numCusts++;
			correct = true;
			break;
		    case 2:
			System.out.println("Please enter your Name:");
			n = sc.nextLine();
			System.out.println("Please enter your age:");
			a = sc.nextInt();
			sc.nextLine();
			System.out.println("Please enter your telephone Number");
			tel = sc.nextLine();
			System.out.println("Please enter your address (on one line):");
			ad = sc.nextLine();
			System.out.println("What type of account are you opening:\n1) Checking\n2) Savings");
			acctType = sc.nextInt();
			sc.nextLine();
			System.out.println("How much money are you opening your account with:");
			bal = sc.nextDouble();
			sc.nextLine();
			customers[numCusts] = new Adult(cn, a, n, ad, tel, acctType, "0", bal);
			numCusts++;
			correct = true;
			break;
		    case 3:
			System.out.println("Please enter your name: ");
			n = sc.nextLine();
			System.out.println("Please enter your age: ");
			a = sc.nextInt();
			sc.nextLine();
			System.out.println("Please enter your telephone number: ");
			tel = sc.nextLine();
			System.out.println("Please enter your address (on one line)");
			ad = sc.nextLine();
			System.out.println("What type of account are you opening:\n1) Checking\n2) Savings");
			acctType = sc.nextInt();
			sc.nextLine();
			System.out.println("How much money are you opening your account with: ");
			bal = sc.nextDouble();
			sc.nextLine();
			customers[numCusts] = new Senior(cn, a, n, ad, tel, acctType, "0", bal);
			numCusts++;
			correct = true;
			break;
		    default:
			System.out.println("Incorrect number! Please try again.");
			sc.nextLine();
			correct = false;
		    }
		sc.nextLine();
	    }
    }

    /** initializes a new account for an existing customer
     *  Pre-Conditions: CustomerNumber is a valid String of Numbers <br>
     *  Post-Conditions: A new account is created for an existing customer <br>
     *  responses: Exception and Error Terminate
     *  @param custNum = String of valid customer number */
     
    public void  addAccount(String custNum)
    {
	Scanner sc = new Scanner(System.in);
	for(int i = 0; i <numCusts; i++)
	    {
		if(customers[i].getCustomerNumber().equals(custNum))
		    {
			int an, at;
			String ans;
			double b;
			an = customers[i].numOfAccounts() +1;
			ans = "" + an;
			System.out.println("What type of account would you like to open:\n1) Checking\n2) Savings");
			at = sc.nextInt();
			System.out.println("How much money are you opening the account with: ");
			b = sc.nextDouble();
			customers[i].addAccount(at, ans, b);
		    }
	    }
    }
    

    /** Allows money to be withdrawn from an account
     *  Pre-Conditions: acctNum, custNum, date are valid Strings, w is a valid double <br>
     *  Post-Conditions: w is subtracted from the Customers specified account <br>
     *  @param acctNum = valid String that matches account number
     *  @param custNum = valid string that matches customer number
     *  @param w = double
     *  @param date = String */ 
    public void makeWithdrawl(String acctNum, String custNum, double w, String date)
    {
	for(int j = 0; j< numCusts; j++)
	    {
		if(customers[j].getCustomerNumber().equals(custNum))
		    {
			customers[j].getAccount(acctNum).withdraw(customers[j],w);
		    }
	    }
    }
    /** Allows money to be deposited into an account
     *  Pre-Conditions: acctNum, custNum, date are valid Strings, d is a valid double <br>
     *  Post-Conditions: d is added to the specified account for that customer <br>
     *  @param acctNum = valid String that matches account number
     *  @param custNum = valid String that matches customer number
     *  @param w= double
     *  @param date = String */
    public void makeDeposit(String acctNum, String custNum, double d, String date)
    {
	for(int k = 0; k<numCusts; k++)
	    {
		if(customers[k].getCustomerNumber().equals(custNum))
		    {
			customers[k].getAccount(acctNum).deposit(d);
		    }
	    }
    }

    /** Returns a specific account for a specific Customer
     *  Pre-Conditions: acctNum, custNum are valid Strings <br>
     *  Post-Conditions: returns the Account specified <br>
     *  response: return null
     *  @param custNum = valid String that matches customer number
     *  @param acctnum = valid String that matches account number
     */
    public Accounts getAccount(String actNum, String custNum)
    {
	for(int l = 0; l<numCusts; l++)
	    {
		if(customers[l].getCustomerNumber().equals(custNum))
		    {
			customers[l].getAccount(actNum);
		    }
	    }
	return null;
    }	
}
