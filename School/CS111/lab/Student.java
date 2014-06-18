/* Francis Murray Student Class CS111 Friday March 2nd 2012 */

public class Student extends Person
{
    double gPA;
    int grade;
    
    public Student()
    {
	super();
	gPA = 0.0;
	grade = 0;
    }
    public Student(String f, String l, int a, double gp, int gr)
    {
	super(f, l, a);
	gPA = gp;
	grade = gr;
    }
    
    public void setGPA(double g)
    {
	gPA = g;
    }
    public void setGrade(int g)
    {
	grade = g;
    }
    public double getGPA()
    {
	return gPA;
    }
    public int getGrade()
    {
	return grade;
    }
    public void printPerson()
    {
	super.printPerson();
	System.out.println("Grade: " +grade);
	System.out.println("GPA: " +gPA);
    }
}
	    