// Homework #3 Calculator
// CSE 1102-001 Object Orientated Design and Programing Spring 2014
// Nancy Cheng
// Saahil Moledina 007L
// 2-3-14

import java.util.Scanner;

public class Calculator
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		boolean contin = true;
		double accumulator = 0.0;
		while (contin)
		{
			int choice;
			System.out.println("0) Exit");
			System.out.println("1) Addition");
			System.out.println("2) Subtraction");
			System.out.println("3) Multiplication");
			System.out.println("4) Division");
			System.out.println("5) Square root");
			System.out.println("6) Clear");
			System.out.print("What is your choice? ");
			choice = sc.nextInt();
			if (choice == 0)
			{
				contin = false;
			}
			else if(choice == 1)
			{
				System.out.print("Enter a number: ");
				double add = sc.nextDouble();
				accumulator = accumulator+add;
				System.out.println("accumulator = " + accumulator);
			}
			else if(choice == 2)
			{
				System.out.print("Enter a number: ");
				double sub = sc.nextDouble();
				accumulator = accumulator-sub;
				System.out.println("accumulator = " + accumulator);
			}
			else if(choice == 3)
			{
				System.out.print("Enter a number: ");
				double mult = sc.nextDouble();
				accumulator = accumulator*mult;
				System.out.println("accumulator = " + accumulator);
			}
			else if (choice == 4)
			{
				System.out.print("Enter a number: ");
				double divi = sc.nextDouble();
				accumulator = accumulator/divi;
				System.out.println("accumulator = " + accumulator);
			}
			else if (choice == 5)
			{
				if (accumulator < 0)
				{
					System.out.println("Not a real answer");
				}
				else 
				{
					accumulator = Math.sqrt(accumulator);
					System.out.println("accumulator = " + accumulator);
				}
			}
			else if (choice == 6)
			{
				accumulator = 0.0;
				System.out.println("accumulator = " + accumulator);
			}
			else
			{
				System.out.println("Illegal operation: " + choice);
			}
		}
	}
}
