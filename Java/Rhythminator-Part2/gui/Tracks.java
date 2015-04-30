//Rhythminator-Part2
//CSE1102 08, Spring 2014
//Nancy Cheng
//4/20/2014
//TA: Saahil Moledina
//Section: 007
//Instructor: Jeffrey A. Meunier

package gui;

import javax.swing.JPanel;

import view.NoteSquare;
import controller.Controller;

public class Tracks extends JPanel
{
	private static final long serialVersionUID = 1L;
	static final int GAP_SIZE = 10;

	public Tracks(Controller controller, int track, int beat)
	{
		int x = 0;
		int y = 0;
		NoteSquare[][] grid = new NoteSquare[track][beat];

		setLayout(null);
		for(int row = 0; row<track; row++)
		{
			for(int column = 0; column < beat; column++)
			{
				grid[row][column] = new NoteSquare(controller, row+1, column+1);
				grid[row][column].setLocation(x, y);
				add(grid[row][column]);
				x = x + NoteSquare.SIZE + GAP_SIZE;
			}
			y = y + NoteSquare.SIZE + GAP_SIZE;
			x = 0;
		}
		this.setSize((NoteSquare.SIZE * beat) + (GAP_SIZE * (beat - 1)),
				((NoteSquare.SIZE * track) + (GAP_SIZE * (track - 1))));
	}
}
