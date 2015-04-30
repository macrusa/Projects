//Rhythminator-Part2
//CSE1102 08, Spring 2014
//Nancy Cheng
//4/20/2014
//TA: Saahil Moledina
//Section: 007
//Instructor: Jeffrey A. Meunier

package gui;

import java.awt.Dimension;

import javax.swing.JPanel;

import view.BeatNumberSquare;
import view.NoteSquare;

public class BeatNumbers extends JPanel
{
	private static final long serialVersionUID = 1L;
	private static final int GAP_SIZE = 10;
	private BeatNumberSquare[] _array;

	public BeatNumbers(int beat)
	{
		int x = 0;
		int y = 0;
		_array = new BeatNumberSquare[beat];

		setLayout(null);
		for(int index = 0; index < beat; index++)
		{
			_array[index] = new BeatNumberSquare(index + 1);
			_array[index].setLocation(x, y);
			add(_array[index]);
			x = x + NoteSquare.SIZE + GAP_SIZE;
		}
		this.setSize(((30 * beat) + (GAP_SIZE * (beat - 1))), 30);
	}

	public void setBeatNumber(int beatNumber)
	{
		if(BeatNumberSquare._state == true)
		{
			this.clear();
			_array[beatNumber].setState(true);
		}
		else
		{
			_array[beatNumber].setState(true);
		}
	}

	public void clear()
	{
		for(BeatNumberSquare beat : _array)
		{
			beat.setState(false);
		}
	}
}
