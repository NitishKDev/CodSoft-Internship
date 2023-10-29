import java.util.Random;
import java.util.Scanner;
class Game {
 public void player()
 {
		int roundd=0;
		Scanner sc=new Scanner(System.in);
		while(true)
		{
			int totsc=0;
			roundd++;
		System.out.println();
		 System.out.println("WELCOME TO NUMBER GUESSING GAME -> ROUND "+roundd);
		 System.out.println("Enter option 1 for playing\nEnter option 2 for exit game");
		 int choice=sc.nextInt();
			switch(choice)
			{
				case 1:
				{
					System.out.println("Enter number of attempts you want for this round");
					int flag=sc.nextInt();
					while(true)
					{
						Random ran = new Random();
						int min =1;
						int max =100;
						int r = ran.nextInt(max - min + 1) + min;
						System.out.println("Random number generated successfully between 1 to 100\nEnter your guess");
						int guess=sc.nextInt();
						System.out.println("Random number: " + r);
						if(r==guess)
						  {
						    System.out.println("correct guess");
						    totsc=totsc+1;
						   System.out.println("your score is "+totsc);
						  }
					    if(r>guess)
						   {
							int hi=r-guess;
							   if(hi>10)
								{
								System.out.println("guess is too high");
								}
							else
							   System.out.println("you are close...keep trying");
				   		   }
					    if(guess>r)
					     {
					       int hi=guess-r;
							 if(hi>10)
								{
									System.out.println("guess is too high");
								}
							else
								System.out.println("you are close...keep trying");
						 }
					  flag=flag-1;
					  System.out.println("chance remaining is "+flag);
					  if(flag==0)
						break;
					  System.out.println();
				     }
					System.out.println("Total score  in round " +roundd + " is "+totsc);
					System.out.println("\nTHIS ROUND IS OVER...SELECT OPTION FOR PLAYING MORE ROUND OR YOU CAN EXIT ANYTIME");

				break;
			}
			case 2:System.exit(0);
			default:System.out.println("Enter valid option");
		 }
	}
	}
}
public class RandomGenerator{
   public static void main(String args[])
    {
		Game g1=new Game();
		g1.player();
	}
}
