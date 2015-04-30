//Agents and Spaces
//CSE1102 04, Spring 2013
//Nancy Cheng
//2/22/14
//TA: Saahil Moledina
//Section: 007
//Instructor: Jeffrey A. Meunier

public class Main
{
	public static
	void main(String[]args)
	{
		Space GreatHall = new Space();
		GreatHall.setName("Great Hall");
		GreatHall.setDescription("a magnificent dining hall lit by thousands and thousands of candles that were floating in midair over four long tables ");
		
		Space CommonRoom = new Space();
		CommonRoom.setName("Common Room");
		CommonRoom.setDescription("a shared lounge area for each of the four houses ");
		Portal door2 = new Portal();
		door2.setName("door");
		door2.setDirection("outside");
		door2.setDestination(CommonRoom);
		
		Space QuidditchField = new Space();
		QuidditchField.setName("Quidditch Field");
		QuidditchField.setDescription("a field for the wizarding sport played on broomsticks ");
		Portal door1 = new Portal();
		door1.setName("door");
		door1.setDirection("inside");
		door1.setDestination(QuidditchField);
		QuidditchField.setPortal(door2);
		
		Agent a = new Agent();
		a.setName("Harry Potter");
		a.setLocation(GreatHall);
		GreatHall.setPortal(door1);
		CommandInterpreter.run(a);		
	}
}
