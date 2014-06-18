/* Abstract Customer class */

import java.util.Scanner;

abstract class Customer
{
    private String name, address, telephoneNumber, customerNumber;
    private int age, accNum;
    private Accounts accounts[] = new Accounts[5];

    public Customer(String cn, int a, String n, String ad, String t, int acctType, String acctNum, double bal)
    {
	customerNumber = cn;
	age = a;
	name = n;
	address = ad;
	telephoneNumber = t;
	
	// make new account here
	
    }

    public void setName(String n)
    {
	name = n;
    }
    public void setAddress(String a)
    {
	address = a;
    }
    public void setTelephoneNumber(String t)
    {
	telephoneNumber = t;
    }
    public void setCustomerNumber(String c)
    {
	customerNumber = c;
    }
    public void setAge(int a)
    {
	age = a;
    }
    public String getName()
    {
	return name;
    }
    public String getAddress()
    {
	return address;
    }
    public String getTelephoneNumber()
    {
	return telephoneNumber;
    }
    public String getCustomerNumber()
    {
	return customerNumber;
    }
    public int getAge()
    {
	return age;
    }

    public String getAccountNumber()
    {
	String ans =""+accNum;
	return ans;
    }
    
    public Accounts getAccount(String an)
    {
	for(int i = 0; i < accNum; i++)
	    {
		if(accounts[i].getAccountNumber().equals(an))
		    {
			return accounts[i];
		    }
	    }
	return null;
    }

    abstract double getSavingsInterest();
    abstract double getCheckingInterest();
    abstract double getCheckCharge();
    abstract double getOverdraftPenalty();
    
    public Accounts account()
    {
	Scanner sc = new Scanner(System.in);
	int a;
	System.out.println();
	System.out.println("Which account would you like to access");
	for(int i = 0; i < accNum; i++)
	    {
		System.out.println((i+1)+".)" +accounts[i]);
	    }
	a = sc.nextInt();
	sc.nextLine();
	sc.close();
	return accounts[(a-1)];
    }
    public String toString()
    {
	String cs;
	
	cs = "Name : " +name +"\nAddress: " +address +"\nTelephone: " +telephoneNumber +"\nAge: " +age +"\nCustomer Number: " +customerNumber +"\nAccounts: " +accNum; 
	return cs;
    }

    public int numOfAccounts()
    {
	return accNum;
    }

    public void addAccount(int at, String an, double b)
    {
	if(at ==1)
	    {
		accounts[accNum]= new CheckingAccount(an, b);
	    }
	else
	    {
		accounts[accNum] = new SavingsAccount(an, b);
	    }
    }
}