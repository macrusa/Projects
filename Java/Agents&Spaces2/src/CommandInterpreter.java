//Agents and Spaces 2
//CSE1102 04, Spring 2013
//Nancy Cheng
//3/09/14
//TA: Saahil Moledina
//Section: 007
//Instructor: Jeffrey A. Meunier

import java.io.File;
import java.util.Scanner;
import jeff.imagewindow.ImageWindow;
import jeff.textconsole.TextConsole;

public class CommandInterpreter
{
	private static void _showImage(ImageWindow imageWindow, Agent agent)
	{
		String agentlocation = agent.getLocation().getName();
		String imageName = agentlocation + ".jpg";
		File imageDir = new File("data", "images");
		File imageFile = new File(imageDir, imageName);
		imageWindow.loadImage(imageFile);
	}
	public static void run(Agent a1, TextConsole textConsole, ImageWindow window)
	{
		Boolean control = true;
		textConsole.println(a1 + " is in " + a1.getLocation());
		_showImage(window, a1);
		while(control)
		{
			textConsole.print("==>");
			String s;
			s = textConsole.readLine();
			if(s.equals("quit"))
			{
				control = false;
				System.exit(0);
			}
			else if(s.equals("help"))
			{
				textConsole.println("go: Moves the agent through the space's portal");
				textConsole.println("help: Displays a list of all the commands that this program can use");
				textConsole.println("look: Displays the long description of the agent's current location");
				textConsole.println("where Displays the short description of the agent's current location");
			}
			else if(s.equals("where"))
			{
				Space sw = a1.getLocation();
				String str = sw.toString();
				textConsole.println(str);
			}
			else if(s.equals("look"))
			{
				Space sl = a1.getLocation();
				String str = sl.toStringLong();
				textConsole.println(str);
			}
			else if(s.equals("go"))
			{		
				a1.usePortal(textConsole);
				_showImage(window, a1);
			}
			else
			{
				textConsole.println("Sorry, I don't understand " + "'" + s + "'" );
			}
		}
	}
}
