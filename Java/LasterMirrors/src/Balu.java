//Laser Mirrors
//CSE1102 04, Spring 2013
//Nancy Cheng
//4/6/14
//TA: Saahil Moledina
//Section: 007
//Instructor: Jeffrey A. Meunier

import java.util.Scanner;
public class Balu
{
	public static void main(String[] args)
	{
		Balu Bala = new Balu();
		Bala.initialize();
		Bala.show();
		//ask the user what row to fire the laser into
		boolean condition = true;
		Scanner sc = new Scanner(System.in);
		while(condition)
		{
			System.out.println("Fire the laser into row (0 - 9): ");
			fireRow = sc.nextInt();
			//fireRow = sc.nextInt();
			if(fireRow <= 9 && fireRow >= 0)
			{
				condition = false;
			}
			else	
			{
				System.out.println("Error! Enter a number 0 - 9: ");
			}
		}
		Bala.fire();
		Bala.show();
	}

	//my global variables (static)
	static int row;
	static int column;
	static int north = 0;
	static int south = 1;
	static int east = 2;
	static int west = 3;
	//direction = 2, starts east
	static int direction = 2;
	static int fireRow = -1;
	//type[][] arrayName = new type[columnCount][rowCount];
	static String[] initStrings =
		{
		"...../...\\",
		"..\\.......",
		"......./..",
		"..........",
		"........\\.",
		"..........",
		"..........",
		".....\\../.",
		"..\\....../",
		".........."
		};
	static char[][] squares;

	//initialize method will convert the 1D array of strings (initStrings) --> 2D array of characters
	static void initialize()
	{
		//rows[length of array], columns[length of any string in array]
		squares = new char[initStrings.length][initStrings[0].length()];
		for(row = 0; row < initStrings.length; row++)
		{
			column = 0;
			for (column = 0; column < initStrings[row].length(); column++)
			{
				squares[row][column] = initStrings[row].charAt(column);
			}
		}
		//System.out.println(squares[1][2]); WORKS
	}

	//show method displays the contents of the squares array
	public static void show()
	{
		//displays the contents of the squares array
		for(row = 0; row < initStrings.length; row++)
		{
			System.out.print(row);
			//String arrayString = String.valueOf(squares[row]);
			String arrayString = new String(squares[row]);
			if(row == fireRow)
			{
				System.out.print(">");
			}
			else
			{
				System.out.print(" ");
			}
			for(column = 0; column < initStrings[0].length(); column++)
			{
				System.out.print(squares[row][column]);
			}
			System.out.println();
		}
		//String arrayString = new String(squares[0]);
		//System.out.println(arrayString); WORKS
	}

	public static void fire()
	{
		// why can't I use something like char location = squares[row][column];
		column = 0;
		row = fireRow;
		int exitRow = initStrings.length;
		int exitColumn =initStrings[0].toCharArray().length;
		while(row < exitRow && column < exitColumn && column >= 0 && row >=0)
		{
			if(squares[row][column] == '.')
			{
				//north = 0, south = 1
				if(direction == north)
				{
					squares[row][column] = '|';
					row = row - 1;
				}
				else if(direction == south)
				{
					squares[row][column] = '|';
					row = row + 1;
				}
				//east = 2, west = 3
				else if(direction == east)
				{
					squares[row][column] = '-';
					column = column + 1;
				}
				else if(direction == west)
				{
					squares[row][column] = '-';
					column = column - 1;
				}
			}
			else if(squares[row][column] == '\\')
			{
				if(direction == north)
				{
					squares[row][column - 1] = '-';
					direction = west;
					column = column - 1;
				}
				else if(direction == south)
				{
					squares[row][column + 1] = '-';
					direction = east;
					column = column + 1;
				}
				else if(direction == east)
				{
					row = row + 1;
					squares[row][column] = '|';
					direction = south;
				}
				else if(direction == west)
				{
					squares[row - 1][column] = '|';
					direction = north;
					row = row - 1;
				}
			}
			else if(squares[row][column] == '/')
			{
				if(direction == north)
				{
					squares[row][column + 1] = '-';
					direction = east;
					column = column + 1;
				}
				else if(direction == south)
				{
					squares[row][column - 1] = '-';
					direction = west;
					column = column - 1;
				}
				else if(direction == east)
				{
					//for this exception or else there will be a null pointer error
					if(row == 0)
					{
						row = 10;
					}
					squares[row - 1][column] = '|';
					direction = north;
					row = row - 1;
				}
				else if(direction == west)
				{
					squares[row + 1][column] = '|';
					direction = south;
					row = row + 1;
				}
			}
			else if(squares[row][column] == '|')
			{
				if(direction == north)
				{
					row = row - 1;
				}
				else if(direction == south)
				{
					row = row + 1;
				}
				else if(direction == east)
				{
					squares[row][column] = '+';
					column = column + 1;
				}
				else if(direction == west)
				{
					squares[row][column] = '+';
					column = column - 1;
				}
			}
			else if(squares[row][column] == '-')
			{
				if(direction == north)
				{
					squares[row][column] = '+';
					row = row - 1;
				}
				else if(direction == south)
				{
					squares[row][column] = '+';
					row = row + 1;
				}
				else if(direction == east)
				{
					column = column + 1;
				}
				else if(direction == west)
				{
					column = column - 1;
				}
			}
		}
	}
}
