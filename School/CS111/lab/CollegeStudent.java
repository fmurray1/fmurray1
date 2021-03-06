/* Francis Murray College Student Class CS111 Friday March 2nd 2012 */

public class CollegeStudent extends Student
{
    private String school;
    private Adult advisor;
    
    public CollegeStudent()
    {
	super();
	school = "None";
	advisor = new Adult();
    }
    public CollegeStudent(String f, String l, int a, double gp, int gr, String s, Adult ad)
    {
	super(f, l, a, gp, gr);
	school = s;
	advisor = ad;
    }
    
    public String getCollege()
    {
	return school;
    }
    
    public Adult getAdvisor()
    {
	return advisor;
    }
    
    public void setAdvisor(Adult a)
    {
	advisor = a;
    }
    
    public void setCollege(String s)
    {
	school = s;
    }
    
    public void printPerson()
    {
	super.printPerson();
	System.out.println("College: " +school);
	System.out.println("Advisor: " +advisor.first() +" " + advisor.last());
    }
}