import java.util.Scanner;
public class CommandInterpreter 
{
	public static void run(Agent a1)
	{
		Scanner kbd = new Scanner(System.in);
		Boolean control = true;
		System.out.println(a1 + " is in " + a1.getLocation());
		while(control)
		{
			System.out.print("==>");
			String s;
			s = kbd.next();
			if(s.equals("quit"))
			{
				control = false;
			}
			else if(s.equals("help"))
			{
				System.out.println("go: Moves the agent through the space's portal");
				System.out.println("help: Displays a list of all the commands that this program can use");
				System.out.println("look: Displays the long description of the agent's current location");
				System.out.println("where Displays the short description of the agent's current location");
			}
			else if(s.equals("where"))
			{
				Space sw = a1.getLocation();
				String str = sw.toString();
				System.out.println(str);
			}
			else if(s.equals("look"))
			{
				Space sl = a1.getLocation();
				String str = sl.toStringLong();
				System.out.println(str);
			}
			else if(s.equals("go"))
			{		
				a1.usePortal();
			}
			else
			{
				System.out.println("Sorry, I don't understand " + "'" + s + "'" );
			}
		}
	}
}
