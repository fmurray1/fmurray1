/* This is the modified problem generator for college students */

import java.util.Scanner;

public class CollegeFlashCards
{
    public CollegeFlashCards()
    {
	Problem p; 
	boolean allowed, answered;
	Scanner sc = new Scanner(System.in);
	int ans, gm, wm, count;
	
	while(sc.hasNext())
	    {
		p = new Problem();
		allowed = false;
		answered = false;
		count = 0;
		System.out.println("This is a Flash card Generator for College Students\nYou have 3 tries to complete each problem \nType Ctrl + D to end");
		
		while(!allowed)
		    {
			if(p.left() > -100000 && p.left() < 100000 && p.right() > -100000 && p.right() < 100000)
			    {
				if(p.operator() == '/' && (p.left() % p.right()) == 0)
				    {
					p.displayProblem();
					allowed = true;
				    }
				else
				    {
					p= new Problem();
					allowed = false;
				    }
			    }
			
		    }
		while(!answered)
		    {
			ans = sc.nextInt();
			count++;
			if(p.correctAnswer()==ans)
			    {
				gm = (((int)Math.random()*3+1));
				switch(gm)
				    {
				    case 1:
					System.out.println("WAY TO GO!!!!");
					sc.nextLine();
					answered = true;
					break;
				    case 2:
					System.out.println("Awesome Job!!!");
					sc.nextLine();
					answered = true;
					break;
				    case 3:
					System.out.println("You're da Bomb!");
					sc.nextLine();
					answered = true;
					break;
				    }
			    }
			else if(count<3)
			    {
				wm = (((int)Math.random()*3+1));
				switch(wm)
				    {
				    case 1:
					System.out.println("Close, try again...");
					sc.nextLine();
					break;
				    case 2:
					System.out.println("You almost had it give it one more shot...");
					sc.nextLine();
					break;
				    case 3:
					System.out.println("You can do this, try it once more...");
					sc.nextLine();
					break;
				    }
			    }
			else if(count >=3)
			    {
				count = 0;
				System.out.println("I'm sorry you're out of tries :( the correct answer is: "+ p.correctAnswer());
				sc.nextLine();
			    }	
		    }
	    }
    }
}