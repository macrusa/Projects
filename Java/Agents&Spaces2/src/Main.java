//Agents and Spaces 2
//CSE1102 04, Spring 2013
//Nancy Cheng
//3/09/14
//TA: Saahil Moledina
//Section: 007
//Instructor: Jeffrey A. Meunier

import java.io.File;
import jeff.imagewindow.ImageWindow;
import jeff.textconsole.TextConsole;

public class Main
{
	public static
	void main(String[]args)
	{
		//Given to us by Jeff
		TextConsole Console = TextConsole.create();
		ImageWindow imageWindow = new ImageWindow();
		File configFile = new File("data", "config.ini");
		ConfigLoader cl = new ConfigLoader(configFile);
		Agent a = cl.buildAll();
		CommandInterpreter.run(a, Console, imageWindow);
	}
}
